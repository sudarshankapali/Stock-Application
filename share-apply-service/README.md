Share Aply Service

Services Provided:
1. Allows user to apply IPO

* URL: `{{baseUrl}}/api/ipo/apply`

* METHOD: `POST`

* Request:
```json
{
    "userId": 1233,
    "accountNumber": "A001123444",
    "issueId": "1234",
    "appliedQuantity": 10,
    "crn" : "1234"
}
```

* Response:
1. Successful Response
```json
 {
    "message": "IPO has been applied successfully",
    "data" : {
            "applicationId" : "1233-1234-001", //<userid>-<issueid>-<id>
            "issueId" : "1234",
            "userId": "1233",
            "status" : "VERIFICATION_PENDING" // VERIFICATION_PENDING|VERIFIED|REJECTED
        }
 }
 ```

2. Failure Response
```json
 {
    "message": "Unable to apply IPO at the moment",
    "data" : {}
 }
 ```