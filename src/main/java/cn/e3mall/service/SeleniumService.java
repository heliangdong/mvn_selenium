package cn.e3mall.service;

import java.awt.*;
import java.io.IOException;

public interface SeleniumService {

    void run(String ids) throws InterruptedException, AWTException, IOException;
}
