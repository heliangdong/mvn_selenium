package cn.e3mall.service.impl;

import cn.e3mall.mapper.RoleMapper;
import cn.e3mall.pojo.Role;
import cn.e3mall.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl  implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    public void save(Role role) {
        roleMapper.save(role);
    }

    public List<Role> list() {
        return roleMapper.QueryAll();
    }
}
