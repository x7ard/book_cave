import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-setbooks',
  templateUrl: './setbooks.component.html',
  styleUrls: ['./setbooks.component.scss']
})
export class SetbooksComponent implements OnInit {

  toggleField: string;
  constructor() { }

  ngOnInit() {
    this.toggleField = "searchMode";
  }

  toggle(filter?) {
    if (!filter) {
      filter = "searchMode"
    } else {
      filter = filter;
    }
    this.toggleField = filter;
  }

}
