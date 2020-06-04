package com.cts.training.initialpublicofferingservice;

import java.util.List;

public interface IPOService {
	public IPO insert(IPO se);
	public void deleteById(int id);
	public IPO updateIPO(IPO IPO);
	public List<IPO> getAllIPOs();
	public IPO getIPOById(int id);

}
