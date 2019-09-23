package ru.smurtazin.loan.loanapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import ru.smurtazin.loan.loanapp.models.User;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class UserRestTests {

	private static final String ROOT_URL = "http://localhost:8081";
	RestTemplate restTemplate = new RestTemplate();

	@Test
	public void testGetAllUsers() {
		ResponseEntity<User[]> responseEntity =
				restTemplate.getForEntity(ROOT_URL + "/users", User[].class);
		List<User> users = Arrays.asList(responseEntity.getBody());
		assertNotNull(users);
	}

	@Test
	public void testGetUserById() {
		User user = restTemplate.getForObject(ROOT_URL + "/users/1", User.class);
		assertNotNull(user);
	}

	@Test
	public void testCreateUser() {
		User user = new User("name1", "surname1");
		ResponseEntity<User[]> postResponse =
				restTemplate.postForEntity(ROOT_URL + "/users", user, User[].class);
		assertNotNull(postResponse);
		assertNotNull(postResponse.getBody());
	}

	@Test
	public void testUpdateUser() {
		int id = 1;
		User user = restTemplate.
				getForObject(ROOT_URL + "/users/" + id, User.class);
		user.setName("name33");
		user.setSurname("surname33");

		restTemplate.put(ROOT_URL + "/users/" + id, user);

		User updatetUser = restTemplate.getForObject(ROOT_URL + "/users/" + id, User.class);
		assertNotNull(updatetUser);
	}

	@Test
	public void testDeleteUser() {
		int id = 2;
		User user = restTemplate.getForObject(ROOT_URL + "/users/" + id, User.class);
		assertNotNull(user);

		restTemplate.delete(ROOT_URL + "/users/" + id);

		try {
			user = restTemplate.getForObject(ROOT_URL + "/users/" + id, User.class);

		} catch (final HttpClientErrorException e) {
			assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
		}
	}

}
