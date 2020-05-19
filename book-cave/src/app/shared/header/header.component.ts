import { Component, OnInit, Input } from '@angular/core';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { Router } from '@angular/router';
import { CartService } from 'src/app/services/cart.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  @Input() pageTitle: string;
  counter = 0;

  constructor(private authservice: AuthenticationService, private router: Router, private cartService: CartService) {
    this.counter = this.cartService.getCartTotal().subscribe(
      (res) => {
        this.counter = res;
      }
    )
  }

  ngOnInit() {
  }

  logout() {
    this.authservice.logout();
    this.router.navigate(['/login']);
  }

}
