function performLogin() {
    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;

    // Kiểm tra input trống
    if (!username || !password) {
        alert("Vui lòng điền đầy đủ thông tin đăng nhập.");
        return;
    }

    const requestData = {
        username: username,
        password: password
    };

    // Thực hiện cuộc gọi AJAX đến đường dẫn
    fetch('api/auth/dang-nhap', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(requestData)
    })
        .then(response => {
            if (response.ok) {
                console.log("Đăng nhập thành công!"); // Kiểm tra xem đoạn mã được thực hiện hay không
                alert("Đăng nhập thành công!");
                window.location.href = '/path/to/index.html';
            } else {
                return response.json();
            }
        })
        .then(data => {
            // Xử lý phản hồi từ server
            if (data) {
                alert(data); // Hiển thị thông báo lỗi từ server
            }
        })
        .catch(error => {
            console.error('Error:', error);
        });
}