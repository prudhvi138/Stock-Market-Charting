import { Component, OnInit } from '@angular/core';
import { CompanyService } from 'src/app/services/company.service';
import { Router } from '@angular/router';
import { Company } from 'src/models/company';

@Component({
  selector: 'app-companies',
  templateUrl: './companies.component.html',
  styleUrls: ['./companies.component.css']
})
export class CompaniesComponent implements OnInit {
  constructor(private companyService :CompanyService, private router : Router) {}
  companies:Company[];
  ngOnInit() {

    this.companyService.getAllCompanies().subscribe(data=>{
      this.companies=data;
    })
  }
  deleteCompany(id:number)
  {
    this.companyService.deleteCompany(id).subscribe(data=>{
      this.companies=this.companies.filter(company => company.id !== id);
    });
  }
  updateCompany(company: Company): void {
    localStorage.removeItem('companyId');
    localStorage.setItem('companyId', company.id.toString());
    this.router.navigate(['update-company']);
  }

}
