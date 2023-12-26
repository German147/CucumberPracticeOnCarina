package CucumberGermanPractice.carina.demo;

import CucumberGermanPractice.carina.demo.gui.ConnectionFactory;
import CucumberGermanPractice.carina.demo.gui.models.UserMapper;
import CucumberGermanPractice.carina.demo.gui.models.UserOrders;
import CucumberGermanPractice.carina.demo.gui.models.UserOrdersMapper;
import CucumberGermanPractice.carina.demo.gui.models.WebUsers;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.util.List;

public class GetUserFromDBTest {

    @Test
    @TestLabel(name = "feature", value = "database")
    public void getUserTest() {
        try (SqlSession session = ConnectionFactory.getSqlSessionFactory().openSession(true)) {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            WebUsers user = userMapper.findById(2);
            System.out.println("UserName is: " + user.getUsername() + " and its password is: " + user.getPassword());

        }
    }

    @Test
    public void getOrdersTest() {
        try (SqlSession session = ConnectionFactory.getSqlSessionFactory().openSession(true)) {
            UserOrdersMapper orderMappers = session.getMapper(UserOrdersMapper.class);
            UserOrders order = orderMappers.findById(1);
            System.out.println(order.getProduct());
            float userId = order.getUserId();
            System.out.println(userId);
        }
    }
}
