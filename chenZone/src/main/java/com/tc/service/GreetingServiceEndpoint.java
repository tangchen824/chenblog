package com.tc.service;
import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.tc.service.GreetingService;
@Service("greetingServiceEndpoint")
@WebService(serviceName="GreetingService")

public class GreetingServiceEndpoint{

	@Autowired
	private GreetingService greetingService;

	@WebMethod
	public String sayHello() {
		return greetingService.sayHello();
	}

}