import { Component, OnInit } from '@angular/core';
import { IPOService } from 'src/app/services/ipo.service';
import { Router } from '@angular/router';
import { Ipo } from 'src/models/ipo';

@Component({
  selector: 'app-user-ipos',
  templateUrl: './user-ipos.component.html',
  styleUrls: ['./user-ipos.component.css']
})
export class UserIposComponent implements OnInit {

  constructor(private ipoService :IPOService, private router : Router) { }
  ipos:Ipo[];
  ngOnInit() {

    this.ipoService.getAllIpos().subscribe(data=>{
      this.ipos=data;
    })

  }

}
