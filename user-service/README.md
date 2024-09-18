User Service

Services Provided:
1. User Detail

* URL: `{{baseUrl}}/api/user/{{id}}`
* METHOD: `GET`
* Response:
1. User detail fetched Response
```json
 {
    "message": "User detail fetched successfully.",
    "data" : {
            "id" : "1234",
            "name" : "User 1"
        }
    
 }
 ```
2. User not found Response
```json
 {
    "message": "User doesnot exist",
    "data" : {}
 }
 ```

 2. List all user accounts

* URL: `{{baseUrl}}/api/users/{{userId}}/accounts`

* METHOD: `GET`

* Response:
1. Successful Response
```json
 {
    "message": "User account(s) has been fetched",
    "data" : [
        {
            "bankId" : "123",
            "bankName": "ABC BANK",
            "branches": [
                "branchId": "123-001",
                "branchName": "ABC Branch 1",
                "accounts": [
                    {
                        "accountNumber": "123001123445",
                        "accountHoldersName": "user 1"
                    },
                     {
                        "accountNumber": "123001123448",
                        "accountHoldersName": "user 2"
                    }
                ]
            ]
        },
        {
            "bankId" : "456",
            "bankName": "CBA BANK",
            "branches": [
                "branchId": "456-001",
                "branchName": "CBA Branch 1",
                "accounts": [
                    {
                        "accountNumber": "456001123445",
                        "accountHoldersName": "user 1"
                    },
                     {
                        "accountNumber": "456001123448",
                        "accountHoldersName": "user 2"
                    }
                ]
            ]
        }
       
    ] 
 }
 ```

2. Not found Response
```json
 {
    "message": "Account(s) not found",
    "data" : [] 
 }
 ```
