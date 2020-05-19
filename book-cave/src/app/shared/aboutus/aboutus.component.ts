import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material';

@Component({
  selector: 'app-aboutus',
  templateUrl: './aboutus.component.html',
  styleUrls: ['./aboutus.component.scss']
})
export class AboutusComponent implements OnInit {

  constructor(private _snackBar: MatSnackBar) {

  }

  openSnackBar() {
    this._snackBar.open("Thank you for clicking! this is made with ❤️ ", "close", {
      duration: 6000,
    });
  }
  ngOnInit() {
  }

  team: string[] = [
    "Khalil kessa",
    "Abdellah zarraq",
    "Hassan krid",
    "Lhssan aboulalae"
  ]
}
