# Blog-Dev Technical Blueprint

## 1. Business Overview
- **Tên dự án:** Blog-Dev
- **Mục tiêu:** Xây dựng blog kiến thức code
- **Đối tượng người dùng:** User, Admin
- **Chức năng cốt lõi:**
  - Login/Logout
  - Quản lý blog: tạo, chỉnh sửa, xóa, xem
  - Bình luận & đánh giá blog
  - Admin quản lý người dùng và blog
- **Phạm vi MVP:**
  - In-scope: Authentication, Blog CRUD, Comment & Rating, Basic UI/UX, Role-based access.
  - Out-of-scope: Upload media, Notifications, Social share, Advanced search/filter.

## 2. Architecture
- **Kiểu:** Monolith Spring Boot
- **Module chính:**
  - Authentication & Authorization (Spring Security + JWT)
  - User Management
  - Blog Management
  - Comment Management
  - Rating Management
  - Admin Dashboard
  - Service Layer, Repository Layer, Controller Layer
- **Luồng request:**
```
Client -> Controller -> Service -> Repository -> Database
```
- **Nguyên tắc:**
  - Layered Architecture
  - SRP, Loose Coupling
  - Security by Design
  - Audit & Logging

## 3. Database Design
- **Bảng chính:** users, roles, user_roles, blogs, comments, ratings
- **Quan hệ:**
  - users N-N roles (user_roles)
  - users 1-N blogs, comments, ratings
  - blogs 1-N comments, ratings
- **Mapping JPA:**
  - Entities: User, Role, Blog, Comment, Rating
  - Quan hệ: @OneToMany, @ManyToOne, @ManyToMany

## 4. REST API
- **Authentication:**
  - POST /api/auth/register (Public)
  - POST /api/auth/login (Public)
  - POST /api/auth/logout (USER/ADMIN)
- **Users:**
  - GET/PUT /api/users/me (USER/ADMIN)
  - GET/PUT/DELETE /api/admin/users/{id} (ADMIN)
- **Blogs:**
  - GET /api/blogs (Public)
  - GET /api/blogs/{id} (Public)
  - POST/PUT/DELETE /api/blogs/{id} (USER/ADMIN)
- **Comments:**
  - GET /api/blogs/{blogId}/comments (Public)
  - POST /api/blogs/{blogId}/comments (USER/ADMIN)
  - PUT/DELETE /api/comments/{id} (Author/Admin)
- **Ratings:**
  - GET /api/blogs/{blogId}/ratings (Public)
  - POST /api/blogs/{blogId}/ratings (USER/ADMIN)
  - PUT/DELETE /api/ratings/{id} (Author/Admin)

## 5. Security
- **Authentication:** JWT token, stateless, Spring Security + AuthenticationManager
- **Authorization:** Role-based (USER, ADMIN)
- **Security Filter Chain:**
  1. CorsFilter
  2. JwtAuthenticationFilter
  3. UsernamePasswordAuthenticationFilter
  4. AuthorizationFilter
  5. ExceptionTranslationFilter
  6. FilterSecurityInterceptor
- **Endpoints Public:** /api/auth/login, /api/auth/register, GET blog list/detail, GET comments/ratings
- **Endpoints Protected:** POST/PUT/DELETE blog, comment, rating; admin endpoints
- **Additional:** Password hashing (bcrypt), JWT expiration, CSRF if session-based, audit logging, rate limiting

