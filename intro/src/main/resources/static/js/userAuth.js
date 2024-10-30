$(document).ready(function () {

    $("#signup-form").submit(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();

        fire_signup_submit();

    });

});

function fire_signup_submit() {

	//let name = $("#name").val(), password = $("#password").val(), email = $("#email").val();
	
    /*var search = {}
    search["name"] = $("#name").val();*/
    //search["email"] = $("#email").val();

    $("#btn-search").prop("disabled", true);
	let user = {};
	user["name"] = $("#name").val();
	user["email"] = $("#email").val();
	user["password"] = $("#password").val();
	
	const userJSON = JSON.stringify(user);
	
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/user/create",
        data: userJSON,
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (user) {

            var json = "<h4>Ajax Response</h4><pre>"
                + JSON.stringify(user, null, 4) + "</pre>";
            $('#feedback').html(json);

            console.log("SUCCESS : ", user);
            $("#btn-search").prop("disabled", false);

        },
        error: function (e) {

            var json = "<h4>Ajax Response</h4><pre>"
                + e.responseText + "</pre>";
            $('#feedback').html(json);

            console.log("ERROR : ", e);
            $("#btn-search").prop("disabled", false);

        }
    });

}