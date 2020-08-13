package cn.learn.dao.impl;

import cn.learn.dao.IDepartmentDao;
import cn.learn.model.Department;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class DepartmentDao implements IDepartmentDao {
    private SqlSessionFactory factory;

    @Resource
    public void setFactory(SqlSessionFactory factory) {
        this.factory = factory;
    }

    protected SqlSession openSession() {
        return factory.openSession();
    }

    @Override
    public void add(Department department) {
        openSession().insert(Department.class.getName() + ".add", department);
    }

    @Override
    public void delete(int id) {
        openSession().delete(Department.class.getName() + ".delete",id);
    }

    @Override
    public void update(Department department) {
        openSession().update(Department.class.getName() + ".update", department);
    }

    @Override
    public Department selectById(int id) {
        Department department = openSession().selectOne(Department.class.getName() + ".selectById", id);
        return department;
    }

    @Override
    public List<Department> selectAll() {
        List<Department> departments = openSession().selectList(Department.class.getName() + ".selectAll");
        return departments;
    }
}
