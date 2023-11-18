var countClick =0;
$(function () {
    $('#btnMenu').click( function() {
            countClick = countClick+1;
            if(countClick%2===0) {
                $('#navbar').hide();
                $('#searchTb').css('top', 80 + 'px');
                $('#usersTb').css('top', 120 + 'px');
            }
            else {
                $('#navbar').show();
                $('#searchTb').css('top', 140 + 'px');
                $('#usersTb').css('top', 170 + 'px');
            }
        }
    )});