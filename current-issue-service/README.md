Issue Service

Services Provided:
1. Lists all issues that are currently opened.

* URL: `{{baseUrl}}/api/current-issues`

* METHOD: `GET`

* Response:
1. Successful Response
```json
 {
    "message": "Issues has been fetched",
    "data" : [
        {
            "id" : "1234",
            "name" : "Issue 1",
            "descrition": "Issue 1 Description"
        },
        {
            "id" : "12345",
            "name" : "Issue 2",
            "descrition": "Issue 2 Description"
        }, 
        {
            "id" : "12356",
            "name" : "Issue 3",
            "descrition": "Issue 3 Description"
        }
    ] 
 }
 ```

2. Not found Response
```json
 {
    "message": "No issues are currently opened",
    "data" : [] 
 }
 ```
2. Validate if the issue is currently opened.

* URL: `{{baseUrl}}/api/current-issues/{{id}}/opened`

* METHOD: `GET`

* Response:
1. Issue opened Response
```json
 {
    "message": "Issue is currently opened",
    "data" : {
            "id" : "1234",
            "name" : "Issue 1",
            "descrition": "Issue 1 Description"
        }
    
 }
 ```

2. Issue Not opened Response
```json
 {
    "message": "Issue is not opened",
    "data" : {}
 }
 ```
3. Provide Detail of specific issue. 


* URL: `{{baseUrl}}/api/current-issues/{{id}}`

* METHOD: `GET`

* Response:
1. Issue detail fetched Response
```json
 {
    "message": "Issue detail fetched successfully.",
    "data" : {
            "id" : "1234",
            "name" : "Issue 1",
            "descrition": "Issue 1 Description"
        }
    
 }
 ```

2. Issue not found Response
```json
 {
    "message": "Issue doesnot exist",
    "data" : {}
 }
 ```