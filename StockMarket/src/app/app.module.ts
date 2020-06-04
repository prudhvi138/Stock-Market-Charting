import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { RegisterComponent } from './user/register/register.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { SignComponent } from './user/sign/sign.component';
import { UsersComponent } from './user/users/users.component';
import { UpdateUserComponent } from './user/update-user/update-user.component';
import { AdminLandComponent } from './admin/admin-land/admin-land.component';
import { CompanyComponent } from './admin/company/company.component';
import { CompaniesComponent } from './admin/companies/companies.component';
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
import { HighchartsChartComponent } from 'highcharts-angular';
import { LogoutComponent } from './user/logout/logout.component';
import { HttpInterceptorService } from './services/http-interceptor.service';
import { ContactusComponent } from './admin/contactus/contactus.component';
import { AboutusComponent } from './admin/aboutus/aboutus.component';
import { UserProfileComponent } from './user/user-profile/user-profile.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    RegisterComponent,
    SignComponent,
    UsersComponent,
    UpdateUserComponent,
    AdminLandComponent,
    CompanyComponent,
    CompaniesComponent,
    UserLandComponent,
    CompareCompanyComponent,
    ImportDataComponent,
    IposComponent,
    StockExchangeComponent,
    UpdateCompanyComponent,
    ManageIposComponent,
    UpdateIpoComponent,
    ActivateComponent,
    ManageExchangeComponent,
    UpdateStockexchangeComponent,
    UserCompaniesComponent,
    UserIposComponent,
    ChartsComponent,
    HighchartsChartComponent,
    LogoutComponent,
    ContactusComponent,
    AboutusComponent,
    UserProfileComponent,
    

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: HttpInterceptorService,
      multi: true
    }

  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
