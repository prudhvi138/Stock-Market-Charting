package com.cts.training.companyservice;

import java.util.List;
public interface CompanyService {
	public Company insert(Company cd);
	public void deleteById(int id);
	public Company updateCompany(Company companies);
	public List<Company> getAllCompanies();
	public Company getCompanyById(int id);

}
