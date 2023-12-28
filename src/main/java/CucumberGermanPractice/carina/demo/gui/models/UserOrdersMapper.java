package CucumberGermanPractice.carina.demo.gui.models;

import java.util.List;

public interface UserOrdersMapper {
   UserOrders findById(long id);
   List<UserOrders> findOrdersByUserId(long id);
   List<WebUsers> findUserByOrderId(long id);

}
