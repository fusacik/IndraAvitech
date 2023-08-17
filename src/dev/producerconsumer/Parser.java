package dev.producerconsumer;

public class Parser {

    public static User parseCommand(String command) {
        User user = null;
        int firstIndex = command.indexOf('(')+1;
        int lastIndex = command.lastIndexOf(')');
        String commandString = command.substring(firstIndex,lastIndex);
        String[] strArray = commandString.split(",");

        int userId = Integer.valueOf(strArray[0]);
        String userGuid = strArray[1].replace("'", "").trim();
        String userName = strArray[2].replace("'", "").trim();

        user = new User(userId, userGuid, userName);
        return user;
    }


}

