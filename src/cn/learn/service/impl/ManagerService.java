package cn.learn.service.impl;

import cn.learn.dao.impl.ManagerDao;
import cn.learn.model.Manager;
import cn.learn.service.IManagerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ManagerService implements IManagerService {
    private ManagerDao managerDao;

    @Resource
    public void setManagerDao(ManagerDao managerDao) {
        this.managerDao = managerDao;
    }

    @Override
    public Manager selectOne(Manager manager) {
        return managerDao.selectOne(manager);
    }
}
