window.addEventListener("load", function () {
    //删除员工
    var deletes = document.querySelectorAll(".delete");
    var form = document.querySelector("#form");
    for (var i = 0; i < deletes.length; i++) {
        deletes[i].onclick = function () {
            if (confirm("你确定要删除这个部门吗?如果确定，部门下的员工也会一起被删除。")) {
                //确定要删除
                form.action = this.href;
                form.submit();
                return false;
            } else {
                //不删除
                return false;
            }
        }
    }
});