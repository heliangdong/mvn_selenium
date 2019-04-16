package cn.e3mall.service.impl;

import cn.e3mall.mapper.ProjectMapper;
import cn.e3mall.mapper.TestCaseFunctionMapper;
import cn.e3mall.pojo.Project;
import cn.e3mall.pojo.TestCaseFunction;
import cn.e3mall.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectMapper projectMapper;
    @Autowired
    private TestCaseFunctionMapper testCaseFunctionMapper;

    public List<Project> list() {
        return projectMapper.QueryList();
    }

    public void save(String Projectname) {
        Project project=new Project();
        project.setProjectname(Projectname);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        project.setProject_ctime(df.format(new Date()));
        projectMapper.save(project);
        //保存Ztree
        TestCaseFunction testCaseFunction=new TestCaseFunction();
        testCaseFunction.setpId(0);
        testCaseFunction.setName(Projectname);
        testCaseFunction.setProjectid(projectMapper.QueryMaxId());
        testCaseFunctionMapper.insert(testCaseFunction);

    }

    public void deletes(String[] id) {
        for(String idStr:id){
            projectMapper.deleteById(idStr);
            //删除ztree
            testCaseFunctionMapper.deleteByProjectid(idStr);
        }
    }
}
