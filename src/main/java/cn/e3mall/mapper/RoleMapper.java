package cn.e3mall.mapper;

import cn.e3mall.pojo.Role;

import java.util.List;

public interface RoleMapper {
     void save(Role role);
     List<Role> QueryAll();
     Role QueryByid(String id);
}
