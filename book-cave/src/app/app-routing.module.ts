import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AboutusComponent } from './shared/aboutus/aboutus.component';
import { SettingsComponent } from './shared/settings/settings.component';
import { StoreComponent } from './shared/store/store.component';
import { SetbooksComponent } from './admin/setbooks/setbooks.component';
import { LoginComponent } from './login/login.component';
import { AuthGuard } from './helpers/auth.guard';
import { CartComponent } from './shared/cart/cart.component';


const routes: Routes = [
  { path: '', redirectTo: '/store', pathMatch: 'full' },
  { path: 'aboutus', component: AboutusComponent },
  { path: 'setbooks', component: SetbooksComponent, canActivate: [AuthGuard] },
  { path: 'settings', component: SettingsComponent },
  { path: 'cart', component: CartComponent },
  { path: 'login', component: LoginComponent },
  { path: 'store', component: StoreComponent },
  { path: '**', redirectTo: '/aboutus', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
