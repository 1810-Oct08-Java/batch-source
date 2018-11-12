import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-select-component3',
  templateUrl: './select-component3.component.html',
  styleUrls: ['./select-component3.component.css']
})
export class SelectComponent3Component implements OnInit {
  Select ="";
  Array = [];

  constructor() { }

  ngOnInit() {
  }

  animal = ["Cat","Dog","Ferret"];
  color = ["Black","Blue","Purple"];
  days =["Friday","Saturday","Sunday"];

  selectAnimal(){
    this.Select = "animal";
    this.itemSelected();
  }
  selectColor(){
    this.Select = "color";
    this.itemSelected();
  }
  selectDay(){
    this.Select = "day";
    this.itemSelected();
  }

  itemSelected(){
  if(this.Select === "animal"){
      this.Array = this.animal;
  }
  else if(this.Select === "color"){
    this.Array = this.color;
  }
  else{
    this.Array = this.days;
  }
  }
}
