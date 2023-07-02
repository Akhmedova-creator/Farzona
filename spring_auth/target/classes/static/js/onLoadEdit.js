$(window).on('load', function() {
    //заполнение логтн и пароль
    $('#login').val($.cookie('user'))
    $('#password').val($.cookie('pass'))
    $.get("/getOneUser", {login: $('#login').val(), pass: $('#password').val()}).done(function (user) {
        var nationality = $("#selectNationality option:contains('" + user.nationality + "')").attr('value');
        $("#selectNationality").val(nationality);

        var job = $("#selectJob option:contains('" + user.job + "')").attr('value');
        $("#selectJob").val(job);

        var town = $("#selectTown option:contains('" + user.town + "')").attr('value');
        $("#selectTown").val(town);

        var age = $("#selectAge option:contains('" + user.age + "')").attr('value');
        $("#selectAge").val(age);

        if (user.female === 'женский') {
            $('#woman_female').prop('checked', true);
        } else {
            $('#man_female').prop('checked', true);

        }
    })
});