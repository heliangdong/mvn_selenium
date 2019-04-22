package cn.e3mall.mapper;

import cn.e3mall.pojo.User;

public interface UserMapper {
    User  queryByusername(String username);
    void save(User user);
}
