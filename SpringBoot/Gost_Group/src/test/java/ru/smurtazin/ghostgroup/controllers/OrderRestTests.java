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
	private static final String concrPath = "orders";
	RestTemplate restTemplate = new RestTemplate();

	@Test
	public void testGetAllItems() {
		ResponseEntity<Order[]> responseEntity =
				restTemplate.getForEntity(ROOT_URL + "/" + concrPath, Order[].class);
		List<Order> items = Arrays.asList(responseEntity.getBody());
		assertNotNull(items);
	}

	@Test
	public void testGetItemById() {
		Order item = restTemplate.getForObject(ROOT_URL + "/" + concrPath + "/1", Order.class);
		assertNotNull(item);
	}

	@Test
	public void testCreateItem() {
		ResponseEntity<Order[]> beforeResponseEntity =
				restTemplate.getForEntity(ROOT_URL + "/" + concrPath, Order[].class);

		Order item = MyUtils.fakeOrder();
		ResponseEntity<Order> postResponse =
				restTemplate.postForEntity(ROOT_URL + "/" + concrPath, item, Order.class);

		ResponseEntity<Order[]> afterResponseEntity =
				restTemplate.getForEntity(ROOT_URL + "/" + concrPath, Order[].class);
		assertNotNull(postResponse);
		assertNotNull(postResponse.getBody());
		assertTrue(beforeResponseEntity.getBody().length < afterResponseEntity.getBody().length );
	}

	@Test
	public void testUpdateItem() {
		int id = 1;
		Order item = restTemplate.
				getForObject(ROOT_URL + "/" + concrPath + "/" + id, Order.class);
		item.setName("NEW NEW NAME of Order");
		/*Department department = restTemplate.
				getForObject(ROOT_URL + "/departments/" + id, Department.class);
		item.setDepartment(department);
		item.setOrderDate(new Date());
		item.setTermEnd(MyUtils.addDays(new Date(), 2));*/

		restTemplate.put(ROOT_URL + "/" + concrPath + "/" + id, item);

		Order updatedItem = restTemplate.getForObject(ROOT_URL + "/" + concrPath + "/" + id, Order.class);
		assertEquals(item, updatedItem); // TODO: Is it right written
		assertNotNull(updatedItem);
	}

	@Test
	public void testDeleteItem() {
		int id = 20000;
		Order item = MyUtils.fakeOrder();
		ResponseEntity<Order> postResponse =
				restTemplate.postForEntity(ROOT_URL + "/" + concrPath, item, Order.class);

		ResponseEntity<Order[]> responseEntity =
				restTemplate.getForEntity(ROOT_URL + "/" + concrPath, Order[].class);
		List<Order> items = Arrays.asList(responseEntity.getBody());

		Integer lastAdded = items.get(items.size() - 1).getId();
		Order item2 = restTemplate.getForObject(ROOT_URL + "/" + concrPath + "/" + lastAdded, Order.class);
		assertNotNull(item2);

		restTemplate.delete(ROOT_URL + "/" + concrPath + "/" + lastAdded);

		try {
			item = restTemplate.getForObject(ROOT_URL + "/" + concrPath + "/" + lastAdded, Order.class);
		} catch (final HttpClientErrorException e) {
			assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
		}
	}

}
