window.addEventListener("load", function () {

  //员工信息表格隔行变色
  var trs = document.querySelectorAll(".container .table table tr");

  for (var i = 0; i < trs.length; i++) {
    if (i % 2 == 0) {
      trs[i].style.backgroundColor = "black";
    } else {
      trs[i].style.backgroundColor = "gray";
    }
  }

  //部门员工信息表格隔行变色
  var d_trs = document.querySelectorAll(".container .d_table table tr");
  for (var i = 0; i < d_trs.length; i++) {
    if (i % 2 == 0) {
      d_trs[i].style.backgroundColor = "black";
    } else {
      d_trs[i].style.backgroundColor = "gray";
    }
  }
  //删除员工
  var deletes = document.querySelectorAll(".delete");
  var form = document.querySelector("#form");
  for (var i = 0; i < deletes.length; i++) {
    deletes[i].onclick = function () {
      if (confirm("你确定要删除这个员工吗?")) {
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