package service;

import dao.PackageDAO;
import entity.Package;
import entity.User;
import org.hibernate.cfg.Configuration;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.util.Arrays;
import java.util.List;

@WebService()
public class Client {

    private PackageDAO packageDAO = new PackageDAO(new Configuration().configure().buildSessionFactory());

    @WebMethod
    public String list(User user){
        List<Package> packages = packageDAO.findByUser(user);
        return Arrays.toString(packages.toArray());
    }

    @WebMethod
    public String search(String name){
        Package aPackage = packageDAO.findByName(name);
        aPackage.setRoute(null);
        return aPackage.toString();
    }

    @WebMethod
    public String status(String name){
        Package aPackage = packageDAO.findByName(name);
        return "Package status: "+ aPackage.isTracking();
    }

    public static void main(String[] argv) {
        Object implementor = new Client();
        String address = "http://localhost:9020/client";
        Endpoint.publish(address, implementor);
    }
}
