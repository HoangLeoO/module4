<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 28/11/2025
  Time: 1:41 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        /* Thiết lập font chữ và căn giữa form */
        .sandwich-form {
            max-width: 500px;
            margin: 40px auto;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 8px;
            background-color: #fff;
            font-family: Arial, sans-serif;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        /* Tiêu đề chính */
        .sandwich-form h2 {
            text-align: center;
            color: #333;
            margin-bottom: 25px;
        }

        /* Nhóm gia vị (Fieldset) */
        .spice-group {
            border: 1px solid #ccc;
            padding: 15px;
            margin-bottom: 20px;
            border-radius: 6px;
        }

        /* Tiêu đề nhóm (Legend) */
        .spice-group legend {
            font-size: 1.1em;
            font-weight: bold;
            color: #007bff; /* Màu xanh nổi bật */
            padding: 0 10px;
        }

        /* Nhãn cho Checkbox */
        .sandwich-form label {
            display: block; /* Mỗi label 1 dòng */
            margin-bottom: 8px;
            cursor: pointer;
            padding: 5px 0;
        }

        /* Ẩn hiện checkbox khi hover */
        .sandwich-form label:hover {
            background-color: #f4f4f4;
            border-radius: 3px;
        }

        /* Tùy chọn con (Sub-options) */
        .sub-options {
            border-left: 3px solid #f0f0f0; /* Đường kẻ phân biệt */
            padding-left: 15px;
            margin-top: 5px;
            margin-bottom: 10px;
        }

        .sub-label {
            font-size: 0.95em; /* Chữ nhỏ hơn */
            color: #555;
            margin-left: 10px;
        }

        /* Nút Submit */
        .submit-btn {
            display: block;
            width: 100%;
            padding: 10px;
            background-color: #28a745; /* Màu xanh lá cây */
            color: white;
            border: none;
            border-radius: 5px;
            font-size: 1em;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .submit-btn:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>
<form action="add" method="post" class="sandwich-form">
    <h2>Chọn Gia Vị cho Sandwich của bạn</h2>

    <fieldset class="spice-group">
        <legend>🥫 1. Sốt và Phết (Sauces & Spreads)</legend>

        <label><input type="checkbox" name="sauces" value="mayonnaise"> Mayonnaise</label>
        <label><input type="checkbox" name="sauces" value="ketchup"> Ketchup (Tương cà)</label>
        <label><input type="checkbox" name="sauces" value="chili-sauce"> Chili Sauce (Tương ớt)</label>

        <div class="sub-options">
            <label><input type="checkbox" name="sauces" value="mustard"> Mustard (Mù tạt)</label>
            <label class="sub-label"><input type="checkbox" name="sauces" value="dijon"> &nbsp;&nbsp;&nbsp;→ Dijon Mustard</label>
            <label class="sub-label"><input type="checkbox" name="sauces" value="honey-mustard"> &nbsp;&nbsp;&nbsp;→ Honey Mustard</label>
        </div>

        <label><input type="checkbox" name="sauces" value="pesto"> Pesto (Sốt Pesto)</label>
    </fieldset>

    <fieldset class="spice-group">
        <legend>🥬 2. Rau củ và Thảo mộc (Veggies & Herbs)</legend>

        <label><input type="checkbox" name="veggies" value="lettuce"> Lettuce (Xà lách)</label>
        <label><input type="checkbox" name="veggies" value="tomato"> Tomato (Cà chua)</label>
        <label><input type="checkbox" name="veggies" value="pickles"> Pickles (Dưa chuột muối)</label>
        <label><input type="checkbox" name="veggies" value="jalapenos"> Jalapeños (Ớt Jalapeño)</label>
        <label><input type="checkbox" name="veggies" value="red-onion"> Red Onion (Hành tây đỏ)</label>
    </fieldset>

    <fieldset class="spice-group">
        <legend>✨ 3. Gia vị Khác (Other Seasonings)</legend>

        <label><input type="checkbox" name="seasoning" value="salt"> Salt (Muối)</label>
        <label><input type="checkbox" name="seasoning" value="pepper"> Black Pepper (Tiêu đen)</label>
        <label><input type="checkbox" name="seasoning" value="olive-oil"> Olive Oil (Dầu ô liu)</label>
    </fieldset>

    <button type="submit" class="submit-btn">Hoàn tất Đặt Sandwich</button>
</body>
</html>
