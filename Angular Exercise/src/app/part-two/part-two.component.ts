import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-part-two',
  templateUrl: './part-two.component.html',
  styleUrls: ['./part-two.component.css']
})
export class PartTwoComponent implements OnInit {

  constructor() { }

  public show:boolean = false;
  public buttonName:any = 'Hide';

    hero: { 
     name: string,
     city: string; 
    }

  ngOnInit() {
    //this.hero.name = "Spiderman";
    //this.hero.city = "NYC";
    this.hero= {
      name: 'Spiderman',
      city: 'NYC'
    };
  }

  toggle() {
    this.show = !this.show;

    // CHANGE THE NAME OF THE BUTTON.
    if(this.show) {
      this.buttonName = "Hide";
      this.hero.name = "Spiderman";
      this.hero.city = "NYC";
     
    }
    else
      this.buttonName = "Show";
      this.hero.name = "";
      this.hero.city = "";
     
  }

  changeText(){
    if(this.buttonName = "Hide"){
      this.hero.name = "Spiderman";
      this.hero.city = "NYC";
    }
    else{
      this.hero.name = "";
      this.hero.city = "";
    }
  }

}
