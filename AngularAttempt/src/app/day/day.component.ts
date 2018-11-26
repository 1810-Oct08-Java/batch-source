import { Component, OnInit } from '@angular/core';
import { dayz } from '../mock-days';

@Component({
  selector: 'app-day',
  templateUrl: './day.component.html',
  styleUrls: ['./day.component.css']
})
export class DayComponent implements OnInit {

  days = dayz;

  constructor() { }

  ngOnInit() {
  }

}
