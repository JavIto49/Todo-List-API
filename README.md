# Todo-List-API

A simple REST API built with Spring Boot that supports basic CRUD (Create, Read, Update, Delete) operations for managing todo tasks, with filtering, validation, and additional fields.

⸻

Features:
	•	Create new todo items with title, status, dueDate, and priority
	•	View a paginated list of todos with filtering/search options
	•	Update existing todos
	•	Delete todos
	•	Validation for input data to ensure correctness

⸻

Tech Stack:
	•	Java 21
	•	Spring Boot (Web, Data JPA)
	•	PostgreSQL database

⸻

Getting Started:
	1.	Clone the repo: git clone <https://github.com/JavIto49/Todo-List-API.git>
 	2.	Navigate into the project: cd todo-list-api
  	3.	Run the app: ./mvnw spring-boot:run
   	4.	Access the API at: http://localhost:8081/api/v1/todos

⸻

 Example Requests:
	•	Get all todos: GET /api/v1/todos
 	•	Create a todo: 
POST /api/v1/todos
Content-Type: application/json

{
  "title": "Finish project",
  "status": "PENDING",
  "priority": "HIGH",
  "dueDate": "2024-07-01"
}

	•	Validation failure response example:
Status: 400 Bad Request
Content-Type: application/json

{
  "errors": [
    {
      "field": "title",
      "message": "Title must not be blank"
    },
    {
      "field": "dueDate",
      "message": "Due date must be a valid future date"
    }
  ]
}
