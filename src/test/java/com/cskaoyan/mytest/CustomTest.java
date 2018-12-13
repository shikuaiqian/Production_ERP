package com.cskaoyan.mytest;

import com.cskaoyan.domain.designScheduleDomain.Custom;
import com.cskaoyan.dao.designSchedule.CustomMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class CustomTest {
    @Autowired
    CustomMapper customMapper;
    @Test
    public void findAllTest() {
        List<Custom> findall = customMapper.findall();
        System.out.println(findall);
    }
}
