function submitForm() {
    var phone = $('#phone').val();
    var password = $('#password').val();
    var name = $('#name').val();
    $.ajax({
        url: "user/register",
        type: "post",
        data: {
            "phone": phone,
            "name":name,
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