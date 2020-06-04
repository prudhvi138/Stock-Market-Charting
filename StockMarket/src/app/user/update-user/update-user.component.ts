import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { UserService } from 'src/app/services/user.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrls: ['./update-user.component.css']
})
export class UpdateUserComponent implements OnInit {
  updateUserForm: FormGroup;
  constructor(private formBuilder: FormBuilder, private userService: UserService, private router : Router) { }

  ngOnInit() {
    this.updateUserForm = this.formBuilder.group({
      id: [],
      name: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required],
      cpassword: ['', Validators.required],
      active:['']

    });

    const id = localStorage.getItem('userId');
    if (+id > 0) {
      this.userService.getUserById(+id).subscribe(User => {
        this.updateUserForm.patchValue(User);
      });
    }
  }
  updateUser() {
    this.userService.updateUser(this.updateUserForm.value).subscribe(data => {
      this.router.navigate(['see-users']);
    },
      error => {
        alert(error);
      });
  }
}
