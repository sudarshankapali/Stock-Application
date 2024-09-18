import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { IssueComponent } from "./issue/issue.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,IssueComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'stock-application';
}
