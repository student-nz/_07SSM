package com.yj.nz.spring.dao.impl;

import com.yj.nz.spring.dao.UserDao;

public class UserDaoImpl implements UserDao {
    @Override
    public void saveUser() {
        System.out.println("保存成功");
    }
}
