import com.cskaoyan.service.qualifyMonitor.UnqualifyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

/**
 * Created by LZH on 2018/12/5
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class test {

    @Autowired
    UnqualifyService unqualifyService;
    @Test
    public void test1(){
        Map<Object, Object> page = unqualifyService.findPage(1, 10);
        System.out.println(page);
    }

}
