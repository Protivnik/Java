function inputdate(data) {
    var tblRow = "<tr id='" + data.id + "'>" + "<td>" + "<strong>" + data.id + "</strong>" + "</td>" + "<td id='firstName' >" + data.firstName + "</td>" + "<td id='lastName'>" + data.lastName +
        // var tblRow = "<tr id='" + data.id + "'>" + "<td>" + "<strong>" + data.id + "</strong>" + "</td>" + "<td id='firstName' aria-valuetext='"+data.firstName+"'></td>" + "<td id='lastName'>" + data.lastName +
        "</td>" + "<td id='age'> " + data.age + "</td>" + "<td id='email'>" + data.email + "</td>" + "<td id='roles'>"

    for (index in data.roles) {
        tblRow += data.roles[index].role + " ";
    }
    tblRow += "</td>" + "<th>" +
        "<button  class=\"btn btn-info\" onclick=\"editUser(this)\" data-toggle=\"modal\"\n" +
        " data-row-id= " + data.id +
        " data-row-firstname= " + data.firstName +
        " data-row-lastname= " + data.lastName +
        " data-row-age= " + data.age +
        " data-row-email= " + data.email +

        " data-row-roles= " + data.roles +
        " FORM=\"edit\"\n" +
        "data-target='#customerModel'>\n" +
        "Edit\n" +
        "</button>\n" + "</th>";

    tblRow += "<th>" +

        "<button class=\"btn btn-danger\" id='delete' data-toggle=\"model\" onclick=\"deleteForm(this)\"  form=\"delete\" data-target='#customerModel' " +
        "data-row-id=" + data.id + ">" +
        "Delete\n" +
        "</button>\n" +
        "</th>" + "</tr>"
    $(tblRow).appendTo("#incentive tbody");
};


$(document).ready(function () {
    $.getJSON("/admin/rest/user", function (data) {
        for (key in data) {
            var xxx = data[key];
            inputdate(xxx);
        }

    })
});

function editUser(obj) {

    $('#idE').attr('value', $(obj).data('row-id'));
    $('#firstNameE').attr('value', $(obj).data('row-firstname'));
    $('#lastNameE').attr('value', $(obj).data('row-lastname'));
    $('#ageE').attr('value', $(obj).data('row-age'));
    $('#emailE').attr('value', $(obj).data('row-email'));

    $("#customerModel").modal('show');
}

function deleteForm(obj) {
    var rowId = $(obj).data('row-id');
    $('#delete-form').attr('data-row-id', rowId);
    $("#customerModel1").modal('show');
}

$("#delete-form").submit(function (e) {
    e.preventDefault();
    var rowId = $('#delete-form').attr('data-row-id');
    $.ajax({
        type: "get",
        url: "admin/delete/" + rowId,

        success: function () {

            $('#incentive').find('tr#' + rowId + '').remove();
            $("#customerModel1").modal('toggle');
        },

    });
});

$(document).ready(function () {
    $("#editForm").submit(function (e) {
        e.preventDefault(); // 1. Dont reload the page
        var parms = {
            id: $("#idE").val(),
            firstName: $("#firstNameE").val(),
            lastName: $("#lastNameE").val(),
            age: $("#ageE").val(),
            email: $("#emailE").val(),
            rolesString: $("#selectRole").val().toString(),
            roles: $("#selectRole").val()
        };
        $.ajax({
            type: "POST",
            url: "admin/edit",
            data: parms,
            success: function () {
                var x = parms.id;
                $("#customerModel").modal('toggle');

                var rolout = "";
                for (index in parms.roles) {
                    rolout += parms.roles[index] + " ";
                }
                $("#incentive tbody").children("#" + x).children('#firstName').text(parms.firstName);
                $("#incentive tbody").children("#" + x).children('#lastName').text(parms.lastName);
                $("#incentive tbody").children("#" + x).children('#age').text(parms.age);
                $("#incentive tbody").children("#" + x).children('#email').text(parms.email);
                $("#incentive tbody").children("#" + x).children('#roles').text(rolout);

            }
        });

    });
});
$(document).ready(function () {
    $.getJSON("/admin/rest/role", function (rolesIP) {

        for (k in rolesIP) {
            $('#selectRole').append("<option value= " + rolesIP[k].role + " data-id=" + rolesIP[k].id + ">" + rolesIP[k].role + "</option>");
        }
    });
});

$(document).ready(function () {
    $.getJSON("/admin/rest/role", function (rolesIP) {

        for (k in rolesIP) {
            $('#selectRoleN').append("<option value= " + rolesIP[k].role + " data-id=" + rolesIP[k].id + ">" + rolesIP[k].role + "</option>");
        }
    });
});

$("#newUser").submit(function (e) {
    e.preventDefault();
    var parmetrNew = {
        firstName: $("#firstNameN").val(),
        lastName: $("#lastNameN").val(),
        age: $("#ageN").val(),
        email: $("#emailN").val(),
        password: $("#passwordN").val(),
        rolesString: $("#selectRoleN").val().toString()
    };
    $.ajax({
        type: "POST",
        url: "admin/add",
        data: parmetrNew,
        success: function (data) {
            inputdate(data);
            document.getElementById('newf').reset();
            $("#help").trigger("click");

        }
    });
});






