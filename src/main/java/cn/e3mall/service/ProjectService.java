package cn.e3mall.service;

import cn.e3mall.pojo.Project;

import java.util.List;

public interface ProjectService {
    List<Project> list();

    void save(String Projectname);

    void deletes(String[] id);
}
