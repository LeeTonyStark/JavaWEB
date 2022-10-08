//在页面加载完之后，查询数据库，将数据展示在前端页面
$(function() {
    $.ajax({
        type:"POST",
        url:"/FindAllAddressServlet",
        contentType: "application/x-www-form-urlencoded",
        data:"",
        success:function (data){

        },
        error:function (msg){
            alert("页面出现了错误")
        }
    },"json");
})