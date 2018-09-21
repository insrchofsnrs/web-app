$('#add-user').submit(function () {
    event.preventDefault();
    ajaxPost();

});

function ajaxPost() {

    var user = {
        name: $('#name').val(),
        email: $('#email').val(),
        birthday: $('#birthday').val(),
        phone: $('#phone').val(),
        phone2: $('#phone2').val()
    };

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/users",
        data: JSON.stringify(user),
        dataType: 'json',
        success: function (user) {
            var buttons = "<button type=\"button\" id=\"delete-url\" class=\"btn btn-primary\">Delete</button>";
            var words = "<tr data-user-id=\"" + user.id + "\"><th scope=\"row\">new</th>" + "<td>" + user.id + "</td>" + "<td>" + user.name + "</td>" + "<td>" + user.email + "</td>" + "<td>" + user.birthday + "</td>" + "<td>" + user.phone + "</td>" + "<td>" + user.phone2 + "</td>"  + "<td>" + buttons + "</td></tr>";
            $('#getResultDiv #userTable').append(words);
            console.log("SUCCESS", user);
        },
        error: function (data) {
            console.log('Error:', data);
        }

    });
}


$("#getAllUsersId").click(function (event) {
    event.preventDefault();
    ajaxGet();

});

function ajaxGet() {
    $.ajax({
        type: "GET",
        url: "/users",
        success: function (data) {
            $('#getResultDiv #userTable').empty();
            $.each(data, function (i, user) {
                var buttons = "<button type=\"button\" id=\"delete-url\" class=\"btn btn-primary\">Delete</button>";
                var words = "<tr data-user-id=\"" + user.id + "\"><th scope=\"row\">" + (i + 1) + "</th>" + "<td>" + user.id + "</td>" + "<td>" + user.name + "</td>" + "<td>" + user.email + "</td>" + "<td>" + user.birthday + "</td>" + "<td>" + user.phone + "</td>" + "<td>" + user.phone2 + "</td>" + "<td>" + buttons + "</td></tr>";
                $('#getResultDiv #userTable').append(words)
            });
        },
        error: function (data) {
            $("#getResultDiv").html("<strong>Error</strong>");
            console.log("ERROR: ", data);
        }
    });
}

$('#delete-url').live("click", function () {
    var row = $(this).closest('tr'),
         userId = row.data('userId');
    console.log(userId);
    $.ajax({
        type: "DELETE",
        url: "/users/" + userId,
        success: function (data) {
            console.log(data);
            row.remove();
        },
        error: function (data) {
            console.log('Error:', data, userId);
        }
    })
});





