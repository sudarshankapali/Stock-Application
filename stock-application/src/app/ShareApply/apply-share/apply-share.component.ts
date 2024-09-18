import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';
import { GetService } from '../../../service/get.service';
import { ToastrService } from 'ngx-toastr';


@Component({
  selector: 'app-apply-share',
  standalone: true,
  imports: [RouterModule,ReactiveFormsModule],
  templateUrl: './apply-share.component.html',
  styleUrl: './apply-share.component.css'
})
export class ApplyShareComponent{

  myFrom: FormGroup;
  //submitResult:any;
  constructor(private fb:FormBuilder,private getService:GetService, private toastr: ToastrService){
    this.myFrom=this.fb.group({
    "userId": ['',Validators.required],
    "accountNumber":['',Validators.required],
    "issueId": ['',Validators.required],
    "appliedQuantity": [0,Validators.required],
    "crn" : ['']
    });
  }
  onSubmit() {
  if (this.myFrom.valid) {
    this.getService.applyShare(this.myFrom.value)
      .subscribe((res:any) => {
        //this.submitResult=response;
        if(res.data.status === "VERIFIED"){
          this.myFrom.reset();
          this.toastr.success('Share Applied Successfully!', 'Success!');
        }else if(res.data.status === "VERIFICATION_PENDING"){
          this.myFrom.reset();
          this.toastr.info('Your application is pending!', 'Pending!');
        }else{
          this.myFrom.reset();
          this.toastr.error("Your application is rejected!","Rejected!")
        }
        console.log('Response from API:', res);
        // this.dialog.open("IPO has been applied successfully");
      });
  }else{
    this.myFrom.reset();
    this.toastr.error("Form is invalid!","Invalid!")
    console.error('Form is invalid');
  }
}
}
