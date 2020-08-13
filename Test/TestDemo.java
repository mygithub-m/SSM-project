import cn.learn.dao.impl.EmployeeDao;
import cn.learn.model.Employee;
import cn.learn.model.Manager;
import cn.learn.service.impl.EmployeeService;
import cn.learn.service.impl.ManagerService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TestDemo {

    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        EmployeeDao employee = (EmployeeDao) context.getBean("employeeDao");
        List<Employee> employees = employee.selectAll();
        for (Employee employee1 : employees) {
            System.out.println(employee1);
        }
    }

    @Test
    public void test02(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        EmployeeService employee = (EmployeeService) context.getBean("employeeService");
        List<Employee> employees = employee.selectAll();
        for (Employee employee1 : employees) {
            System.out.println(employee1);
        }
    }

    @Test
    public void test03(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        SqlSessionFactory factory = (SqlSessionFactory) context.getBean("sqlSessionFactory");
        System.out.println(factory);
        SqlSession session = factory.openSession();
        System.out.println(session);
    }

    @Test
    public void test04(){
        Manager manager = new Manager();
        manager.setM_name("may");
        manager.setM_password("123456");

        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        ManagerService managerService = (ManagerService) context.getBean("managerService");
        Manager manager1 = managerService.selectOne(manager);
        System.out.println(manager1);

    }

    @Test
    public void test05() throws Exception {
        FileOutputStream fos = new FileOutputStream("manager.config",true);

        //获取当前时间
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String time = format.format(date);
        String message = time+"，管理员xxx正在操作\r\n";

        fos.write(message.getBytes());
        fos.close();

    }

    @Test
    public void test06(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        EmployeeService employee = (EmployeeService) context.getBean("employeeService");
        employee.selectAll();
    }


}
