$('#add-user').submit(function () {
    event.preventDefault();
    ajaxPostAddNewUser();

    function ajaxPostAddNewUser() {

        let user = {
            name: $('#name').val(),
            email: $('#email').val(),
            birthday: $('#birthday').val(),
            phone: $('#phone').val(),
            phone2: $('#phone2').val()
        };

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/api/v1/users",
            data: JSON.stringify(user),
            dataType: 'json',
            success: function (user) {
                let buttons = "<button type=\"button\" id=\"delete-url\" class=\"btn btn-primary\">Delete</button>";
                let words = "<tr data-user-id=\"" + user.id + "\"><th scope=\"row\">new</th>"
                    + "<td>" + user.id + "</td>"
                    + "<td>" + user.name + "</td>"
                    + "<td>" + user.email + "</td>"
                    + "<td>" + user.birthday + "</td>"
                    + "<td>" + user.phone + "</td>"
                    + "<td>" + user.phone2 + "</td>"
                    + "<td>" + buttons + "</td></tr>";
                $('#getResultDiv #userTable').append(words);
                console.log("SUCCESS", user);
            },
            error: function (data) {
                console.log('Error:', data);
            }

        });
    }

});


$("#getAllUsersId").click(function (event) {
    event.preventDefault();
    ajaxGetAllUsers();


    function ajaxGetAllUsers() {
        $.ajax({
            type: "GET",
            url: "/api/v1/users",
            success: function (data) {
                $('#getResultDiv #userTable').empty();
                $.each(data, function (i, user) {
                    let buttons = "<button type=\"button\" id=\"delete-url\" class=\"btn btn-primary\">Delete</button>";
                    let words = "<tr data-user-id=\"" + user.id + "\"><th scope=\"row\">" + (i + 1) + "</th>"
                        + "<td>" + user.id + "</td>"
                        + "<td>" + user.name + "</td>"
                        + "<td>" + user.email + "</td>"
                        + "<td>" + user.birthday + "</td>"
                        + "<td>" + user.phone + "</td>"
                        + "<td>" + user.phone2 + "</td>"
                        + "<td>" + buttons + "</td></tr>";
                    $('#getResultDiv #userTable').append(words)
                });
            },
            error: function (data) {
                $("#getResultDiv").html("<strong>Error</strong>");
                console.log("ERROR: ", data);
            }
        });
    }

});


$('body').on('click', '#delete-url', e => {
    const row = $(e.currentTarget).closest('tr'),
        userId = row.data('userId');

    $.ajax({
        type: "DELETE",
        url: "/api/v1/users/" + userId,
        success: () => row.remove(),
        error: error => console.log('Error', error),
    });
});





