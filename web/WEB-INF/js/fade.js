window.addEventListener("load", function () {
    //部门下所有员工信息表格显示

    var alls = document.querySelectorAll(".container .d_table table .allEmployee");
    var e_table = document.querySelector(".container .e_table");
    var e_list = document.querySelector(".container .e_table .list");
    var flag = false;
    var close = document.querySelector(".container .e_table .close");

    //信息显示
    for (var i = 0; i < alls.length; i++) {
        alls[i].onclick = function () {
            if (flag) {
                 //如果已经有信息在展示，则必须先关闭
                 if(confirm("你确定要关闭正在展示的信息吗?")){
                     //确认关闭
                    close.click();
                    flag = false;
                 } else {
                     //不关闭当前展示，则点击无效
                 }
            } else {
                //如果信息没有展示，则显示
                var timer = setInterval(function () {
                    e_list.style.display = "block";
                    clearInterval(timer);
                }, 2000);
                e_table.style.opacity = "1";
                flag = true;
            }
        }
    }

    //关闭展示
    close.addEventListener("click",function () {
        e_table.style.opacity = "0";
        e_list.style.display = "none";
        flag = false;
    });

});