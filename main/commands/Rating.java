package main.commands;

import fileio.UserInputData;

import java.util.List;

public class Rating {

    public UserInputData getUser(final List<UserInputData> users, final String username) {
        for (UserInputData iter : users) {
            if(iter.getUsername().equals(username)) {
                return iter;
            }
        }
        return null;
    }

    public String message_Rating(final List<UserInputData> users, final String username, final String movie_name) {
        UserInputData user = getUser(users, username);

    }


}
