package cn.learn.service;

import cn.learn.model.Department;
import cn.learn.model.Employee;

import java.util.List;

public interface IEmployeeService {
    public void add(Employee employee);
    public void delete(int id);
    public void update(Employee employee);
    public Employee selectById(int id);
    public List<Employee> selectAll();
    public void deleteByDid(int did);
    public List<Employee> selectAllByDid(int did);
    public void aspect(String name);
}
