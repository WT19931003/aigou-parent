package cn.wutao.aigou.service.impl;

import cn.wutao.aigou.domain.User;
import cn.wutao.aigou.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Override
    public User findAll() {
        return new User(1L,"123456","123456");
    }
}
