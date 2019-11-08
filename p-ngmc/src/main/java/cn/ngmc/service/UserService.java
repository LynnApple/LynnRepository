package cn.ngmc.service;

import cn.ngmc.entity.User;

/**
 * 用户接口
 */
public interface UserService {

    int regiter(User user);

    User getUser(Long uid);

    int editUser(User user);


}
