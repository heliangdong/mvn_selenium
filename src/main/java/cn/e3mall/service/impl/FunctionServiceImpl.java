package cn.e3mall.service.impl;


import cn.e3mall.mapper.FunctionMapper;
import cn.e3mall.mapper.RoleMapper;
import cn.e3mall.pojo.Function;
import cn.e3mall.pojo.Role;
import cn.e3mall.pojo.User;
import cn.e3mall.service.FunctionService;
import cn.e3mall.utils.getUserName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FunctionServiceImpl  implements FunctionService {
    @Autowired
    private FunctionMapper functionMapper;
    @Autowired
    private RoleMapper roleMapper;

    public List<Function> list() {
        return functionMapper.selectAll();
    }

    public void save(Function function) {
        functionMapper.saveFunction(function);
    }

    public List<Function> querymenu(User user) {
        getUserName getUserName=new getUserName();
        List<Function> functionList=null;
        System.out.println("开始赋予菜单权限");
        if(user.getUsername().equals("admin")){
            functionList=functionMapper.queryAllbasemenu();
        }else{
            //根据用户查询角色
            Role role = roleMapper.QueryByid(user.getRole_id());
            //根据role查询权限
            String functionIds = role.getFunctionIds();
            String[] functionid = functionIds.split(",");
            //根据functionId查询权限表
            functionList = functionMapper.querybyidandmenu(functionid);

        }

        return functionList;
    }
}
