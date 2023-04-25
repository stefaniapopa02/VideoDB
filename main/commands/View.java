package main.commands;

import fileio.UserInputData;

import java.util.List;
import java.util.Map;

public class View {

    public UserInputData getUser(final List<UserInputData> users, final String username) {
        for (UserInputData iter : users) {
            if(iter.getUsername().equals(username)) {
                return iter;
            }
        }
        return null;
    }


    public String message_View(final List<UserInputData> users, final String username, final String movie_name) {
        UserInputData user = getUser(users, username);
        int viewsNumber = 1;
        for (Map.Entry<String, Integer> entry : user.getHistory().entrySet()) {
            if (entry.getKey().equals(movie_name)) {
                viewsNumber = viewsNumber + entry.getValue();
                break;
            }
        }
        user.getHistory().put(movie_name, viewsNumber);
        return "success -> " + movie_name + " was viewed with total views of " + viewsNumber;
    }
}
