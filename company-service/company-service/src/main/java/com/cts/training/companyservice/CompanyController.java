package com.cts.training.companyservice;

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
public class CompanyController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CompanyRepo cr;
	@Autowired
	CompanyService companyservice;
	
	@GetMapping("/companyall")
	public ResponseEntity<?>getallcompanies() {
		List<Company> list = companyservice.getAllCompanies();
		if(list.size()>0)
		{
			return new ResponseEntity<List<Company>>(list , HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("No companies found",HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/companyall/{id}")
	public ResponseEntity<Company> getById(@PathVariable int id){
		Company com = companyservice.getCompanyById(id);
		return new ResponseEntity<Company>(com,HttpStatus.OK);
	}
	
	@DeleteMapping("/companyall/{id}")
	public void delete(@PathVariable int id) {
		companyservice.deleteById(id);
	}
	
	@PutMapping("/companyall")
	public ResponseEntity<Company> update(@RequestBody Company companies){
		companyservice.updateCompany(companies);
		return new ResponseEntity<Company>(companies,HttpStatus.OK);
	}

	
	@RequestMapping(value = "/companyall",method = RequestMethod.POST)
	public ResponseEntity<Company> save(@RequestBody Company com){
		companyservice.insert(com);
		return new ResponseEntity<Company>(com,HttpStatus.CREATED);
		
	}
	
	

}
