package com.abdul_Codefellowship.codefellowship;


import com.abdul_Codefellowship.codefellowship.nytimes.News;
import com.abdul_Codefellowship.codefellowship.nytimes.NewsWriter;

import com.abdul_Codefellowship.codefellowship.controller.*;

import com.abdul_Codefellowship.codefellowship.model.*;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;


import java.io.IOException;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@SpringBootTest
@AutoConfigureMockMvc

class CodefellowshipApplicationTests {
	@Autowired
	MockMvc mockMvc;

	// Testing the Controllers
	@Test
	void HomeControllerContextLoads() {
		HomeController sut = new HomeController();
		assertNotNull(sut,"Controller was null");
	}

	@Test
	void AppControllerContextLoads() {
		AppController sut = new AppController();
		assertNotNull(sut,"Controller was null");
	}

	@Test
	void PostControllerContextLoads() {
		PostController sut = new PostController();
		assertNotNull(sut,"Controller was null");
	}

	// Testing the Models

	@Test
	void AppUserModel_Test() {
		AppUser sut = new AppUser();
		sut.setFirstName("Abdulahi");

		assertEquals("Abdulahi",sut.getFirstName());
	}

	@Test
	void PostModel_Test() {
		Post sut =new Post("Test");
		assertEquals("Test",sut.getText());
	}

	@Test

	public void testNews() throws IOException {
		NewsWriter sut = new NewsWriter();
		News x = sut.newsReport();
		return;
	}


	void ReplyModel_Test()
	{
		Reply sut = new Reply("Test");
		assertEquals("Test",sut.getReply());
	}


	// Testing all non-authentication routes
	@Test
	void IndexRouteWorks () throws Exception
	{
		mockMvc.perform(get("/")).andDo(print())
				.andExpect(content().string(containsString("<title>Welcome Page</title>")))
				.andExpect(status().isOk());
	}


	@Test
	void LoginRouteWorks () throws Exception
	{
		mockMvc.perform(get("/login")).andDo(print())
				.andExpect(content().string(containsString("<h1>Login</h1>")))
				.andExpect(status().isOk());
	}

	@Test
	void SignInRouteWorks () throws Exception
	{
		mockMvc.perform(get("/signup")).andDo(print())
				.andExpect(content().string(containsString("<h1>Sign Up!</h1>")))
				.andExpect(status().isOk());
	}





}
