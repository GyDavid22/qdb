import { Routes } from '@angular/router';
import { MainPageComponent } from './main-page/main-page.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';

export const routes: Routes = [
    { path: "", component: MainPageComponent },
    { path: "**", component: PageNotFoundComponent }
];
