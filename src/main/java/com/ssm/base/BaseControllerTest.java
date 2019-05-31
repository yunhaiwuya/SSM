package com.ssm.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

/*@RunWith(SpringJUnit4ClassRunner.class)*/
@WebAppConfiguration
@ContextConfiguration({"classpath:spring/spring-web.xml", "classpath:spring/spring-service.xml",
		"classpath:spring/spring-dao.xml" })
public class BaseControllerTest {

	@Autowired
	protected WebApplicationContext wac;
}
