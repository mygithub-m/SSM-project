package cn.learn.service.impl;

import cn.learn.dao.impl.DepartmentDao;
import cn.learn.model.Department;
import cn.learn.service.IDepartmentService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class DepartmentService implements IDepartmentService {
    private DepartmentDao departmentDao;

    @Resource
    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    public void add(Department department) {
        departmentDao.add(department);
    }

    @Override
    public void delete(int id) {
       departmentDao.delete(id);
    }

    @Override
    public void update(Department department) {
        departmentDao.update(department);
    }

    @Override
    public Department selectById(int id) {
        return departmentDao.selectById(id);
    }

    @Override
    public List<Department> selectAll() {
        return departmentDao.selectAll();
    }
}
