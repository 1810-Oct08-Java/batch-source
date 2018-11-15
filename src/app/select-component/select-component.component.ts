import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-select-component',
  templateUrl: './select-component.component.html',
  styleUrls: ['./select-component.component.css']
})
export class SelectComponentComponent implements OnInit {
  
  list = [];

  animalCheck = false;
  colorCheck = false;
  daysCheck = false;

  constructor() { }

  ngOnInit() {
  }

  clickAnimal(){
    this.list = ["dog", "cat", "platypus"];
    this.colorCheck = false;
    this.daysCheck = false;
  }
  clickColor(){
    this.list = ["red", "gress", "blue"];
    this.animalCheck = false;
    this.daysCheck = false;
  }
  clickDays(){
    this.list = ["Monday", "Tuesday", "EveryDay"];
    this.colorCheck = false;
    this.animalCheck = false;
    
  }
}
