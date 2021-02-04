package bg.softUni.mobilele.service;

public interface UserService {

    // return -> true if the user is authenticated  successfully.
    boolean authenticate(String userName, String password);

    void loginUser(String userName);

    void logoutCurrentUser();


}
