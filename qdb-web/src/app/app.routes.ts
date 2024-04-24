import { Routes } from '@angular/router';
import { AdminPageComponent } from './screens/admin-page/admin-page.component';
import { HelpPageComponent } from './screens/help-page/help-page.component';
import { LogScreenComponent } from './screens/log-screen/log-screen.component';
import { LoginScreenComponent } from './screens/login-screen/login-screen.component';
import { MainPageComponent } from './screens/main-page/main-page.component';
import { PageNotFoundComponent } from './screens/page-not-found/page-not-found.component';
import { QuestionFullComponent } from './screens/question-full/question-full.component';
import { RandomQuestionsScreenComponent } from './screens/random-questions-screen/random-questions-screen.component';
import { SearchScreenComponent } from './screens/search-screen/search-screen.component';
import { UserOverviewComponent } from './screens/user-overview/user-overview.component';

export const routes: Routes = [
    { path: "", component: MainPageComponent },
    { path: "question/:id", component: QuestionFullComponent },
    { path: "question/new", component: QuestionFullComponent },
    { path: "404", component: PageNotFoundComponent },
    { path: "search", component: SearchScreenComponent },
    { path: "login", component: LoginScreenComponent },
    { path: "user", component: UserOverviewComponent },
    { path: "admin", component: AdminPageComponent },
    { path: "log", component: LogScreenComponent },
    { path: "random", component: RandomQuestionsScreenComponent },
    { path: "help", component: HelpPageComponent },
    { path: "**", component: PageNotFoundComponent }
];
