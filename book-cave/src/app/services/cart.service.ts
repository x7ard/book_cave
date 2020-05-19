import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  constructor() { }

  getCartTotal() {
    let fakeresp = "10";
    return Observable.create(obs => {
      setTimeout(() => {
        obs.next(fakeresp)
      }, 1000);
    })
  }
}
