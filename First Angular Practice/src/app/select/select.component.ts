import { Component, OnInit } from '@angular/core';
import {NgForm} from '@angular/forms';

@Component({
  selector: 'app-select',
  templateUrl: './select.component.html',
  styleUrls: ['./select.component.css']
})
export class SelectComponent implements OnInit {

selectedList : string[] ;
radioSelected: string;

lists : Object[] = [
						{ name: "animals", 
							list: ['mouse', 'ox', 'tiger', 'rabbit', 'horse', 'snake', 'dragon', 'sheep', 'monkey', 'chicken', 'dog', 'pig', 'cat', 'panda']
						},
						{ name: "colors", 
							list: ['red', 'orange', 'yellow', 'green', 'blue', 'purple', 'pink', 'brown', 'white', 'gray', 'black']
						},
						{ name: "days", 
							list: ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday']
						}
					];

      
      constructor() {}
			ngOnInit() {}

			onItemChange(item) {
				this.selectedList = item.list;
			}

}
