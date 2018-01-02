package com.fx.wechat.service.impl;

import com.fx.core.common.DatabaseContextHolder;
import com.fx.core.common.DatabaseType;
import com.fx.core.dao.mapper.UserMapper;
import com.fx.core.dao.model.User;
import com.fx.wechat.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * Created by JONES on 2017/12/29.
 */
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public User getUser(String id){
        DatabaseContextHolder.setDatabaseType(DatabaseType.dbSourceFirst);
        return  userMapper.selectByPrimaryKey(id);
    }
}
