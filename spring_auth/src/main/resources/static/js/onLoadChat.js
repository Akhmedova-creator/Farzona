$(window).on('load', function() {

  //  заполнение логтн и пароль
    $('#myLogin').val($.cookie('user'))
    $('#myPassword').val($.cookie('pass'))
    $.get("/getOneUser", {login: $('#myLogin').val(), pass: $('#myPassword').val()}).done(function (user) {
        $('#myId').val(user.id) ;
    })
});