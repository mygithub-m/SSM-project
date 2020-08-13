package cn.learn.dao.impl;

import cn.learn.dao.IManagerDao;
import cn.learn.model.Manager;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class ManagerDao implements IManagerDao {

    private SqlSessionFactory factory;

    @Resource
    public void setFactory(SqlSessionFactory factory) {
        this.factory = factory;
    }

    protected SqlSession openSession() {
        return factory.openSession();
    }

    @Override
    public Manager selectOne(Manager manager) {
        Manager m = openSession().selectOne(Manager.class.getName() + ".selectOne", manager);
        return m;
    }
}
