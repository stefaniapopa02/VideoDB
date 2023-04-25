package main.commands;

import fileio.UserInputData;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Favorite {

    public UserInputData getUser(final List<UserInputData> users, final String username) {
        for (UserInputData iter : users) {
            if(iter.getUsername().equals(username)) {
                return iter;
            }
        }
        return null;
    }

    public boolean AlreadyFav(final ArrayList<String> fav_movies, final String movie_name) {
        for (String iter : fav_movies) {
            if (iter.equals(movie_name)) {
                return true;
            }
        }
        return false;
    }

    public boolean InHistory(final Map<String, Integer> history, final String movie_name) {
        for(Map.Entry<String, Integer> iter : history.entrySet()) {
            if(iter.getKey().equals((movie_name))) {
                return true;
            }
        }
        return false;
    }

    public String message_Favorite(final List<UserInputData> users, final String username, final String movie_name) {
        UserInputData user = getUser(users, username);
        ArrayList<String> fav_movies = user.getFavoriteMovies();
        Map<String, Integer> history = user.getHistory();
        String message;

        if (AlreadyFav(fav_movies, movie_name) == true) {
            message = "error -> " + movie_name + " is already in favourite list";
            return message;
        }else if(InHistory(history, movie_name) == true) {
            fav_movies.add(movie_name);
            message = "success -> " + movie_name + " was added as favourite";
            return message;
        }else {
            message = "error -> " + movie_name + " is not seen";
            return message;
        }
    }
}
