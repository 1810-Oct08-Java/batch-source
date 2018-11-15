import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-part-one',
  templateUrl: './part-one.component.html',
  styleUrls: ['./part-one.component.css']
})
export class PartOneComponent implements OnInit {
  currentColor: string = "red";
  age: number;
  
  constructor() { }

  ngOnInit() {
  }

  mouseOver(){
    this.currentColor = "blue";
  }

  mouseAway(){
    this.currentColor = "red";
  }

}
