import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { of } from 'rxjs';
import { UserComponentComponent } from '../user-component/user-component.component';

@Component({
  selector: 'app-get-api',
  standalone: true,
  imports: [UserComponentComponent],
  templateUrl: './get-api.component.html',
  styleUrl: './get-api.component.css'
})
export class GetApiComponent {

  userList: any[] = [];
  constructor(private http: HttpClient) {

  }
  getAllUsers() {
    debugger;
    this.http.get("http://localhost:8000/api/user").subscribe((res: any) => {
      this.userList = res.data;
      console.log(this.userList)
    })
  }
}
