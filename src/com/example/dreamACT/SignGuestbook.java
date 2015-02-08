package com.example.dreamACT;
 
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
 
import java.io.IOException;
import java.util.Date;
 
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class SignGuestbook extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
                throws IOException {

 
        // We have one entity group per Guestbook with all Greetings residing
        // in the same entity group as the Guestbook to which they belong.
        // This lets us run a transactional ancestor query to retrieve all
        // Greetings for a given Guestbook.  However, the write rate to each
        // Guestbook should be limited to ~1/second.
    	
        Key guestbookKey = KeyFactory.createKey("Guestbook", "default");
        String user = req.getParameter("user");
        String content = req.getParameter("content");
        

        Date date = new Date();
        Entity greeting = new Entity("Greeting", guestbookKey);
        greeting.setProperty("user", user);
        greeting.setProperty("date", date);
        greeting.setProperty("content", content);
 
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        datastore.put(greeting);
 
        resp.sendRedirect("/guestbook.jsp?guestbookName=" + "default");
    }
}