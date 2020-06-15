package com.cognizant.springlearn;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

import com.cognizant.springlearn.controller.CountryController;
import com.cognizant.springlearn.controller.EmployeeController;
import com.google.gson.Gson;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.LinkedHashMap;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@SpringBootTest
@AutoConfigureMockMvc
class SpringLearnApplicationTests {

	@Autowired
	private CountryController countryController;

	@Autowired
	private EmployeeController employeeController;

	@Autowired
	private MockMvc mvc;

	@Test
	void contextLoads() {
		assertNotNull(countryController);
	}

	@Test
	public void testGetCountry() throws Exception {
		ResultActions actions = mvc.perform(get("/country"));
		actions.andExpect(status().isOk());
		actions.andExpect(jsonPath("$.code").exists());
		actions.andExpect(jsonPath("$.code").value("IN"));
	}

	@Test
	public void testGetCountryException() throws Exception {
		ResultActions actions = mvc.perform(get("/countries/xz"));
		actions.andExpect(status().isNotFound());
		actions.andExpect(status().reason("Country not found"));

	}

	@Test
	void employeeContextLoads() {
		assertNotNull(employeeController);
	}

	@Test
	public void testUpdateEmployee() throws Exception {

//		LinkedMultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
//		requestParams.add("id", "1001");
//		requestParams.add("name", "Satyam Kumar");
//		requestParams.add("salary", "45000");
//		requestParams.add("permanent", "temporary");
//		requestParams.add("dateOfBirth", "12/06/1999");
//		
		
		HashMap<String, Object> sessionattr = new HashMap<String, Object>();
		sessionattr.put("id", "1001");
		sessionattr.put("name", "Satyam Kumar");
		sessionattr.put("salary", "45000");
		sessionattr.put("permanent", "temporary");
		sessionattr.put("dateOfBirth", "12/06/1999");
		
		Gson gson = new Gson();
		String json = gson.toJson(sessionattr);
		
		ResultActions actions = mvc.perform(post("/employees")
				.content(json)
				.contentType(MediaType.APPLICATION_JSON)
				).andDo(print());

		actions.andExpect(status().isOk());

	}

}
