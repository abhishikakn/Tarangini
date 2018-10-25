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

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.taragani.model.Customer;
import com.taragani.service.CustomerService;
import com.trangani.TestUtil.TestUtil;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;



public class CustomerApiTest {
	
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@MockBean
	private CustomerService customerServiceMock;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@After
	public void tearDown() {
		mockMvc = null;
	}

	
	@Test
	public void testgetAllCustomers() throws Exception {
		assertThat(this.customerServiceMock).isNotNull();

		List<Customer> custList = new ArrayList<>();
		custList.add(new Customer());

		when(customerServiceMock.getAllCustomers()).thenReturn(custList);

		mockMvc.perform(get("/customersTable")).andExpect(status().isOk()).andDo(print());

	}
	
	

	@Test
	public void getCustomerByName() throws Exception {
		assertThat(this.customerServiceMock).isNotNull();
		String custName = "Kevin";
	

		Customer custAdded = new Customer();

		custAdded.setCid(13);
		custAdded.setName("Kevin");
		custAdded.setpTitle("Plan A");
		custAdded.setMbno("5623145236");
		custAdded.setTimeSlot("6pm-9pm");
		custAdded.setAddress("39,hudson street");

		when(customerServiceMock.getCustomerByName(custAdded.getName())).thenReturn(custAdded);

		mockMvc.perform(get("/Employees/13")).andExpect(status().isOk()).andDo(print());

	}

/*

	@Test
	public void testaddCustomer() throws Exception {
		assertThat(this.customerServiceMock).isNotNull();

		Customer cust = new Customer();

		cust.setCid(13);
		cust.setName("Kevin");
		cust.setpTitle("Plan A");
		cust.setMbno("5623145236");
		cust.setTimeSlot("6pm-9pm");
		cust.setAddress("39,hudson street");

		Customer custAdded = new Customer();

		custAdded.setCid(13);
		custAdded.setName("Kevin");
		custAdded.setpTitle("Plan A");
		custAdded.setMbno("5623145236");
		custAdded.setTimeSlot("6pm-9pm");
		custAdded.setAddress("39,hudson street");

		System.out.println(cust);
		
		when(customerServiceMock.addCustomer(Mockito.any(Customer.class))).thenReturn(custAdded);


		mockMvc.perform(post("/customersTable").contentType(TestUtil.APPLICATION_JSON_UTF8)
				.content(TestUtil.convertObjectToJsonBytes(cust))).andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8));

	}

	@Test
	public void testUpdateCustomer() throws Exception {
		assertThat(this.customerServiceMock).isNotNull();

		Customer cust = new Customer();

		cust.setCid(15);
		cust.setName("Randal");
		cust.setpTitle("Plan A");
		cust.setMbno("1236548756");
		cust.setTimeSlot("6pm-9pm");
		cust.setAddress("50,margin street");

		String name = "Randal";
		

		Customer custAdded = new Customer();

		custAdded.setCid(13);
		custAdded.setName("Kevin");
		custAdded.setpTitle("Plan A");
		custAdded.setMbno("5623145236");
		custAdded.setTimeSlot("6pm-9pm");
		custAdded.setAddress("39,hudson street");


		when(customerServiceMock.updateCustomer(Mockito.any(Customer.class))).thenReturn(cust);

		mockMvc.perform(put("/customersTable").contentType(TestUtil.APPLICATION_JSON_UTF8)
				.content(TestUtil.convertObjectToJsonBytes(cust))).andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8));


	}

	@Test
	public void testremoveCustomer() throws Exception {
		assertThat(this.customerServiceMock).isNotNull();

		int cid = 10;

		when(customerServiceMock.removeCustomer(cid)).thenReturn(true);

		mockMvc.perform(delete("/Employees/10")).andExpect(status().isOk()).andDo(print());

	}
	*/



}
