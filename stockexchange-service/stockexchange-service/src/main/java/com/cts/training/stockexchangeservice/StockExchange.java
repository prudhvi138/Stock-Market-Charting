package com.cts.training.stockexchangeservice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@Entity
@Table(name="stock")
@XmlRootElement (name="item")
public class StockExchange {
	
@Id
@GeneratedValue
	private int id;
	private String stock;
	private String brief;
	private String address;
	private String remarks;

	public StockExchange() {
		
		}

	public StockExchange(int id, String stock, String brief, String address, String remarks) {
		super();
		this.id = id;
		this.stock = stock;
		this.brief = brief;
		this.address = address;
		this.remarks = remarks;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	

	
}
