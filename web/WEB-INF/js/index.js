window.addEventListener("load",function () {

    // 部门与员工切换
    var div1 = document.getElementsByClassName("option1");
    var div2 = document.getElementsByClassName("option2");

    div1[0].onmouseover = function () {
            
             this.style.zIndex = "3";
             this.style.width = "100px";
             this.style.height = "100px";
             this.style.borderRadius = "50px";
             this.style.lineHeight = "100px";
             this.style.backgroundColor = "white";
             this.style.color = "black";

             div2[0].style.zIndex = "1";
             div2[0].style.width = "80px";
             div2[0].style.height = "80px";
             div2[0].style.borderRadius = "40px";
             div2[0].style.lineHeight = "80px";
             div2[0].style.top = "40px";
             div2[0].style.left = "70px";
             div2[0].style.backgroundColor = "rgba(238, 238, 238, 0.5)";
             div2[0].style.color = "white";
    }
    div2[0].onmouseover = function () {
        this.style.zIndex = "3";
             this.style.width = "100px";
             this.style.height = "100px";
             this.style.borderRadius = "50px";
             this.style.lineHeight = "100px";
             this.style.top = "30px";
             this.style.left = "60px";
             this.style.backgroundColor = "white";
             this.style.color = "black";

             div1[0].style.zIndex = "1";
             div1[0].style.width = "80px";
             div1[0].style.height = "80px";
             div1[0].style.borderRadius = "40px";
             div1[0].style.lineHeight = "80px";
             div1[0].style.backgroundColor = "rgba(238, 238, 238, 0.5)";
             div1[0].style.color = "white";
    }

   //菜单栏选中样式
   var box = document.getElementsByClassName("box1");   

    var iframe = document.querySelector(".page iframe");
   for(var i=0;i<box.length;i++){
       box[i].onclick = function () {
            //移除类名
           for(var i = 0;i<box.length;i++){
               box[i].classList.remove("selected");
           }
           //添加类名
           this.classList.add("selected");

           //页面转跳
            iframe.src =  this.href;
             return false;  
         }
   }

  


});