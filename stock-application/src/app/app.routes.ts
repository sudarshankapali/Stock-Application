import { Routes } from '@angular/router';
import { IssueComponent } from './issue/issue.component';
import { ApplyShareComponent } from './ShareApply/apply-share/apply-share.component';

export const routes: Routes = [
    {path:'', component:IssueComponent},
    {path:'apply-share',component:ApplyShareComponent}
];
