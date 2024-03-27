import { Routes } from '@angular/router';
import { MainPageComponent } from './screens/main-page/main-page.component';
import { PageNotFoundComponent } from './screens/page-not-found/page-not-found.component';
import { QuestionFullComponent } from './screens/question-full/question-full.component';
import { SearchScreenComponent } from './screens/search-screen/search-screen.component';
import { LoginScreenComponent } from './screens/login-screen/login-screen.component';
import { UserOverviewComponent } from './screens/user-overview/user-overview.component';
import { AdminPageComponent } from './screens/admin-page/admin-page.component';

export const routes: Routes = [
    { path: "", component: MainPageComponent },
    { path: "question/:id", component: QuestionFullComponent },
    { path: "question/new", component: QuestionFullComponent },
    { path: "404", component: PageNotFoundComponent },
    { path: "search", component: SearchScreenComponent },
    { path: "login", component: LoginScreenComponent },
    { path: "user", component: UserOverviewComponent },
    { path: "admin", component: AdminPageComponent },
    { path: "**", component: PageNotFoundComponent }
];
