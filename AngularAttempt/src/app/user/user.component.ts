import { Component, OnInit } from '@angular/core';
import { imps } from '../mock-users';
import { User } from '../model/user';



@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  users = imps;
  selectUser: User;

  constructor() { }

  ngOnInit() {
  }

  onSelect(user: User): void {
    this.selectUser = user;
  }

}
