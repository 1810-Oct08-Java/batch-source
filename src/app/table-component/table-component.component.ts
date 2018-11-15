import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-table-component',
  templateUrl: './table-component.component.html',
  styleUrls: ['./table-component.component.css']
})
export class TableComponentComponent implements OnInit {

  objs = [
    {
      firstName: "Kien",
      lastName: "Chin",
      email: "Chink@rev.com",
      birthday: "01-18-1997"
    },
    {
      firstName: "Treyven",
      lastName: "Chin",
      email: "ChinT@gmail.com",
      birthday: "06-12-1994"
    },
    {
      firstName: "Karl",
      lastName: "Schieder",
      email: "KS@rev.com",
      birthday: "11-05-1982"
    }
  ];

  constructor() { }

  ngOnInit() {
  }

}
