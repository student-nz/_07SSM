package com.yj.nz.spring.service.impl;

import com.yj.nz.spring.dao.UserDao;
import com.yj.nz.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    //@Qualifier("userDaoImpl")
    private UserDao userDao;

    @Override
    public void saveUser() {
        userDao.saveUser();
    }
}
