package cn.ngmc.dao;

import cn.ngmc.entity.User;



public interface UserMapper {

    User selectById(Long userId);
    int deleteById(Long userId);
    int insert(User record);
    int updateById(User record);
}