package cn.learn.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 用于产生日志信息的切面类
 */
@Component
@Aspect
public class ConfigAspect {

    //添加一个环绕通知
    @Around("execution(public * cn.learn.service.impl.*.*(..))")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        //获取当前时间
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String time = format.format(date);

        //获取操作名
        String str = point.toString();
        String strs = str.substring(str.lastIndexOf(".")+1, str.lastIndexOf("("));

        //获取操作的表名
        String table = point.getTarget().toString();
        String t_name = table.substring(table.indexOf("impl")+5,table.indexOf("Service")).toLowerCase();
        //获取日志文件输出流
        FileOutputStream fos = new FileOutputStream("F:\\IDEA项目\\SSMFrame\\manager.config",true);
        OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");

        osw.write("==================>\r\n");

        //获取日志信息
        String message ="[" +time+"]" + "   开始对"+t_name+"表进行"+strs+"操作\r\n";

        //将信息写入文件
        osw.write(message);

        //执行当前连接点方法
        Object result = point.proceed();

        Date date1 = new Date();
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String time1 = format.format(date);

        message ="[" +time+"]" + "   结束对"+t_name+"表进行"+strs+"操作\r\n";
        osw.write(message);

        osw.flush();

        //关闭流对象
        osw.close();
        return result;
    }

    //添加一个前置通知
//    @Before("execution(public * cn.learn.service.impl.*.*(..))")
    public void before(){

    }
}
