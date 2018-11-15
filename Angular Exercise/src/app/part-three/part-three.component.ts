import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-part-three',
  templateUrl: './part-three.component.html',
  styleUrls: ['./part-three.component.css']
})
export class PartThreeComponent implements OnInit {
  type1: string;
  type2: string;
  type3: string;
  constructor() { }

  ngOnInit() {
  }

  animals = ['Tiger', 'Dog', 'Lion', 'Elephant'];
  colors = ['Blue', 'Red', 'Yellow', 'Orange'];
  days = ['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday'];

  printAnimals(){
    //this.type = "animal";
  }

  printColors(){
    //this.type2 = "color";
  }

  printDays(){
    //this.type3 = "day";
  }

  displayAnimals() {
    for(var animal in this.animals){
      this.type1 = this.animals[animal];
    }
  }

}
