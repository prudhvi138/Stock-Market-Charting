package com.cts.training.stockexchangeservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StockExchangeServiceImpl implements StockExchangeService {
	@Autowired
	StockExchangeRepo stockExchangeRepo;
	public StockExchange insert(StockExchange se) {
		stockExchangeRepo.save(se);
		return se;
	}
	
	@Override
	public List<StockExchange> getAllStockExchanges(){
		
		return stockExchangeRepo.findAll();
	}
	
	@Override
	public void deleteById(int id) {
		stockExchangeRepo.deleteById(id);
	}
	
	@Override
	public StockExchange updateStockExchange(StockExchange stockexchanges) {
		stockExchangeRepo.save(stockexchanges);
		return stockexchanges;
	}
	@Override
	public StockExchange getStockExchangeById(int id) {
		Optional<StockExchange> StockExchange =stockExchangeRepo.findById(id);
		
		return StockExchange.orElse(null) ;
	}
	
	



}
