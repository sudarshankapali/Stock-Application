import { Component, OnInit } from '@angular/core';
import { GetService } from '../../service/get.service';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { ApplyShareComponent } from '../ShareApply/apply-share/apply-share.component';
// import { NgModel } from '@angular/forms';

// interface IssuesData{
//   message:string;
//   data:Object;
// }

@Component({
  selector: 'app-issue',
  standalone: true,
  imports: [CommonModule,HttpClientModule,RouterModule,ApplyShareComponent],
  templateUrl: './issue.component.html',
  styleUrl: './issue.component.css'
})

// export class IssueComponent implements OnInit {

//   //issues: IssuesData[] = [];
//   // issues:IssuesData[]=[];
//   issueId:number[]=[];

//   constructor(private issueDataService: GetService) { }

//   ngOnInit(): void {
//     this.issueDataService.geAllIssues().subscribe(
//       (response:IssuesData[])=> {
//        console.log("From response: " + response);
//        this.issues=response;
       
//       },
//       (error)=>{
//         console.log("From error: " +error);
//       }
//     );
//   }
// }


export class IssueComponent implements OnInit {
  issues:any;
  constructor(private issueDataService: GetService) { }

  ngOnInit(): void {
    this.issueDataService.getAllIssues().subscribe(
      (response:any)=> {
       console.log("From response: " + response.data);
       this.issues=response.data;
       
      },
      (error)=>{
        console.log("From error: " +error);
      }
    );
  }
}
