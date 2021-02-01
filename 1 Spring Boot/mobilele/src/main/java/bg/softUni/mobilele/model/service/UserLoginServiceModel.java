package bg.softUni.mobilele.model.service;

public class UserLoginServiceModel {

    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public UserLoginServiceModel setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserLoginServiceModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
