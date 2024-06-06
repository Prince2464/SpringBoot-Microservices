Requirement: 
Develop microservices that manages Employee details. The microservice needs to provide endpoints for CRUD operations on Employee entities.

Each Employee will have the following details:
Personal Details:
Name
DOB
Address
Phone_No
Emailaddress
Salary

Official Details:
EmployeeId
EmployeeName
DateOfJoining
Designation
ProjectName
EmployeeType (Contract/Permanent)

Requirements:
1) Implement a RESTful API using Spring Boot that exposes the given endpoints for the given business case
2) Use MongoDB to store the details
3) Implement authentication and authorization using Spring Security. You can use any suitable mechanism such as JSON Web Tokens (JWT), OAuth2, or basic authentication
4) Validate the input data(backend validation) for each endpoint and handle appropriate error scenarios
5) Implement proper error handling and return meaningful error messages in case of failures, invalid requests, or unauthorized access
6) Create Swagger or OpenAPI documentation for the end points.

Business Use Cases to implement:

1)	POST /employees: Creates a new employee with provided details (Requires authentication and authorization)
2)	GET /employees/{employeeId}: Retrieves the details of a particular employee along with the personal details excluding Salary
3)	GET /employees/personal/{employeeId}: Retrieves all the personal details of an employee (Requires authentication and authorization)
4)	PUT /employees/{employeeId}: Updates the details of an employee with the given Id (Requires authentication and authorization)
5)	DELETE /employees/{employeeId}: Deletes the entire data of an employee including the personal details in the system (Requires authentication and authorization)
