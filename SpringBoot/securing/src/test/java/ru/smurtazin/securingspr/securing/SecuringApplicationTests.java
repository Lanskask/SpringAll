package ru.smurtazin.securingspr.securing;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SecuringApplicationTests {

	/*private MockMvc mockMvc;
	private IndexController indexController;*/

	@Autowired
	private MockMvc mockMvc;

	@Before
	public void setup() {
		/*indexController = new IndexController();
		mockMvc = MockMvcBuilder.sta*/
	}

	@Test
	public void contextLoads() throws Exception {
		this.mockMvc.perform(get("/")).
				andDo(print()).
				andExpect(status().isOk())
				.andExpect(content().string(containsString("Hello World!")));
	}

}
