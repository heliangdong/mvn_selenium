package cn.e3mall.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetImageName {
    public String getImageName(){
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return  df.format(new Date());
    }
}
