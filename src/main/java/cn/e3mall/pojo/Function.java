package cn.e3mall.pojo;

import java.util.HashSet;
import java.util.Set;

public class Function {
    private String id;
    private String name;
    private String code;
    private String description;
    private String page;
    private String generatemenu;//是否生成菜单，1：是 0：否
    private Integer zindex;
    private String pid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getGeneratemenu() {
        return generatemenu;
    }

    public void setGeneratemenu(String generatemenu) {
        this.generatemenu = generatemenu;
    }

    public Integer getZindex() {
        return zindex;
    }

    public void setZindex(Integer zindex) {
        this.zindex = zindex;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String toString() {
        return "{" +
                "\"id\":\"" + id + "\"" +
                ", \"pId\":\"" + pid + "\"" +
                ", \"name\":\"" + name + "\"" +
                ", \"page\":\"" + page + "\"" +
                '}';
    }


}
