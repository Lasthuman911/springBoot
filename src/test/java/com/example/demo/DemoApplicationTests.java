package com.example.demo;

import com.example.demo.controller.HelloWorldController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	/**
	 * MockMvc实现了对Http请求的模拟，能够直接使用网络的形式，转换到Controller的调用，
	 * 这样可以使得测试速度快、不依赖网络环境，
	 * 而且提供了一套验证的工具，这样可以使得请求的验证统一而且很方便。
	 */
	private MockMvc mvc;

	@Autowired
	private WebApplicationContext context;

	@Before
	public void setUp() throws Exception{
		//单个类  拦截器无效
//		mvc = MockMvcBuilders.standaloneSetup(new HelloWorldController()).build();
		//建议使用这种,项目拦截器有效
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void getHello() throws Exception {
		//isOK :返回状态200
		//print打印出请求和相应的内容
		mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print())
				.andReturn();
	}

}
