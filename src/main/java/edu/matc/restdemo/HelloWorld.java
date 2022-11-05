package edu.matc.restdemo;

import edu.matc.persistence.UserDao;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import java.util.List;

@Path("/hello")
public class HelloWorld {

    UserDao userDao = new UserDao();

    // A list of objects to JSON
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> helloList() {
        List<User> userList = userDao.getAllUsers();
        return userList;
    }

    // Object to JSON
    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public User hello(@PathParam("id") int id) {
        User foundUser = userDao.getById(id);
        return foundUser;
    }
}


