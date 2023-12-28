package CucumberGermanPractice.carina.demo.gui.models;

import java.util.List;

public interface UserMapper {
    WebUsers findById(long id);

    List<UserOrders> findOrdersByUserId(long id);

    WebUsers findByUserName(String username);
}
