# User CRUD API - Spring Boot MVC

Du an nay cung cap API CRUD cho User theo mo hinh MVC:
- Entity: `User`
- Repository: `UserRepository`
- Service: `UserService`, `UserServiceImpl`
- Controller: `UserController`

## 1) Database

### Cach 1: Tu tao database bang SQL
File: `src/main/resources/db/init/create_database.sql`

```sql
CREATE DATABASE IF NOT EXISTS java_proj_21;
```

### Cach 2: De MySQL URL tu tao database
Da cau hinh san trong `application.properties` voi `createDatabaseIfNotExist=true`.

## 2) Cau hinh chinh

File `src/main/resources/application.properties`:
- `spring.datasource.url=jdbc:mysql://localhost:3306/java_proj_21?...`
- `spring.jpa.hibernate.ddl-auto=update` de tu dong tao/cap nhat bang `users`

## 3) API Endpoints

Base URL: `/api/users`

- `GET /api/users` : lay danh sach user
- `POST /api/users` : them user
- `PUT /api/users/{id}` : cap nhat user
- `DELETE /api/users/{id}` : xoa user

### Mau request body (POST/PUT)
```json
{
  "name": "Nguyen Van A",
  "email": "a@example.com"
}
```

## 4) Chay ung dung

```powershell
./mvnw spring-boot:run
```

## 5) Chay test

Test dung H2 in-memory (khong can MySQL):

```powershell
./mvnw test
```

