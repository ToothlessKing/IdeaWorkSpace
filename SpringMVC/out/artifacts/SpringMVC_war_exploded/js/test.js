$(function () {
    alert(11);
    $.ajax({
       url:"/firstTest.do",
        success:function (data) {
           alert(11);
           alert(data);
        }
    });
});