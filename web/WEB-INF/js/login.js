window.addEventListener("load",function(){
      var login = document.getElementsByClassName("login");
      var arr = ["red","orange","yellow","green","cyan","blue","purple"];

      var i = 0;
      setInterval(function () {
             if( i == 7){
                 i = 0;
             }
             login[0].style.border = "1px solid "+arr[i];
             i++;
        },1000);

});