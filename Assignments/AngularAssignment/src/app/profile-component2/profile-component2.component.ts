import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-profile-component2',
  templateUrl: './profile-component2.component.html',
  styleUrls: ['./profile-component2.component.css']
})
export class ProfileComponent2Component implements OnInit {
  buttonTitle = "Show";

  constructor() { }

  ngOnInit() {
  }

  user={
    "HeroName":"Daredevil",
    "Power":"Super Hearing"
  }

  click(){
    if(this.buttonTitle === "Show"){
      this.buttonTitle = "Hide",
      this.user.HeroName = "DareDevil",
      this.user.Power ="Super Hearing"
    }else{
      this.buttonTitle = "Show",
      this.user.HeroName = "",
      this.user.Power = ""

    }
  }

}
