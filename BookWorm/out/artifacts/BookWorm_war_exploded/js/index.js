$(function() {

    //展示种类列表发送ajax请求
    $.ajax({
        type:"POST",
        url:"/FindAllCategoryServlet",
        data:"",
        success:function (data){
            // console.log(data)
            //将响应过来的数据通过表达式展示在页面中
            var str = "";
            for(var i = 0;i < data.length;i++){
                str +=
                    '<li><a href="/GoodsListServlet?cid='+ data[i].id +'&pageNo=1">'+ data[i].name +'</a></li>'

                if(i == data.length-1){
                    str += '<li class="dropdown">'+
                        '<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span>电子书</span><span class="caret"></span></a>'+
                        '<ul class="dropdown-menu">'+
                        '<li><a href="#"><span>文学</span></a></li>'+
                        '<li><a href="#"><span>经济管理</span></a></li>'+
                        '<li><a href="#"><span>人文社科</span></a></li>'+
                        '<li role="separator" class="divider"></li>'+
                        '<li><a href="#"><span>漫画</span></a></li>'+
                        '<li role="separator" class="divider"></li>'+
                        '<li><a href="https://www.baidu.com/"><span>点击搜索更多</span></a></li>'+
                        '</ul>'+
                        '</li>'
                }

            }

            $("#mallUl").append(str)
        },
        error:function (msg){
            alert("页面出现了错误")
        }
    },"json")


    //展示首页最新商品数据
    $.ajax({
        type:"POST",
        url:"/FindAllNewGoodsLimitServlet",
        data:"",
        success:function (data){
            console.log(data)
            //将响应过来的数据通过表达式展示在页面中
            var str = "";
            for(var i = 0;i < data.length;i++){
                str +=
                    '<div class="col-md-2">'+
                    '<a href="/DetailServlet?gid='+data[i].id+'"><img src="/'+ data[i].image +'" /></a>'+
                    '<p class="book_title">'+ data[i].name +'</p>'+
                    '<blockquote>'+
                    '<p class="lead" class="author">'+ data[i].author +'</p>'+
                    '</blockquote>'+
                    '<p class="price">￥' + data[i].salesprice + '</p>'+
                    '<img src="../img/star.png" class="star" />'+
                    '</div>';
            }

            $("#newBook").append(str)
        },
        error:function (msg){
            alert("页面出现了错误")
        }
    },"json")



})

