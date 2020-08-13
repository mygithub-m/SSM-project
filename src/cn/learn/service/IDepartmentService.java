package cn.learn.service;

import cn.learn.model.Department;

import java.util.List;

public interface IDepartmentService {
    public void add(Department department);
    public void delete(int id);
    public void update(Department department);
    public Department selectById(int id);
    public List<Department> selectAll();
}
