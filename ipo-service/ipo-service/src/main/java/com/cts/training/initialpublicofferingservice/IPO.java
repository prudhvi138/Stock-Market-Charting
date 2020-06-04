package com.cts.training.initialpublicofferingservice;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "ipos")
@Component(value="ipo")
public class IPO implements Serializable {
	private static final long serialVersionUID = 3233561359381788928L;
	@Id
	@GeneratedValue
	private int id;
	private String companyname;
	private String[] lse;
	private double pps;
	private int tnos;
	private Date odate;
	private String remarks;
	public IPO() {
		
	}
	public IPO(int id, String companyname, String[] lse, double pps, int tnos, Date odate, String remarks) {
		super();
		this.id = id;
		this.companyname = companyname;
		this.lse = lse;
		this.pps = pps;
		this.tnos = tnos;
		this.odate = odate;
		this.remarks = remarks;
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
	public String[] getLse() {
		return lse;
	}
	public void setLse(String[] lse) {
		this.lse = lse;
	}
	public double getPps() {
		return pps;
	}
	public void setPps(double pps) {
		this.pps = pps;
	}
	public int getTnos() {
		return tnos;
	}
	public void setTnos(int tnos) {
		this.tnos = tnos;
	}
	public Date getOdate() {
		return odate;
	}
	public void setOdate(Date odate) {
		this.odate = odate;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	}
