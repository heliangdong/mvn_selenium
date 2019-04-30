package cn.e3mall.mapper;

import cn.e3mall.pojo.Function;

import java.util.List;

public interface FunctionMapper {
    List<Function> selectAll();
    void saveFunction(Function function);
    Function querybyid(String id);
    List<Function>   querybyidandmenu(String[] id);
    List<Function> queryAllbasemenu();
}
