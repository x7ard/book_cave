import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HeaderComponent } from './shared/header/header.component';
import { FooterComponent } from './shared/footer/footer.component';
import { AboutusComponent } from './shared/aboutus/aboutus.component';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
//material
import {
  MatButtonModule,
  MatIconModule,
  MatCheckboxModule,
  MatGridListModule,
  MatSnackBarModule,
  MatBadgeModule,
  MatRadioModule,
  MatProgressBarModule,
  MatTableModule,
  MatDatepickerModule,
  MatListModule,
  MatSelectModule,
  MatCardModule,
  MatChipsModule,
  MatFormFieldModule,
  MatInputModule,
  MatPaginatorModule,
  MatToolbarModule,
  MatSidenavModule,
  MatTabsModule,
  MatMenuModule,
  MatTooltipModule,
  MatTreeModule,
  MatProgressSpinnerModule
} from '@angular/material';
import { SettingsComponent } from './shared/settings/settings.component';
import { StoreComponent } from './shared/store/store.component';
import { SetbooksComponent } from './admin/setbooks/setbooks.component';
import { PaginatorComponent } from './shared/paginator/paginator.component';
import { ProfileComponent } from './clients/profile/profile.component';
import { LoginComponent } from './login/login.component';
import { JwtInterceptor } from './helpers/jwt.interceptor';
import { ErrorInterceptor } from './helpers/error.interceptor';
import { CartComponent } from './shared/cart/cart.component';
import { EbookDetailComponent } from './shared/ebook-detail/ebook-detail.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    AboutusComponent,
    SettingsComponent,
    StoreComponent,
    SetbooksComponent,
    PaginatorComponent,
    ProfileComponent,
    LoginComponent,
    CartComponent,
    EbookDetailComponent
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatIconModule,
    MatCheckboxModule,
    MatGridListModule,
    MatSnackBarModule,
    MatBadgeModule,
    MatRadioModule,
    MatProgressBarModule,
    MatTableModule,
    MatDatepickerModule,
    MatListModule,
    MatSelectModule,
    MatCardModule,
    MatChipsModule,
    MatFormFieldModule,
    MatInputModule,
    MatPaginatorModule,
    FormsModule,
    ReactiveFormsModule,
    MatToolbarModule,
    MatSidenavModule,
    MatTabsModule,
    MatMenuModule,
    MatTooltipModule,
    MatTreeModule,
    MatProgressSpinnerModule
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
