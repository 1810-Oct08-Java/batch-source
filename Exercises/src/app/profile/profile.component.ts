import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  displayName = "Game Character";
  level = 9001;
  name = "Sam";
  surname = "Sung";
  sex = "Male";
  age = 28;
  isHidden = false;
  btnText = "Hide";

  constructor() { }

  ngOnInit() {
  }

  changeDisplay() {
    if (this.isHidden) {
      this.isHidden = false;
      this.btnText = "Hide";
    }
    else {
      this.isHidden = true;
      this.btnText = "Show";
    }
  }

}
