package com.cts.training.stockexchangeservice;

import java.util.List;


public interface StockExchangeService {
	public StockExchange insert(StockExchange se);
	public void deleteById(int id);
	public StockExchange updateStockExchange(StockExchange stockexchange);
	public List<StockExchange> getAllStockExchanges();
	public StockExchange getStockExchangeById(int id);

}
