import { Routes } from '@angular/router';
import { MainPageComponent } from './screens/main-page/main-page.component';
import { PageNotFoundComponent } from './screens/page-not-found/page-not-found.component';
import { QuestionFullComponent } from './screens/question-full/question-full.component';

export const routes: Routes = [
    { path: "", component: MainPageComponent },
    { path: "question/:id", component: QuestionFullComponent },
    { path: "404", component: PageNotFoundComponent },
    { path: "**", component: PageNotFoundComponent }
];
