import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { IPOService } from 'src/app/services/ipo.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-update-ipo',
  templateUrl: './update-ipo.component.html',
  styleUrls: ['./update-ipo.component.css']
})
export class UpdateIpoComponent implements OnInit {
  updateipoForm:FormGroup;
  constructor(private formBuilder:FormBuilder, private ipoService:IPOService,private router:Router) { }
  
  ngOnInit() {
    this.updateipoForm=this.formBuilder.group({
      id:[],
      companyname: ['',Validators.required],
      lse: ['',Validators.required],
      pps: ['',Validators.required],
      tnos: ['',Validators.required],
      odate: ['',Validators.required],
      remarks: ['',Validators.required],
     });
     const id = localStorage.getItem('ipoId');
     if (+id > 0) {
       this. ipoService.getIpoById(+id).subscribe(Ipo => {
         this.updateipoForm.patchValue(Ipo);
       });
     }
   }
   updateIpo() {
     this.ipoService.updateIpo(this.updateipoForm.value).subscribe(data => {
       this.router.navigate(['manage-ipo']);
     },
       error => {
         alert(error);
       });
     }
 }