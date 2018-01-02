package com.fx.wechat.service;

import com.fx.core.dao.model.User;
import org.springframework.stereotype.Service;

/**
 * Created by JONES on 2017/12/29.
 */
@Service
public interface UserService {

    User getUser(String id);
}
