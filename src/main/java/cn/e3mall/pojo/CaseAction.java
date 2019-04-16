package cn.e3mall.pojo;

import java.io.Serializable;

public class CaseAction implements Serializable {
    private int id;
    private String Actionname;
    private String Remarks;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getActionname() {
        return Actionname;
    }

    public void setActionname(String actionname) {
        Actionname = actionname;
    }

    public String getRemarks() {
        return Remarks;
    }

    public void setRemarks(String remarks) {
        Remarks = remarks;
    }
}
