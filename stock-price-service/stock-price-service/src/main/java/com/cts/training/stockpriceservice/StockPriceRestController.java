package com.cts.training.stockpriceservice;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cts.training.stockpriceservice.StockPrice;
import com.cts.training.stockpriceservice.StockPriceRepo;
import com.cts.training.stockpriceservice.StockPriceService;

@RestController
@CrossOrigin(origins="*")
public class StockPriceRestController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	StockPriceRepo stockPriceRepo;
	
	@Autowired
	StockPriceService stockPriceService;
	
	@GetMapping(value="/stockprice",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAllStockPrices(){
		List<StockPrice> list = stockPriceService.getAllStockPrices();
		if(list.size()>0) {
			return new ResponseEntity<List<StockPrice>>(list, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("No Companies found",HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(value = "/stockPrices/companyStockPriceBetween/{companyCode}/{stockExchange}/{startDate}/{endDate}/{periodicity}", 
			produces = "application/json")
	public ResponseEntity<?> getCompanyStockPricePerDayBetween(@PathVariable String companyCode,
			@PathVariable String stockExchange, @PathVariable String startDate,
			@PathVariable String endDate
			) {
		return new ResponseEntity<List<StockPriceOnPeriod>>(stockPriceService.getCompanyStockPriceBetween(companyCode,
				stockExchange, LocalDate.parse(startDate), LocalDate.parse(endDate)), HttpStatus.OK);
	}
	
	@GetMapping(value="/stockprice/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getStockPriceById(@PathVariable int id)
	{
		try {
			StockPrice stockPrice =  stockPriceService.getStockPriceById(id);
			return new ResponseEntity<StockPrice>(stockPrice, HttpStatus.OK);
		}catch(NoSuchElementException e){
			return new ResponseEntity<String>("no such Company", HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping(value="/stockprice")
	public ResponseEntity<StockPrice> save(@RequestBody StockPrice stockPrice)
	{
		stockPriceService.addStockPrice(stockPrice);
		return new ResponseEntity<StockPrice>(stockPrice,HttpStatus.CREATED);		
	}

	@DeleteMapping(value="/stockprice/{id}")
	public void    delete(@PathVariable int id){
		stockPriceRepo.deleteById(id);
	}
	@PutMapping(value = "/stockprice")
	public StockPrice update(@RequestBody StockPrice stockPrice) {
	 StockPrice stock = stockPriceRepo.save(stockPrice);
		return stock;
	}
	
	@PostMapping(value="stockprice/uploadStockSheet",consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
  	public ResponseEntity<?> uploadStockSheet(@RequestParam("stockSheet") MultipartFile file)
  	{
  		logger.info("File Received : {} ",file.getOriginalFilename());
  		if(file.getOriginalFilename().endsWith(".xls") || file.getOriginalFilename().endsWith(".xlsx"))
  		{
  			try 
  			{
  				return new ResponseEntity<ImportSummary>(stockPriceService.addStockPriceFormExcelSheet(file),HttpStatus.OK);
  			}
  			catch(IOException e) 
  			{
  				e.printStackTrace();
  				return new ResponseEntity<String>("Error Reading File :",HttpStatus.BAD_REQUEST);
  			}
  			catch(Exception e) 
  			{
  				e.printStackTrace();
  				return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
  			}
  		}
  			return null;
  	}


	
}
