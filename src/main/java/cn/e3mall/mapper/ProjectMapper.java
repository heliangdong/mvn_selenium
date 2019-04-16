package cn.e3mall.mapper;

import cn.e3mall.pojo.Project;

import java.util.List;

public interface ProjectMapper {
    List<Project> QueryList();

    void save(Project project);

    String QueryMaxId();

    void deleteById(String project_id);
}
