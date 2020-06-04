import { Component, OnInit } from '@angular/core';
import { IPOService } from 'src/app/services/ipo.service';
import { Router } from '@angular/router';
import { Ipo } from 'src/models/ipo';

@Component({
  selector: 'app-manage-ipos',
  templateUrl: './manage-ipos.component.html',
  styleUrls: ['./manage-ipos.component.css']
})
export class ManageIposComponent implements OnInit {

  constructor(private ipoService :IPOService, private router : Router) {}
  ipos:Ipo[];
  ngOnInit() {

    this.ipoService.getAllIpos().subscribe(data=>{
      this.ipos=data;
    })
  }
  deleteIpo(id:number)
  {
    this.ipoService.deleteIpo(id).subscribe(data=>{
      this.ipos=this.ipos.filter(ipos => ipos.id !== id);
    }); 
  }
  updateIpo(ipos: Ipo) {
    localStorage.removeItem('ipoId');
    localStorage.setItem('ipoId', ipos.id.toString());
    this.router.navigate(['update-ipo']);
  }

}
