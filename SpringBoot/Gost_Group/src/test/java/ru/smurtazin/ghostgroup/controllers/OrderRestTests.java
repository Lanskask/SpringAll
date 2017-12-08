package ru.smurtazin.ghostgroup.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Description;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import ru.smurtazin.ghostgroup.model.Order;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@Description(value = "Test for OrdersController")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class OrderRestTests {

	private static final String ROOT_URL = "http://localhost:8081";
	private static final String ordersPath = "orders";
	RestTemplate restTemplate = new RestTemplate();

	@Test
	public void testGetAllItems() {
		ResponseEntity<Order[]> responseEntity =
				restTemplate.getForEntity(ROOT_URL + "/" + ordersPath, Order[].class);
		List<Order> items = Arrays.asList(responseEntity.getBody());
		assertNotNull(items);
	}

	@Test
	public void testGetItemById() {
		Order item = restTemplate.getForObject(ROOT_URL + "/" + ordersPath + "/1", Order.class);
		assertNotNull(item);
	}

	@Test
	public void testCreateItem() {
		ResponseEntity<Order[]> responseEntity =
				restTemplate.getForEntity(ROOT_URL + "/" + ordersPath, Order[].class);

		Order item = MyUtils.fakeOrder();
		ResponseEntity<Order[]> postResponse =
				restTemplate.postForEntity(ROOT_URL + "/" + ordersPath, item, Order[].class);

		assertNotNull(postResponse);
		assertNotNull(postResponse.getBody());
		assertTrue(responseEntity.getBody().length < postResponse.getBody().length );
	}

	@Test
	public void testUpdateItem() {
		int id = 1;
		Order item = restTemplate.
				getForObject(ROOT_URL + "/" + ordersPath + "/" + id, Order.class);
		item.setName("NEW NEW NAME of Order");
		/*Department department = restTemplate.
				getForObject(ROOT_URL + "/departments/" + id, Department.class);
		item.setDepartment(department);
		item.setOrderDate(new Date());
		item.setTermEnd(MyUtils.addDays(new Date(), 2));*/

		restTemplate.put(ROOT_URL + "/" + ordersPath + "/" + id, item);

		Order updatedItem = restTemplate.getForObject(ROOT_URL + "/" + ordersPath + "/" + id, Order.class);
		assertEquals(item, updatedItem); // TODO: Is it right written
		assertNotNull(updatedItem);
	}

	@Test
	public void testDeleteItem() {
		int id = 2;
		Order item = restTemplate.getForObject(ROOT_URL + "/" + ordersPath + "/" + id, Order.class);
		assertNotNull(item);

		restTemplate.delete(ROOT_URL + "/" + ordersPath + "/" + id);

		try {
			item = restTemplate.getForObject(ROOT_URL + "/" + ordersPath + "/" + id, Order.class);
		} catch (final HttpClientErrorException e) {
			assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
		}
	}

}
