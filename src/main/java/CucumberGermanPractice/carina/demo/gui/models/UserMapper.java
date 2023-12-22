package CucumberGermanPractice.carina.demo.gui.models;

public interface UserMapper {
    WebUsers findById(long id);
    WebUsers findByUserName(String username);
}
