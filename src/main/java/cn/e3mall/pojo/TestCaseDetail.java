package cn.e3mall.pojo;

import javafx.scene.chart.PieChart;

import java.util.Date;
import java.util.List;

public class TestCaseDetail {
    private int id;
    private String name;
    private int caseactionid;
    private String element;
    private Date ctime;
    private String Remarks;
    private String testcaseid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCaseactionid() {
        return caseactionid;
    }

    public void setCaseactionid(int caseactionid) {
        this.caseactionid = caseactionid;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public String getRemarks() {
        return Remarks;
    }

    public void setRemarks(String remarks) {
        Remarks = remarks;
    }

    public String getTestcaseid() {
        return testcaseid;
    }

    public void setTestcaseid(String testcaseid) {
        this.testcaseid = testcaseid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TestCaseDetail{" +
                "id=" + id +
                ", caseactionid='" + caseactionid + '\'' +
                ", element='" + element + '\'' +
                ", ctime=" + ctime +
                ", Remarks='" + Remarks + '\'' +
                ", testcaseid=" + testcaseid +
                '}';
    }
}
