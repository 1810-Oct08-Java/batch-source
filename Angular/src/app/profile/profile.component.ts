import { Component, OnInit } from '@angular/core';
import { User } from '../models/user';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  currentUser: User = {
    userName: 'abcd',
    firstName: 'John',
    lastName: 'Doe'
  };

  displayBool: Boolean = true;
  buttonText: String = 'Hide';

  constructor() { }

  ngOnInit() {
  }

  toggleText() {
    this.displayBool = !this.displayBool;
    if (this.buttonText == 'Hide') {
      this.buttonText = 'Show';
    } else {
      this.buttonText = 'Hide';
    }
  }
}
