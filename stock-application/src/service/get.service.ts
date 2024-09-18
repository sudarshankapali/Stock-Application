import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})

export class GetService {
  private issueApiUrl = 'http://localhost:8000/api/current-issues';

  private applyshareApiUrl = 'http://localhost:8000/api/ipo/apply'

  constructor(private http: HttpClient) { }

  getAllIssues() {
    return this.http.get(this.issueApiUrl);
  }
  applyShare(data: any) {
    return this.http.post(this.applyshareApiUrl, data);
  }
}