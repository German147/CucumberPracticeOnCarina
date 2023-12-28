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
            System.out.println("Username is: " + user.getUsername());
            List<UserOrders> userOrdersList = user.getOrders();
            for (UserOrders o : userOrdersList)
                System.out.println("Printing the product from the list" + o.getProduct());
            System.out.println("------------Only using order session here--------");
            UserOrdersMapper orderMapper = session.getMapper(UserOrdersMapper.class);
            UserOrders ordersList = orderMapper.findById(2);
            System.out.print("Order product: " + ordersList.getProduct());

            List<UserOrders> userOrdersList2 = orderMapper.findOrdersByUserId(1);
            for (UserOrders order : userOrdersList2)
                System.out.println("The product is: " + order.getProduct());

        }
    }

    @Test
    public void getOrdersTest() {
        try (SqlSession session = ConnectionFactory.getSqlSessionFactory().openSession(true)) {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            List<UserOrders> userOrders = userMapper.findOrdersByUserId(2);
            for (UserOrders o : userOrders)
                System.out.println("Product: "+o.getProduct());
            int size = userOrders.size();
            System.out.println(size);


//            UserOrdersMapper orderMappers = session.getMapper(UserOrdersMapper.class);
//            System.out.println(order.getProduct());
//            float userId = order.getUserId();
//            System.out.println(userId);
//
//            List<WebUsers> webUsersList = order.getWebUsers();
//            System.out.println("The webUserList size is " + webUsersList.size());
        }
    }
}
