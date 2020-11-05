import com.java.dao.IUserDao;
import com.java.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: ssm_system
 * @description:
 * @author: Gakki
 * @create: 2020-11-03 07:09
 **/
public class Test {
    @Autowired
    IUserDao userDao;
    @org.junit.Test
    public void test(){
        try {
            UserInfo gakki = userDao.findByUsername("gakki");
            System.out.println(gakki);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
