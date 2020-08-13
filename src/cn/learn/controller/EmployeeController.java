package cn.learn.controller;

import cn.learn.model.Department;
import cn.learn.model.Employee;
import cn.learn.service.impl.DepartmentService;
import cn.learn.service.impl.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/employee")
@Controller
public class EmployeeController {
    private EmployeeService employeeService;
    private DepartmentService departmentService;

    @Resource
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Resource
    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    //员工信息列表展示
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String employeeList(Model model) {
        List<Employee> employees = employeeService.selectAll();
        model.addAttribute("employees", employees);
        return "employee/list";
    }

    //进入员工首页
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model) {
        return "employee/index";
    }

    //进入员工添加页面
    @RequestMapping(value = "/addEmployeePage", method = RequestMethod.GET)
    public String addEmployeePage(Model model) {
        List<Department> departments = departmentService.selectAll();
        model.addAttribute("departments", departments);
        return "employee/add";
    }

    //将添加的员工信息写入数据库
    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public String addEmployee(String e_name, String e_email, Integer department) {
        Employee employee = new Employee();
        employee.setE_name(e_name);
        employee.setE_email(e_email);
        List<Department> departments = departmentService.selectAll();
        for (Department department1 : departments) {
            if (department1.getD_id() == department) {
                employee.setDepartment(department1);
                break;
            }
        }
        employeeService.add(employee);
        return "redirect:/employee/list";
    }

    //进入员工信息修改页面
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String updateEmployeePage(@PathVariable Integer id, Model model) {
        Employee employee = employeeService.selectById(id);
        List<Department> departments = departmentService.selectAll();
        model.addAttribute("employee", employee);
        model.addAttribute("departments", departments);
        return "employee/update";
    }

    //将修改后的员工信息写入数据库
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String updateEmployee(Employee employee, Integer did) {
        Department department = departmentService.selectById(did);
        employee.setDepartment(department);
        employeeService.update(employee);
        return "redirect:/employee/list";
    }

    //从数据库删除当前员工信息
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable Integer id) {
        employeeService.delete(id);
        return "redirect:/employee/list";
    }
}
