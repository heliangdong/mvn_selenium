package cn.e3mall.service.impl;

import cn.e3mall.mapper.CustomerMapper;
import cn.e3mall.mapper.OperationPoolMapper;
import cn.e3mall.mapper.TestCaseDetailMapper;
import cn.e3mall.pojo.Customer;
import cn.e3mall.pojo.OperationPool;
import cn.e3mall.pojo.TestCaseDetail;
import cn.e3mall.service.SeleniumService;
import cn.e3mall.utils.GetImageName;
import com.google.common.base.Joiner;
import org.openqa.selenium.*;

import org.openqa.selenium.Rectangle;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class SeleniumServiceImpl implements SeleniumService {

    @Autowired
    private TestCaseDetailMapper testCaseDetailMapper;
    @Autowired
    private OperationPoolMapper operationPoolMapper;
    @Autowired
    private CustomerMapper customerMapper;

    @Value("${Image_Path}")
    private String Image_Path;



    public void run(String ids) throws InterruptedException, AWTException, IOException {
        //ids为OperationPool主键
        String[] id = ids.split(",");
        System.setProperty("webdriver.chrome.driver", "D://javaproject//Selenium//tools//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //执行用例前设置COOKIE，获取项目ID拿到主页
        //根据id获取project_id
        OperationPool operationPoolStr = operationPoolMapper.querybyid(Integer.parseInt(id[0]));
        String project_id = operationPoolStr.getProject_id();
        Customer customer=new Customer();
        //根据project_id获取主页,设置cookie
        Customer customer1 = customerMapper.queryByProjectid(project_id);
        driver.get(customer1.getUrl());
        Cookie jym_session_id=new Cookie("jym_session_id",customer1.getJym_session_id());
        driver.manage().addCookie(jym_session_id);
        //循环执行一个用例
        for(int k=0;k<id.length;k++){
            //定义运行结果
            String result=null;//0未运行   1成功，2失败
            //存储截图名称
            List<String> imagelist=new ArrayList<String>();
            //创建operationpool对象用于更新记录
            OperationPool operationPoolUpdate =new OperationPool();
            try {
            //根据ID获取testcaseid
            OperationPool operationPool = operationPoolMapper.querybyid(Integer.parseInt(id[k]));
            List<TestCaseDetail> Elementlists = testCaseDetailMapper.queryElementBycaseactionid(operationPool.getTestcaseid());
            //声明一个数组，用于存储action为3的element
            String[] elemen=new String[Elementlists.size()];
            int i=0;
            int j=0;
            for(TestCaseDetail testCaseDetail1:Elementlists){
                elemen[i]=testCaseDetail1.getElement();
                System.out.println("element"+elemen[i]);
                i++;
            }
            List<TestCaseDetail> testCaseDetails = testCaseDetailMapper.queryTestCaseDetailBytestcaseid(operationPool.getTestcaseid());
            for(TestCaseDetail testCaseDetail:testCaseDetails) {
                if (testCaseDetail.getCaseactionid() == 1) {
                    driver.get(testCaseDetail.getElement());

                }
                if (testCaseDetail.getCaseactionid() == 2) {
                    driver.findElement(By.xpath(testCaseDetail.getElement())).sendKeys(elemen[j]);
                    j++;
                }
                if (testCaseDetail.getCaseactionid() == 4) {
                    driver.findElement(By.xpath(testCaseDetail.getElement())).click();
                }
                if (testCaseDetail.getCaseactionid() == 6) {
                    // 调用截图方法
                    BufferedImage image = null;
                    image = new Robot().createScreenCapture(new java.awt.Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
                    GetImageName getImageName = new GetImageName();
                    //获取保存路径
                    String imagename = getImageName.getImageName();
                    String url = Image_Path + imagename + ".png";
                    ImageIO.write(image, "png", new File(url));
                    imagelist.add(imagename);
                }
                //设置结果为运行成功
                result="1";

            }
            }catch (Exception e){
                //设置结果为运行失败
                result="2";
                e.printStackTrace();
            }finally {
                //imagelist转换为字符串
                String image_name = Joiner.on(",").join(imagelist);
                //设置最后运行时间
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
                operationPoolUpdate.setResult(result);
                operationPoolUpdate.setImage_name(image_name);
                operationPoolUpdate.setLastruntime(df.format(new Date()));
                operationPoolUpdate.setId(Integer.parseInt(id[k]));
                operationPoolMapper.update(operationPoolUpdate);
            }
        }
    }
}
