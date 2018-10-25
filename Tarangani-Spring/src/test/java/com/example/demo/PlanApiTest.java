package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import com.taragani.model.Plan;
import com.taragani.service.PlanService;


public class PlanApiTest {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@MockBean
	private PlanService planServiceMock;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@After
	public void tearDown() {
		mockMvc = null;
	}

	
	@Test
	public void testgetAllPlans() throws Exception {
		assertThat(this.planServiceMock).isNotNull();

		List<Plan> planList = new ArrayList<>();
		planList.add(new Plan());

		when(planServiceMock.getAllPlans()).thenReturn(planList);

		mockMvc.perform(get("/plansTable")).andExpect(status().isOk()).andDo(print());

	}
	
	
	@Test
	public void testgetPlansBySpeed() throws Exception {
		assertThat(this.planServiceMock).isNotNull();

		List<Plan> planList = new ArrayList<>();
		planList.add(new Plan());

		when(planServiceMock.getAllPlans()).thenReturn(planList);

		mockMvc.perform(get("/plansTable")).andExpect(status().isOk()).andDo(print());

	}
	
	
	@Test
	public void testgetPlansByUsage() throws Exception {
		assertThat(this.planServiceMock).isNotNull();

		List<Plan> planList = new ArrayList<>();
		planList.add(new Plan());

		when(planServiceMock.getAllPlans()).thenReturn(planList);

		mockMvc.perform(get("/plansTable")).andExpect(status().isOk()).andDo(print());

	}
	
	
	
}
