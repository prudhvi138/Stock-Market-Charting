package com.cts.training.stockexchangeservice;

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
public class StockExchangeController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	StockExchangeRepo stockExchangeRepo;
	@Autowired
	StockExchangeService stockexchangeservice;
	
	@GetMapping("/stockexchangeall")
	public ResponseEntity<?>getallStockExchanges() {
		List<StockExchange> list = stockexchangeservice.getAllStockExchanges();
		if(list.size()>0)
		{
			return new ResponseEntity<List<StockExchange>>(list , HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("No stock exchanges found",HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/stockexchangeall/{id}")
	public ResponseEntity<StockExchange> getById(@PathVariable int id){
		StockExchange se = stockexchangeservice.getStockExchangeById(id);
		return new ResponseEntity<StockExchange>(se,HttpStatus.OK);
	}
	
	@DeleteMapping("/stockexchangeall/{id}")
	public void delete(@PathVariable int id) {
		stockexchangeservice.deleteById(id);
	}
	
	@PutMapping("/stockexchangeall")
	public ResponseEntity<StockExchange> update(@RequestBody StockExchange stockexchange){
		stockexchangeservice.updateStockExchange(stockexchange);
		return new ResponseEntity<StockExchange>(stockexchange,HttpStatus.OK);
	}

	
	@RequestMapping(value = "/stockexchangeall",method = RequestMethod.POST)
	public ResponseEntity<StockExchange> save(@RequestBody StockExchange se){
		stockexchangeservice.insert(se);
		return new ResponseEntity<StockExchange>(se,HttpStatus.CREATED);
		
	}
	
	

}
