import { Component, OnInit } from '@angular/core';
import { visitAll } from '@angular/compiler';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  
  fName = 'tom';
  lName = 'jones';
  visable = false;
  
  constructor() { }

  ngOnInit() {
  }

  change(): void {
    if(this.visable){
      this.visable = false;
    } else {
      this.visable = true;
    }
  }


}
