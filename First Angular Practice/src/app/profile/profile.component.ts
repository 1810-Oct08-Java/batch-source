import { Component, OnInit } from '@angular/core';

import { User } from '../models/user'

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

	displayProfile:boolean = false;

	user : User = {
		ID: 1,
		Name: 'Jessica B Peterson',
		Age: 48,
		Sex: 'Female',
		Ethnicity: 'German'
	}	

  constructor() { }

  ngOnInit() {
  }

    toggleButton() {
    this.displayProfile = !this.displayProfile;
  }
  
  toggleText(): string {
    return this.displayProfile ? "Hide" : "Show";
  }

}
