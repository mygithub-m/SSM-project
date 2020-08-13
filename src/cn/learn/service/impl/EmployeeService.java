package cn.learn.service.impl;

import cn.learn.dao.impl.EmployeeDao;
import cn.learn.model.Department;
import cn.learn.model.Employee;
import cn.learn.service.IEmployeeService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class EmployeeService implements IEmployeeService {
    private EmployeeDao employeeDao;

    @Resource
    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public void add(Employee employee) {
       employeeDao.add(employee);
    }

    @Override
    public void delete(int id) {
      employeeDao.delete(id);
    }

    @Override
    public void update(Employee employee) {
       employeeDao.update(employee);
    }

    @Override
    public Employee selectById(int id) {
        return employeeDao.selectById(id);
    }

    @Override
    public List<Employee> selectAll() {
        return employeeDao.selectAll();
    }

    @Override
    public void deleteByDid(int did) {
        employeeDao.deleteByDid(did);
    }

    @Override
    public List<Employee> selectAllByDid(int did) {
        return employeeDao.selectAllByDid(did);
    }

    @Override
    public void aspect(String name) {
        System.out.println("操作中....");
    }

}
