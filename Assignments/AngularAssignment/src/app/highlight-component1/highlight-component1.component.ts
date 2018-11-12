import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-highlight-component1',
  templateUrl: './highlight-component1.component.html',
  styleUrls: ['./highlight-component1.component.css']
})
export class HighlightComponent1Component implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  myStyle = {
    'background-color':"blue",
    'color':"white"
    }

    mouseover(){
      this.myStyle["background-color"]="black";
    }

    mouseout(){
      this.myStyle["background-color"]="blue";
    }
}
