package com.cts.training.initialpublicofferingservice;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="*")
@RestController
public class IPOController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	IPORepo ipoRepo;
	@Autowired
	IPOService iposervice;
	
	@GetMapping("/ipoall")
	public ResponseEntity<?>getallIPOs() {
		List<IPO> list = iposervice.getAllIPOs();
		if(list.size()>0)
		{
			return new ResponseEntity<List<IPO>>(list , HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("No stock exchanges found",HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/ipoall/{id}")
	public ResponseEntity<IPO> getById(@PathVariable int id){
		IPO se = iposervice.getIPOById(id);
		return new ResponseEntity<IPO>(se,HttpStatus.OK);
	}
	
	@DeleteMapping("/ipoall/{id}")
	public void delete(@PathVariable int id) {
		iposervice.deleteById(id);
	}
	
	@PutMapping("/ipoall")
	public ResponseEntity<IPO> update(@RequestBody IPO ipos){
		iposervice.updateIPO(ipos);
		return new ResponseEntity<IPO>(ipos,HttpStatus.OK);
	}

	
	@RequestMapping(value = "/ipoall",method = RequestMethod.POST)
	public ResponseEntity<IPO> save(@RequestBody IPO ipos){
		iposervice.insert(ipos);
		return new ResponseEntity<IPO>(ipos,HttpStatus.CREATED);
		
	}
	
	
	

}
