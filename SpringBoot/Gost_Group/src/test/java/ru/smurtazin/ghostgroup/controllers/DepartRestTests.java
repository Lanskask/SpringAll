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
import ru.smurtazin.ghostgroup.model.Department;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@Description(value = "Test for DepartmentsController")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class DepartRestTests {

	private static final String ROOT_URL = "http://localhost:8081";
	private static final String concrPath = "departments";
	RestTemplate restTemplate = new RestTemplate();

	@Test
	public void testGetAllItems() {
		ResponseEntity<Department[]> responseEntity =
				restTemplate.getForEntity(ROOT_URL + "/" + concrPath, Department[].class);
		List<Department> items = Arrays.asList(responseEntity.getBody());
		assertNotNull(items);
	}

	@Test
	public void testGetItemById() {
		Department item = restTemplate.getForObject(ROOT_URL + "/" + concrPath + "/1", Department.class);
		assertNotNull(item);
	}

	@Test
	public void testCreateItem() {
		ResponseEntity<Department[]> beforeResponseEntity =
				restTemplate.getForEntity(ROOT_URL + "/" + concrPath, Department[].class);

		Department item = MyUtils.fakeDepartment();
		ResponseEntity<Department> postResponse =
				restTemplate.postForEntity(ROOT_URL + "/" + concrPath, item, Department.class);

		ResponseEntity<Department[]> afterResponseEntity =
				restTemplate.getForEntity(ROOT_URL + "/" + concrPath, Department[].class);
		assertNotNull(postResponse);
		assertNotNull(postResponse.getBody());
		assertTrue(beforeResponseEntity.getBody().length < afterResponseEntity.getBody().length );
	}

	@Test
	public void testUpdateItem() {
		int id = 1;
		Department item = restTemplate.
				getForObject(ROOT_URL + "/" + concrPath + "/" + id, Department.class);
		item.setType("New Depart Test Type 1");
		/*Department department = restTemplate.
				getForObject(ROOT_URL + "/departments/" + id, Department.class);
		item.setDepartment(department);
		item.setDepartmentDate(new Date());
		item.setTermEnd(MyUtils.addDays(new Date(), 2));*/

		restTemplate.put(ROOT_URL + "/" + concrPath + "/" + id, item);

		Department updatedItem = restTemplate.getForObject(ROOT_URL + "/" + concrPath + "/" + id, Department.class);
		assertEquals(item, updatedItem); // TODO: Is it right written
		assertNotNull(updatedItem);
	}

	@Test
	public void testDeleteItem() {
		int id = 20000;
		Department item = MyUtils.fakeDepartment();
		ResponseEntity<Department> postResponse =
				restTemplate.postForEntity(ROOT_URL + "/" + concrPath, item, Department.class);

		ResponseEntity<Department[]> responseEntity =
				restTemplate.getForEntity(ROOT_URL + "/" + concrPath, Department[].class);
		List<Department> items = Arrays.asList(responseEntity.getBody());

		Integer lastAdded = items.get(items.size() - 1).getId();
		Department item2 = restTemplate.getForObject(ROOT_URL + "/" + concrPath + "/" + lastAdded, Department.class);
		assertNotNull(item2);

		restTemplate.delete(ROOT_URL + "/" + concrPath + "/" + lastAdded);

		try {
			item = restTemplate.getForObject(ROOT_URL + "/" + concrPath + "/" + lastAdded, Department.class);
		} catch (final HttpClientErrorException e) {
			assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
		}
	}

}
