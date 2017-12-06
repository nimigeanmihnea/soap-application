package service;

import dao.UserDAO;
import entity.User;
import org.hibernate.cfg.Configuration;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService()
public class Login {

    @WebMethod
    public User fingUserByUsername(String username){
        UserDAO userDAO = new UserDAO(new Configuration().configure().buildSessionFactory());

        User user = userDAO.findByUsername(username);

        return user;
    }

    @WebMethod
    public void add(User user){
        UserDAO userDAO = new UserDAO(new Configuration().configure().buildSessionFactory());

        userDAO.add(user);
    }

    public static void main(String[] argv) {
        Object implementor = new Login();
        String address = "http://localhost:9000/login";
        Endpoint.publish(address, implementor);
    }
}
