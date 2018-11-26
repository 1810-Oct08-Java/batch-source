import { Component, OnInit } from '@angular/core';
import { colours } from '../mock-colors';

@Component({
  selector: 'app-color',
  templateUrl: './color.component.html',
  styleUrls: ['./color.component.css']
})
export class ColorComponent implements OnInit {

  colors = colours;

  constructor() { }

  ngOnInit() {
  }

}
