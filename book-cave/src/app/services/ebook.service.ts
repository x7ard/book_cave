import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Ebook } from '../models/ebook';

@Injectable({
  providedIn: 'root'
})
export class EbookService {

  constructor(private http: HttpClient) { }

  getAll(page: number, size: number) {
    return this.http.get<any[]>(`${environment.apiUrl}/ebooks`, {
      params: new HttpParams()
        .set('page', page.toString())
        .set('size', size.toString())

    });
  }

  getAllByCategory(page: number, size: number, category: string) {
    return this.http.get<any[]>(`${environment.apiUrl}/ebooks?page=${page}&size=${size}&category=${category}`);
  }

  //njib ktab wa7ed bi id; 
  getEbook(id) {
    return this.http.get<any>(`${environment.apiUrl}/ebook?${id}`).pipe(
      catchError(_ => {
        console.log("failed to get ebook with:  " + id);
        return of(new Ebook());
      })
    );
  }

  //nposti ktab hna !!
  createBook(book) {
    return this.http.post(`${environment.apiUrl}/ebook`, book);
  }


  //good practice bash ncatchi error dyal http verbs ... ila failat shi verb

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      return of(result as T);
    };
  }

}
