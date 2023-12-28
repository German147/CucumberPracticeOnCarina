package CucumberGermanPractice.carina.demo.gui.models;

import java.util.ArrayList;
import java.util.List;

public class WebUsers {
    private Long id;
    private String username;
    private String password;
    private List<UserOrders> orders = new ArrayList<>();

    public WebUsers() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<UserOrders> getOrders() {
        return orders;
    }

    public void setOrders(List<UserOrders> orders) {
        this.orders = orders;
    }
}
