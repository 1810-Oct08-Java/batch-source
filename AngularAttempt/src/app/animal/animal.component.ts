import { Component, OnInit } from '@angular/core';
import { animalia } from '../mock-animals';


@Component({
  selector: 'app-animal',
  templateUrl: './animal.component.html',
  styleUrls: ['./animal.component.css']
})
export class AnimalComponent implements OnInit {

  animals = animalia;

  constructor() { }

  ngOnInit() {
  }

}
