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
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/department")
public class DepartmentController {
    private DepartmentService departmentService;
    private EmployeeService employeeService;

    @Resource
    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Resource
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //部门管理首页
    @RequestMapping("/index")
    public String index(){
        return "/department/d_index";
    }

    //部门列表展示
    @RequestMapping("/list")
    public String list(Model model){
        List<Department> departments = departmentService.selectAll();
        model.addAttribute("departments",departments);
        return "/department/d_list";
    }

    //进入添加页面
    @RequestMapping("/addDepartmentPage")
    public String addPage(){
        return "/department/d_add";
    }

    //提交添加内容
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String addDepartment(Department department){
        departmentService.add(department);
        return "redirect:/department/list";
    }

    //进入修改页面
    @RequestMapping("/updateDepPage/{did}")
    public String updatePage(Model model,@PathVariable Integer did){
        Department department = departmentService.selectById(did);
        model.addAttribute("department",department);
        return "/department/d_update";
    }

    //提交修改内容
    @RequestMapping(value = "/{did}",method = RequestMethod.PUT)
    public String update(Department department,@PathVariable Integer did){
        department.setD_id(did);
        departmentService.update(department);
        return "redirect:/department/list";
    }

    //删除部门
    @RequestMapping(value = "/{did}",method = RequestMethod.DELETE)
    public String delete(@PathVariable Integer did){
        employeeService.deleteByDid(did);
        departmentService.delete(did);  //删除部门
        return "redirect:/department/list";
    }

    //展示一个部门下的所有员工
    @ResponseBody
    @RequestMapping(value = "/all/{did}",method = RequestMethod.GET)
    public List<Employee> allEmp(Model model, @PathVariable Integer did){
        List<Employee> employees = employeeService.selectAllByDid(did);
//        model.addAttribute("employees",employees);
//        Department department = departmentService.selectById(did);
//        model.addAttribute("department",department);
        return employees;
    }

}
