package edu.asu.amexgi.rest.grocery.controllers;

import edu.asu.amexgi.rest.grocery.services.GroceryServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class GroceryApi1ApplicationTests {

	@Autowired
	MockMvc mvc;

	@MockBean
	GroceryServices groceryServices;

	@Test
	void getGroceryItemByIdTest() throws Exception {
		mvc.perform(get("/api/groceries/MLK")).andExpect(status().isOk());
	}

	@Test
	void getGroceryItemByIdExceptionTest() throws Exception {
		mvc.perform(get("/api/groceries/MLK1")).andExpect(status().is5xxServerError());
	}
}

