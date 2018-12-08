import com.cskaoyan.dao.deviceManagement.Device_faultMapper;
import com.cskaoyan.domain.deviceManagement.vo.Device_faultVo;
import com.cskaoyan.service.deviceManagement.interfaces.DeviceFaultService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * Created by LZH on 2018/12/5
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class test {

    @Test
    public void test0(){
        int i=0;
        System.out.println(i);
    }
}
