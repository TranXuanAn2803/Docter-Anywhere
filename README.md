# Docter-Anywhere-Home-Assignment

## Table of Contents
* [How To Run](#how-to-run)
* [Video demo](#video-demo)
* [Requirement](#requirement)
* [Database](#datebase)
* [Problem](#problem)
<!-- * [License](#license) -->


## How To Run
- Step 1: Clone code từ repo về local
- Step 2: Tạo schema tên doctor-anywhere trong MYSQL
- Step 3: Mở project bằng các IDE có hỗ trợ Java và Spring Boot
- Step 4: Vào thư mục src/main/resources/application.properties update các thông tin về datasource.url; datasource.username; datasource.password=2803
- Step 5: Bấm nút chạy chương trình

## Video demo
[click here](https://www.youtube.com/watch?v=ZkW2jFa5CDw)
<!-- If you have screenshots you'd like to share, include them here. -->

## Requirement
| Requirement  | Status |
| ------------- | ------------- |
| Create a new Spring Boot project using your favourite IDE. Use Maven or Gradle to manage dependencies  | Done|
| Define a simple data model for a "Task" object that includes (id: Long, title: String, description: String, description: String )  | Done|
| Implement the following RESTful endpoints. Include GET /tasks, POST /tasks , GET /tasks/{id},  PUT /tasks/{id}, DELETE /tasks/{id} | Done|
|  Use MySQL for persistence  | Done|
| Test your API using Postman or any other REST client to ensure that it works as expected  | Done|
| Use git as the version control for your project  | Done|
| Implement error handling for each endpoint  | Done|
| Use Spring Data JPA to store the task data in a MySQL database  | Done|
| Use Spring Security to add authentication and authorization to the API  | Absence of authorization to the API|
| Can run the application in a container  | Missing|



## Database
Database sẽ tự động update dựa vào Spring Data JPA nên không cần tạo table và import data. Tuy nhiên trong trường hợp code chạy lỗi có thể tham khảo file database-script.sql đã được upload.

## Problem
- Hiện tại chức năng xóa đang là Hard Delete, nên sử dụng Soft Delete
- Nên lưu thông tin user tạo task (created_by, created_at)
- Cần bổ sung phân quyền
- Cần tạo container cho application


<!-- Optional -->
<!-- ## License -->
<!-- This project is open source and available under the [... License](). -->

<!-- You don't have to include all sections - just the one's relevant to your project -->
