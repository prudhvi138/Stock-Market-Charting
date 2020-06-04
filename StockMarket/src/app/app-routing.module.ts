import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import{HomeComponent} from './home/home.component';
import{AdminLandComponent} from './admin/admin-land/admin-land.component';
import { RegisterComponent } from './user/register/register.component';
import { SignComponent } from './user/sign/sign.component';
import { UsersComponent } from './user/users/users.component';
import { UpdateUserComponent } from './user/update-user/update-user.component';
import { CompanyComponent } from './admin/company/company.component';
import {CompaniesComponent} from './admin/companies/companies.component';
import { UserLandComponent } from './user/user-land/user-land.component';
import { CompareCompanyComponent } from './user/compare-company/compare-company.component';
import { ImportDataComponent } from './admin/import-data/import-data.component';
import { IposComponent } from './admin/ipos/ipos.component';
import { StockExchangeComponent } from './admin/stock-exchange/stock-exchange.component';
import { UpdateCompanyComponent } from './admin/update-company/update-company.component';
import { ManageIposComponent } from './admin/manage-ipos/manage-ipos.component';
import { UpdateIpoComponent } from './admin/update-ipo/update-ipo.component';
import { ActivateComponent } from './user/activate/activate.component';
import { ManageExchangeComponent } from './admin/manage-exchange/manage-exchange.component';
import { UpdateStockexchangeComponent } from './admin/update-stockexchange/update-stockexchange.component';
import { UserCompaniesComponent } from './user/user-companies/user-companies.component';
import { UserIposComponent } from './user/user-ipos/user-ipos.component';
import { ChartsComponent } from './user/charts/charts.component';
import { LogoutComponent } from './user/logout/logout.component';
import { LoginGuard } from './login.guard';
import { ContactusComponent } from './admin/contactus/contactus.component';
import { AboutusComponent } from './admin/aboutus/aboutus.component';
const routes: Routes = [{path:'', component:HomeComponent},
                        {path:'admin-land', component:AdminLandComponent,canActivate:[LoginGuard]},
                        {path:'user-land', component:UserLandComponent,canActivate:[LoginGuard]},
                        {path:'register', component: RegisterComponent},
                        {path:'sign', component: SignComponent},
                        {path:'see-users', component: UsersComponent},
                        {path:'update-user', component: UpdateUserComponent},
                        {path:'import-data',component:ImportDataComponent},
                          {path:'company',component:CompanyComponent},
                          {path:'companies',component:CompaniesComponent},
                          {path:'update-company',component:UpdateCompanyComponent},
                          {path:'manage-company',component:CompaniesComponent},
                          {path:'compare-company',component:CompareCompanyComponent},
                          {path:'stock-exchange',component:StockExchangeComponent},
                          {path:'manage-exchange',component:ManageExchangeComponent},
                          {path:'update-stockexchange',component:UpdateStockexchangeComponent},
                           {path:'ipos',component:IposComponent},
                           {path:'manage-ipo',component:ManageIposComponent},
                           {path:'update-ipo',component:UpdateIpoComponent},
                           {path:'activate' ,component:ActivateComponent},
                           {path:'user-companies' ,component:UserCompaniesComponent},
                           {path:'user-ipos' ,component:UserIposComponent},
                            {path:'chart' ,component:ChartsComponent},
                            {path:'logout' ,component:LogoutComponent},
                            {path:'contactus' ,component:ContactusComponent},
                            {path:'aboutus' ,component:AboutusComponent},
                        ];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
