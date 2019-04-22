package cn.e3mall.service;

import cn.e3mall.pojo.Role;

import java.util.List;

public interface RoleService {
    void save(Role role);

    List<Role> list();
}
