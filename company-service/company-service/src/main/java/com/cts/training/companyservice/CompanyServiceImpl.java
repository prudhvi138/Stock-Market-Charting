package com.cts.training.companyservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
@Service
public class CompanyServiceImpl implements CompanyService {
	
	@Autowired
	CompanyRepo cr;
	public Company insert(Company cd) {
		cr.save(cd);
		return cd;
	}
	
	@Override
	public List<Company> getAllCompanies(){
		
		return cr.findAll();
	}
	
	@Override
	public void deleteById(int id) {
		cr.deleteById(id);
	}
	
	@Override
	public Company updateCompany(Company companies) {
		cr.save(companies);
		return companies;
	}
	@Override
	public Company getCompanyById(int id) {
		Optional<Company> company =cr.findById(id);
		
		return company.orElse(null) ;
	}
	
	


}
