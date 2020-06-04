package com.cts.training.sectorservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
//@FeignClient("user-service")
@FeignClient("netflix-zuul-api-gateway-server")
public interface UserServiceProxy {
	@GetMapping("/user-service/registerall")
	public ResponseEntity<?>getallusers();

}
