package com.cts.training.initialpublicofferingservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class IPOServiceImpl implements IPOService {
	@Autowired
	IPORepo ipoRepo;
	public IPO insert(IPO se) {
		ipoRepo.save(se);
		return se;
	}
	
	@Override
	public List<IPO> getAllIPOs(){
		
		return ipoRepo.findAll();
	}
	
	@Override
	public void deleteById(int id) {
		ipoRepo.deleteById(id);
	}
	
	@Override
	public IPO updateIPO(IPO ipos) {
		ipoRepo.save(ipos);
		return ipos;
	}
	@Override
	public IPO getIPOById(int id) {
		Optional<IPO> IPO =ipoRepo.findById(id);
		
		return IPO.orElse(null) ;
	}
	
	




}
