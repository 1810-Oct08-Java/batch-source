import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-show-info',
  templateUrl: './show-info.component.html',
  styleUrls: ['./show-info.component.css']
})

export class ShowInfoComponent implements OnInit {
  btnShow: string;
  show = true;
  hide = false;
  // object
  // user: {
  //   hello: string,
  //   hero: string
  // };
  user: User; // interface

  constructor() {

  }

  ngOnInit() {
    this.user = {
      hello: 'I am',
      hero: 'Batman'
    };
    this.btnShow = 'Hide';
  }

  toggleShow() {
    if (this.show === true) {
      this.btnShow = 'Show';
    } else {
      this.btnShow = 'Hide';
    }
    this.show = !this.show;
  }

}
interface User {
  hello: string;
  hero: string;
}


