import { Component, OnInit, ViewChild, AfterViewInit } from '@angular/core';
import { CategoryService } from 'src/app/services/category.service';
import { EbookService } from 'src/app/services/ebook.service';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { MatPaginator } from '@angular/material';
import { tap } from 'rxjs/operators';

@Component({
  selector: 'app-store',
  templateUrl: './store.component.html',
  styleUrls: ['./store.component.scss']
})
export class StoreComponent implements OnInit, AfterViewInit {


  page: any;
  categories: any[] = [];
  ebooks: any[] = [];

  images: string[] = [
    "macbeth.jpg",
    "tempest.jpg",
    "alchemist.jpg",
    "hamlet.jpg",
    "kinglear.jpg"
  ]

  @ViewChild(MatPaginator, { static: false }) paginator: MatPaginator;

  constructor(private serviceCat: CategoryService, private ebookService: EbookService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.serviceCat.getCategories().subscribe(data => {
      this.categories = data;
    });

    this.ebookService.getAll(0, 3).subscribe(data => {
      this.ebooks = data;
    });

  }

  ngAfterViewInit() {
    this.paginator.page
      .pipe()
      .subscribe(dt => {
        this.ebookService.getAll(dt.pageIndex, dt.pageSize).subscribe(data => {
          this.ebooks = data
        });
      });

  }


}
