import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-table-component4',
  templateUrl: './table-component4.component.html',
  styleUrls: ['./table-component4.component.css']
})
export class TableComponent4Component implements OnInit {
  styleType=true;

  constructor() { }

  ngOnInit() {
  }

  person={
    firstName : 'John',
    lastName : 'Doe',
    email : 'email@email.com',
    bd : new Date(9999, 9, 99)
  }

  changeStyle(){
    if(this.styleType === false){
    this.styleType=true
    }else{
      this.styleType=false
    }
  }

}
