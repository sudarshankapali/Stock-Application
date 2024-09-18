IPO Result Service


Services Provided: 

1. Check whether or not IPO has been allotted to user

* URL: `{{baseUrl}}/api/allotment-result`

* METHOD: `POST`
*  Request:
```json
 {
    "applicationId": "1234",
    "issueId": "123"
 }
 ```

* Response:
1. Allotted Response
```json
 {
    "message": "IPO has been allotted",
    "allottedQuantity" : 10 
 }
 ```

2. Not Allotted Response
 ```json
 {
    "message": "IPO has not been allotted",
    "allottedQuantity" : 0
 }
 ```