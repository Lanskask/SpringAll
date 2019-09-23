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
import ru.smurtazin.ghostgroup.model.Employee;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@Description(value = "Test for EmployeesController")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class EmployeeRestTests {

	private static final String ROOT_URL = "http://localhost:8081";
	private static final String concrPath = "employees";
	RestTemplate restTemplate = new RestTemplate();

	@Test
	public void testGetAllItems() {
		ResponseEntity<Employee[]> responseEntity =
				restTemplate.getForEntity(ROOT_URL + "/" + concrPath, Employee[].class);
		List<Employee> items = Arrays.asList(responseEntity.getBody());
		assertNotNull(items);
	}

	@Test
	public void testGetItemById() {
		Employee item = restTemplate.getForObject(ROOT_URL + "/" + concrPath + "/1", Employee.class);
		assertNotNull(item);
	}

	@Test
	public void testCreateItem() {
		ResponseEntity<Employee[]> beforeResponseEntity =
				restTemplate.getForEntity(ROOT_URL + "/" + concrPath, Employee[].class);

		Employee item = MyUtils.fakeEmployee();
		ResponseEntity<Employee> postResponse =
				restTemplate.postForEntity(ROOT_URL + "/" + concrPath, item, Employee.class);

		ResponseEntity<Employee[]> afterResponseEntity =
				restTemplate.getForEntity(ROOT_URL + "/" + concrPath, Employee[].class);
		assertNotNull(postResponse);
		assertNotNull(postResponse.getBody());
		assertTrue(beforeResponseEntity.getBody().length < afterResponseEntity.getBody().length );
	}

	@Test
	public void testUpdateItem() {
		int id = 1;
		Employee item = restTemplate.
				getForObject(ROOT_URL + "/" + concrPath + "/" + id, Employee.class);
		item.setFullName("Test fullNme Employee");
		/*Department department = restTemplate.
				getForObject(ROOT_URL + "/departments/" + id, Department.class);
		item.setDepartment(department);
		item.setEmployeeDate(new Date());
		item.setTermEnd(MyUtils.addDays(new Date(), 2));*/

		restTemplate.put(ROOT_URL + "/" + concrPath + "/" + id, item);

		Employee updatedItem = restTemplate.getForObject(ROOT_URL + "/" + concrPath + "/" + id, Employee.class);
		assertEquals(item, updatedItem); // TODO: Is it right written
		assertNotNull(updatedItem);
	}

	@Test
	public void testDeleteItem() {
		int id = 20000;
		Employee item = MyUtils.fakeEmployee();
		ResponseEntity<Employee> postResponse =
				restTemplate.postForEntity(ROOT_URL + "/" + concrPath, item, Employee.class);

		ResponseEntity<Employee[]> responseEntity =
				restTemplate.getForEntity(ROOT_URL + "/" + concrPath, Employee[].class);
		List<Employee> items = Arrays.asList(responseEntity.getBody());

		Integer lastAdded = items.get(items.size() - 1).getId();
		Employee item2 = restTemplate.getForObject(ROOT_URL + "/" + concrPath + "/" + lastAdded, Employee.class);
		assertNotNull(item2);

		restTemplate.delete(ROOT_URL + "/" + concrPath + "/" + lastAdded);

		try {
			item = restTemplate.getForObject(ROOT_URL + "/" + concrPath + "/" + lastAdded, Employee.class);
		} catch (final HttpClientErrorException e) {
			assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
		}
	}

}
