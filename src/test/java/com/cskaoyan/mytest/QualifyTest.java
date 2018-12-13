package com.cskaoyan.mytest;


import com.cskaoyan.domain.qualifyMonitor.UnqualifyApply;
import com.cskaoyan.service.qualifyMonitor.UnqualifyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class QualifyTest {

    @Autowired
    UnqualifyService unqualifyService;
    @Test
    public void test1(){
        UnqualifyApply unqualifyApply = new UnqualifyApply();
        //unqualifyApply.setUnqualifyApplyId("1212");
        unqualifyApply.setNote("修改后的测试");
        try {
            unqualifyService.edit(unqualifyApply);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
