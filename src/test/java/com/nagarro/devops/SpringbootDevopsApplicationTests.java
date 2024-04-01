package com.nagarro.devops;

import com.nagarro.devops.controllers.UserController;
import com.nagarro.devops.models.User;
import com.nagarro.devops.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
class SpringbootDevopsApplicationTests {
	private MockMvc mockMvc;

	@Mock
	private UserService userService;
	@InjectMocks
	private UserController userController;
	private List<User> users;
	@BeforeEach
	private void setUp() {
		this.mockMvc= MockMvcBuilders.standaloneSetup(userController).build();
		users = new ArrayList<>();
		users.add(new User("John Doe","Male","United States","johndoe@example.com","12345","01/01/1990","1234567890"));
		users.add(new User("Jane Smith","Female","United Kingdom","janesmith@example.com","54321","02/02/1995","0987654321"));
		users.add(new User());
	}

	@Test
	public void getUserTest_success() throws Exception {

		Mockito.when(userService.getAllUsers()).thenReturn(users);

		this.mockMvc.perform(get("/users")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	public void getUserTest_Data() throws  Exception{
		Mockito.when(userService.getAllUsers()).thenReturn(users);

		this.mockMvc.perform(get("/users")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$[0].name",is("John Doe")));
	}
}
