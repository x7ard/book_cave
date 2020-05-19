import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { catchError, map, tap } from 'rxjs/operators';
import { Category } from '../models/category';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  constructor(private _http: HttpClient) { }

  getCategories() {
    return this._http.get<any[]>(environment.apiUrl + '/categories');
  }

  postCategory(category) {
    return this._http.post<Category>(environment.apiUrl + '/category', category);
  }

  deleteCategory(id) {
    return this._http.delete(environment.apiUrl + '/category/', id);
  }
}
