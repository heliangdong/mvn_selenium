package cn.e3mall.pojo;

public class OperationPool {
    private int id;
    private String name;
    private String  Ctime;
    private String  lastruntime;
    private String result;
    private String Operator;//操作人
    private String Remarks;
    private String image_name;//存储截图名称
    private int testcaseid;
    private String  project_id;
    private Project project;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCtime() {
        return Ctime;
    }

    public void setCtime(String ctime) {
        Ctime = ctime;
    }

    public String getLastruntime() {
        return lastruntime;
    }

    public void setLastruntime(String lastruntime) {
        this.lastruntime = lastruntime;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getOperator() {
        return Operator;
    }

    public void setOperator(String operator) {
        Operator = operator;
    }

    public String getRemarks() {
        return Remarks;
    }

    public void setRemarks(String remarks) {
        Remarks = remarks;
    }

    public String getImage_name() {
        return image_name;
    }

    public void setImage_name(String image_name) {
        this.image_name = image_name;
    }

    public int getTestcaseid() {
        return testcaseid;
    }

    public void setTestcaseid(int testcaseid) {
        this.testcaseid = testcaseid;
    }

    public String getProject_id() {
        return project_id;
    }

    public void setProject_id(String project_id) {
        this.project_id = project_id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return "OperationPool{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Ctime='" + Ctime + '\'' +
                ", lastruntime='" + lastruntime + '\'' +
                ", result='" + result + '\'' +
                ", Operator='" + Operator + '\'' +
                ", Remarks='" + Remarks + '\'' +
                ", image_name='" + image_name + '\'' +
                ", testcaseid=" + testcaseid +
                ", project_id='" + project_id + '\'' +
                ", project=" + project +
                '}';
    }
}
