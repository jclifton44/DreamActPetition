package com.example.dreamACT;
import java.util.Date;
 
import com.google.appengine.api.users.User;


public class Greeting implements Comparable<Greeting> {

    User user;
    String content;
    Date date;
    private Greeting() {}
    public Greeting(User user, String content) {
        this.user = user;
        this.content = content;
        date = new Date();
    }
    public User getUser() {
        return user;
    }
    public String getContent() {
        return content;
    }
    @Override
    public int compareTo(Greeting other) {
        if (date.after(other.date)) {
            return 1;
        } else if (date.before(other.date)) {
            return -1;
        }
        return 0;
    }
}