window.addEventListener("load",bounce);

function bounce(){

    var ele = document.getElementsByClassName("bounce");
    var speed = ele[0].getAttribute("speed") == null ? 10 : ele[0].getAttribute("speed"); //获取移动速度
    var body = document.body;

    var x = 1; //每一次移动的距离
    var y = 1;
    var timer = createTimer();

    //鼠标移动到元素上，元素停止移动
    for (var i = 0; i < ele.length; i++) {
        ele[i].onmouseover = function () {
           closeTimer(timer);
        }
    }

    //鼠标移出元素，元素开始移动
    for (var i = 0; i < ele.length; i++) {
        ele[i].onmouseout = function () {
            timer = createTimer();
        }
    }

    //鼠标双击关闭
    for(var i=0;i<ele.length;i++){
        ele[i].ondblclick = function(){
           this.style.display = "none";
        }
    }

    //创建计时器
    function createTimer() {
        var timer = setInterval(function () {
            for (var i = 0; i < ele.length; i++) {
                if (ele[i].offsetTop + ele[i].clientHeight >= window.innerHeight + window.pageYOffset) {
                    ele[i].style.top = window.innerHeight + window.pageYOffset - ele[i].clientHeight + "px";
                    y = -1;
                } else if (ele[i].offsetTop <= window.pageYOffset) {
                    ele[i].style.top = window.pageYOffset + "px";
                    y = 1;
                }

                if ((ele[i].offsetLeft + ele[i].clientWidth) >= body.clientWidth + window.pageXOffset) {
                    ele[i].style.left = body.clientWidth + window.pageXOffset - ele[i].clientWidth + "px";
                    x = -1;
                } else if (ele[i].offsetLeft <= window.pageXOffset) {
                    ele[i].style.left = +window.pageXOffset + "px";
                    x = 1;
                }

                ele[i].style.top = ele[i].offsetTop + y + "px";
                ele[i].style.left = ele[i].offsetLeft + x + "px";
            }
        }, speed);
        return timer;
    }

    //关闭计时器
    function closeTimer(timer) {
         clearInterval(timer);
    }
}