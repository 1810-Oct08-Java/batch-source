import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-select',
  templateUrl: './select.component.html',
  styleUrls: ['./select.component.css']
})
export class SelectComponent implements OnInit {

  animals = ['Cat', 'Dog' , 'Mouse', 'Bird'];
  colors = ['Red', 'Green', 'Blue'];
  days = ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'];
  showAnim = false;
  showColr = false;
  showDay = false;

  constructor() { }

  ngOnInit() {
  }
  showAnimals() {
    this.showAnim = true;
    this.showColr = false;
    this.showDay = false;
  }
  showColors() {
    this.showAnim = false;
    this.showColr = true;
    this.showDay = false;
  }
  showDays() {
    this.showAnim = false;
    this.showColr = false;
    this.showDay = true;
  }


}
