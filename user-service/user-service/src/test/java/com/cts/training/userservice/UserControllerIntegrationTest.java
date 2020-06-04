package com.cts.training.userservice;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest(classes = UserServiceApplication.class ,
webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@ExtendWith(SpringExtension.class)
public class UserControllerIntegrationTest {
	
	@LocalServerPort
	private int port;
	
	HttpHeaders headers = new HttpHeaders();
	TestRestTemplate restTemplate = new TestRestTemplate(); 
	
	@Test
	public void test() throws Exception {
		String url = "http://localhost:"+port+"/registerall";
		System.out.println("port::"+url);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(null,headers);
		ResponseEntity<String> response = restTemplate.exchange(url,HttpMethod.GET,entity,String.class);
		String expected ="{\"id\": 4,\r\n" + 
				"        \"name\": \"gopi\",\r\n" + 
				"        \"email\": \"gopi123@gmail.com\",\r\n" + 
				"        \"password\": \"gopi@456\",\r\n" + 
				"        \"cpassword\": \"gopi@456\",\r\n" + 
				"        \"regstatus\": null,\r\n" + 
				"        \"active\": null}";
		System.out.println("TEST ::Response body:::: "+response.getBody() );
		assertTrue(response.getBody().contains(expected));
	}

}

