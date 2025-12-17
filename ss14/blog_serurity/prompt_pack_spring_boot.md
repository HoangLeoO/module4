# PROMPT PACK – WEB PROJECT PIPELINE (SPRING BOOT)

> Mục tiêu: Chuyển **ý tưởng mơ hồ** → **bản thiết kế kỹ thuật hoàn chỉnh** → **mở IDE và code không lạc hướng**.

---

## CÁCH SỬ DỤNG CHUNG
- Mỗi dự án chạy Prompt Pack **1 lần, theo đúng thứ tự**
- Không nhảy bước
- Mỗi output **phải được lưu lại**
- IDE chỉ mở sau khi hoàn thành Phase 7

---

## PHASE 0 – INPUT Ý TƯỞNG

**Bạn tự viết (2–5 dòng):**
```
Tên dự án:
Mục tiêu:
Đối tượng người dùng:
Chức năng cốt lõi:
```

---

## PHASE 1 – PHÂN TÍCH NGHIỆP VỤ (BUSINESS ANALYST)

**PROMPT:**
```
Bạn là Business Analyst.
Phân tích yêu cầu nghiệp vụ chi tiết cho dự án sau:
[PROJECT IDEA]

Yêu cầu:
- Actors
- Use cases chính
- Luồng nghiệp vụ cốt lõi
- Phạm vi MVP (in-scope / out-of-scope)
```

**OUTPUT LƯU:** `business_analysis.md`

---

## PHASE 2 – THIẾT KẾ UI/UX (PRODUCT DESIGN)

**PROMPT:**
```
Bạn là Product Designer.
Thiết kế UI/UX cho dự án trên:
- Sitemap
- User flow chính
- Wireframe dạng text (low-fidelity)

Không cần code, không cần màu sắc.
```

**OUTPUT LƯU:** `ui_ux.md`

---

## PHASE 3 – KIẾN TRÚC HỆ THỐNG (ARCHITECT)

**PROMPT (MASTER):**
```
Bạn là Software Architect.
Dựa trên nghiệp vụ và UI/UX, hãy thiết kế kiến trúc hệ thống:

- Kiểu kiến trúc (monolith / microservice)
- Phân chia module
- Luồng request tổng thể
- Nguyên tắc thiết kế
```

**OUTPUT LƯU:** `architecture.md`

---

## PHASE 4 – THIẾT KẾ DATABASE

**PROMPT:**
```
Thiết kế database cho hệ thống:
- Danh sách bảng
- Các cột chính
- Quan hệ giữa các bảng
- Gợi ý mapping JPA Entity
```

**OUTPUT LƯU:** `database_design.md`

---

## PHASE 5 – API DESIGN

**PROMPT:**
```
Thiết kế REST API cho hệ thống:
- HTTP Method
- Endpoint
- Mô tả
- Quyền truy cập (ROLE)
```

**OUTPUT LƯU:** `api_design.md`

---

## PHASE 6 – SECURITY & AUTHENTICATION

**PROMPT:**
```
Thiết kế cơ chế bảo mật cho Spring Boot:
- Authentication (JWT / Session)
- Authorization (role-based)
- Security Filter Chain
- Các endpoint public / protected
```

**OUTPUT LƯU:** `security_design.md`

---

## PHASE 7 – KẾ HOẠCH PHÁT TRIỂN (SPRINT PLAN)

**PROMPT:**
```
Lập kế hoạch phát triển dự án Spring Boot:
- Chia sprint
- Task chính từng sprint
- Thứ tự triển khai hợp lý
```

**OUTPUT LƯU:** `sprint_plan.md`

---

## PHASE 8 – KHÓA THIẾT KẾ (CONTEXT LOCK)

**PROMPT:**
```
Tóm tắt toàn bộ dự án thành 1 Technical Blueprint ngắn gọn:
- Business
- Architecture
- Database
- API
- Security

Dùng để bắt đầu code.
```

**OUTPUT LƯU:** `PROJECT_BLUEPRINT.md`

---

## PHASE 9 – MỞ IDE

✅ ĐƯỢC PHÉP MỞ IDE KHI:
- Có `PROJECT_BLUEPRINT.md`
- Có sprint plan
- Đã khóa API & DB

❌ KHÔNG CODE TRƯỚC BƯỚC NÀY

---

## NGUYÊN TẮC SỬ DỤNG
- Prompt Pack = Quy trình
- ChatGPT = Người thi hành
- Bạn = Người kiểm soát

> Code nhanh không quan trọng bằng **code đúng hướng**.

