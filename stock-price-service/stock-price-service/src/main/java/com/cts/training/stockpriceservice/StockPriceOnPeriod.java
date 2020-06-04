package com.cts.training.stockpriceservice;

import java.time.LocalDate;

public class StockPriceOnPeriod {
	
	private String companyCode;
	private String stockExchange;
	private String datapoint;
	private double dataValue;
	public StockPriceOnPeriod() {
		super();
	}
	public StockPriceOnPeriod(String companyCode, String stockExchange, String datapoint, double dataValue) {
		super();
		this.companyCode = companyCode;
		this.stockExchange = stockExchange;
		this.datapoint = datapoint;
		this.dataValue = dataValue;
	}
	public StockPriceOnPeriod(String companyCode, String stockExchange, LocalDate datapoint, double dataValue) {
		super();
		this.companyCode = companyCode;
		this.stockExchange = stockExchange;
		this.datapoint = datapoint.toString();
		this.dataValue = dataValue;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getStockExchange() {
		return stockExchange;
	}
	public void setStockExchange(String stockExchange) {
		this.stockExchange = stockExchange;
	}
	public String getDatapoint() {
		return datapoint;
	}
	public void setDatapoint(String datapoint) {
		this.datapoint = datapoint;
	}
	public double getDataValue() {
		return dataValue;
	}
	public void setDataValue(double dataValue) {
		this.dataValue = dataValue;
	}
	
	
	
	

}
