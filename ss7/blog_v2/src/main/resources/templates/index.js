let currentPage = 0;
let isLastPage = false;
let currentSearchTerm = "";

$(document).ready(function () {
    $("#searchInput").keyup(function () {
        currentSearchTerm = $(this).val();
        currentPage = 0;
        loadBlogs(currentPage, currentSearchTerm);
    });
});


function updateLoadMoreButton(last) {
    isLastPage = last;
    if (last) {
        $("#load-more-btn").hide();
    } else {
        $("#load-more-btn").show();
    }
}

function displayList() {
    currentPage = 0;
    currentSearchTerm = "";
    $('#table-container').empty();
    updateLoadMoreButton(false);
    loadBlogs(currentPage, currentSearchTerm);
}

// --- HÀM QUAN TRỌNG NHẤT: ĐÃ SỬA LỖI ---
function getData(data) {
    const blogs = data.content;
    const isFirstPage = (currentPage === 0); // Kiểm tra xem có phải trang đầu không

    updateLoadMoreButton(data.last);

    // 1. Tạo bảng nếu chưa có (Hoặc nếu container đang trống)
    if ($("#blog-table").length === 0 || isFirstPage) {
        // Nếu là trang đầu, ta reset luôn container để đảm bảo xóa thông báo lỗi cũ (nếu có)
        if (isFirstPage) $('#table-container').empty();

        // Chỉ tạo khung bảng nếu nó chưa tồn tại sau khi empty
        if ($("#blog-table").length === 0) {
            let tableHtml = '<table id="blog-table" border="1">' +
                '<thead>' +
                '<tr>' +
                '<th>STT</th>' +
                '<th>ID</th>' +
                '<th>Title</th>' +
                '<th>Content</th>' +
                '<th>Create Time</th>' +
                '<th>Category</th>' +
                '</tr>' +
                '</thead>' +
                '<tbody></tbody>' +
                '</table>';
            $('#table-container').html(tableHtml);
        }
    }

    // 2. Kiểm tra nếu tìm kiếm không có kết quả
    if (isFirstPage && blogs.length === 0) {
        $('#table-container').html('<h3>Không tìm thấy bài viết nào.</h3>');
        return;
    }

    // 3. SỬA LỖI MAP: Thêm 'return' và .join('')
    let content = blogs.map((blog, index) => {
        // Tính số thứ tự (index của mảng + 1)
        return `<tr>
                    <td>${index + 1}</td>
                    <td>${blog.id}</td>
                    <td>${blog.title}</td>
                    <td>${blog.content}</td>
                    <td>${blog.createTime}</td>
                    <td>${blog.category ? blog.category.name : (blog.categoryName || '')}</td>
                </tr>`;
    }).join(''); // Nối mảng thành chuỗi

    // 4. SỬA LỖI LẶP DỮ LIỆU: Phân biệt thay thế và thêm mới
    if (isFirstPage) {
        // Nếu là trang 0 (Tìm kiếm/Load lại): THAY THẾ toàn bộ nội dung cũ
        $('#blog-table tbody').html(content);
    } else {
        // Nếu là trang > 0 (Tải thêm): THÊM VÀO đuôi
        $('#blog-table tbody').append(content);
    }
}

function showCreateForm() {
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/api/v1/blogs/categories',
        dataType: 'json',
        success: function (data) {
            let optionsHtml = '';
            data.forEach(category => {
                optionsHtml += '<option value="' + category.id + '">' + category.name + '</option>';
            });
            let formHtml = '<h2>Create New Blog</h2>' +
                '<form id="create-blog-form">' +
                'Title: <input type="text" id="title" name="title"><br><br>' +
                'Content: <textarea id="content" name="content"></textarea><br><br>' +
                'Category: <select id="categoryName" name="categoryName">' +
                optionsHtml +
                '</select>' +
                '<br><br>' +
                '<button type="button" onclick="createBlog()">Create</button>' +
                '</form>';
            document.getElementById('form-container').innerHTML = formHtml;
        },
        error: function (error) {
            console.log('Error fetching categories:', error);
        }
    })
}

function createBlog() {
    let title = $('#title').val();
    let content = $('#content').val();
    let categoryId = $('#categoryName').val(); // Lấy ID danh mục

    // Tạo đối tượng dữ liệu chuẩn
    let blogData = {
        title: title,
        content: content,
        category: {
            id: categoryId
        }
    };

    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/api/v1/blogs/create',
        contentType: 'application/json',
        data: JSON.stringify(blogData),
        success: function (response) {
            alert('Blog created successfully!');
            displayList();
        },
        error: function (error) {
            console.log('Error creating blog:', error);
        }
    })
}

function loadMore() {
    if (isLastPage) return;
    currentPage++;
    loadBlogs(currentPage, currentSearchTerm);
}

function loadBlogs(page, keySearch) {
    $.ajax({
        type: "GET",
        url: 'http://localhost:8080/api/v1/blogs',
        data: {
            "page": page,
            "keySearch": keySearch
        },
        success: function (data) {
            getData(data);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.error("Lỗi tải dữ liệu:", textStatus, errorThrown);
        }
    });
}