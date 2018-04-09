package com.example.demo;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.Matches;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;





@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyControl.class)
public class DemoApplicationTests {

	private MockMvc mvc;


	@Before
	public void setUp() throws Exception{
		mvc = MockMvcBuilders.standaloneSetup(new MyControl()).build();

	}


	@Test
	public  void  getHello()throws Exception{
		mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("Hello World"));

	}




	@Test
	public void contextLoads() {
	}




}
