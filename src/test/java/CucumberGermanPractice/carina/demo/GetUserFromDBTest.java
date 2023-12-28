package CucumberGermanPractice.carina.demo;

import CucumberGermanPractice.carina.demo.gui.ConnectionFactory;
import CucumberGermanPractice.carina.demo.gui.desktop.HomePage;
import CucumberGermanPractice.carina.demo.gui.models.UserMapper;
import CucumberGermanPractice.carina.demo.gui.models.UserOrders;
import CucumberGermanPractice.carina.demo.gui.models.UserOrdersMapper;
import CucumberGermanPractice.carina.demo.gui.models.WebUsers;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.IAbstractTest;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.util.List;

public class GetUserFromDBTest implements IAbstractTest {
    HomePage homePage = new HomePage(getDriver());
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




        }
    }

    @Test
    public void getProductsTest() {
        try (SqlSession session = ConnectionFactory.getSqlSessionFactory().openSession(true)) {
            UserOrdersMapper orderMapper = session.getMapper(UserOrdersMapper.class);
            System.out.println("-----------------------------------");
            List<UserOrders> userOrdersList2 = orderMapper.findOrdersByUserId(1);
            for (UserOrders order : userOrdersList2){
                System.out.println("The product is: " + order.getProduct());
//                System.out.println("Its ID is: "+order.getId());
//                System.out.println("Its price is: "+order.getPrice());
//                System.out.println("---------------------");
            }
        }
    }

}
