package cn.e3mall.pojo;

import java.util.HashSet;
import java.util.Set;

public class TestCaseFunction {
    private int id;
    private int pId;
    private String name;
    private String page;
    private String testcaseid;
    private String projectid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }



    public String getTestcaseid() {
        return testcaseid;
    }

    public void setTestcaseid(String testcaseid) {
        this.testcaseid = testcaseid;
    }

    public String getProjectid() {
        return projectid;
    }

    public void setProjectid(String projectid) {
        this.projectid = projectid;
    }

    public String toString() {
        return "{" +
                "\"id\":\"" + id + "\"" +
                ", \"pId\":\"" + pId + "\"" +
                ", \"name\":\"" + name + "\"" +
                ", \"page\":\"" + page + "\"" +
                '}';
    }
}
