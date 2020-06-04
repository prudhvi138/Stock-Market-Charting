package com.cts.training.companyservice;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@Entity
@Table(name="company")
@XmlRootElement(name = "company")
public class Company implements Serializable {
	
	private static final long serialVersionUID = 997130330271676016L;
	@Id
	@GeneratedValue
	private int id;
	private String companyname;
	private long turnover;
	private String ceo;
	private String bod;
	private String[] lse;
	private String sector;
	private String boc;
	private String stock;
	
	public Company() {
			
	}

	public Company(int id, String companyname, long turnover, String ceo, String bod, String[] lse, String sector, String boc,
			String stock) {
		super();
		this.id = id;
		this.companyname = companyname;
		this.turnover = turnover;
		this.ceo = ceo;
		this.bod = bod;
		this.lse = lse;
		this.sector = sector;
		this.boc = boc;
		this.stock = stock;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public long getTurnover() {
		return turnover;
	}

	public void setTurnover(long turnover) {
		this.turnover = turnover;
	}

	public String getCeo() {
		return ceo;
	}

	public void setCeo(String ceo) {
		this.ceo = ceo;
	}
	

	public String getBod() {
		return bod;
	}

	public void setBod(String bod) {
		this.bod = bod;
	}

	public String[] getLse() {
		return lse;
	}

	public void setLse(String[] lse) {
		this.lse = lse;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getBoc() {
		return boc;
	}

	public void setBoc(String boc) {
		this.boc = boc;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	
	}
