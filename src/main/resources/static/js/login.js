function submitForm() {
    var phone = $('#phone').val();
    var password = $('#password').val();
    $.ajax({
        url: "user/login",
        type: "get",
        data: {
            "phone": phone,
            "password": password
        },
        success: function (data) {
            if (data.success) {
                alert("success");
            } else {
                alert(data.message);
            }
        }
    })
}