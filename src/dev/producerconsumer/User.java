package dev.producerconsumer;

public class User {

    private int userId;
    private String userGuid;
    private String userName;

    public User(int userid, String userGuid, String userName) {
        this.userId = userid;
        this.userGuid = userGuid;
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }
    public String getUserGuid() {
        return userGuid;
    }
    public String getUserName() {
        return userName;
    }

}
