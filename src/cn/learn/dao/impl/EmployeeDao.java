package cn.learn.dao.impl;

import cn.learn.dao.IEmployeeDao;
import cn.learn.model.Employee;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class EmployeeDao implements IEmployeeDao {
    private SqlSessionFactory factory;

    @Resource
    public void setFactory(SqlSessionFactory factory) {
        this.factory = factory;
    }

    protected SqlSession openSession() {
        return factory.openSession();
    }

    @Override
    public void add(Employee employee) {
        openSession().insert(Employee.class.getName() + ".add", employee);
    }

    @Override
    public void delete(int id) {
        openSession().delete(Employee.class.getName() + ".delete", id);
    }

    @Override
    public void update(Employee employee) {
        openSession().update(Employee.class.getName() + ".update", employee);
    }

    @Override
    public Employee selectById(int id) {
        Employee employee = openSession().selectOne(Employee.class.getName() + ".selectById", id);
        return employee;
    }

    @Override
    public List<Employee> selectAll() {
        List<Employee> employees = openSession().selectList(Employee.class.getName() + ".selectAll");
        return employees;
    }

    @Override
    public void deleteByDid(int did) {
        openSession().delete(Employee.class.getName() + ".deleteByDid", did);
    }

    @Override
    public List<Employee> selectAllByDid(int did) {
        List<Employee> employees = openSession().selectList(Employee.class.getName() + ".selectAllByDid", did);
        return employees;
    }

}
