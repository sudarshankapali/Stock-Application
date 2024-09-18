import { Component, Input } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-user-component',
  standalone: true,
  imports: [],
  templateUrl: './user-component.component.html',
  styleUrl: './user-component.component.css'
})
export class UserComponentComponent {
  userDetails: any[] = [];
  branches: any[] = [];
  constructor(private http: HttpClient) {
  }
  @Input() userIdDynamic = '';
  getUserDetail() {
    debugger;
    this.http.get(`http://localhost:8000/api/user/${this.userIdDynamic}/accounts`).subscribe((res: any) => {
      console.log(this.userIdDynamic);
      this.userDetails = res.data;


      this.branches = [];
      if (Array.isArray(res.data)) {
        res.data.forEach((bank: any) => {
          if (Array.isArray(bank.branchList)) {
            bank.branchList.forEach((branch: any) => {
              if (Array.isArray(branch.accountList)) {
                this.branches.push(...branch.accountList);
              }
            })
          }
        })
      }
      console.log(this.branches);
    });
  }
}
