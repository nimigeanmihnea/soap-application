package service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

import dao.CityDAO;
import dao.PackageDAO;
import entity.City;
import entity.Package;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

@WebService()
public class Admin {

    private PackageDAO packageDAO = new PackageDAO(new Configuration().configure().buildSessionFactory());
    private CityDAO cityDAO = new CityDAO(new Configuration().configure().buildSessionFactory());

    @WebMethod
    public void add(Package aPackage){
        packageDAO.add(aPackage);
    }

    @WebMethod
    public void remove(Package aPackage){
        packageDAO.remove(aPackage);
    }

    @WebMethod
    public void update(Package aPackage){
        List<City> cities = new ArrayList<City>();

        cities.add(aPackage.getSenderCity());
        cities.add(aPackage.getDestinationCity());

        aPackage.setRoute(cities);

        packageDAO.update(aPackage);
    }

    @WebMethod
    public void status(Package aPackage, City city){
        List<City> cities = new ArrayList<City>();

        cities.add(aPackage.getSenderCity());
        cities.add(city);
        cities.add(aPackage.getDestinationCity());

        aPackage.setRoute(cities);

        packageDAO.update(aPackage);
    }

    @WebMethod
    public Package getPackage(String name){
        Package aPackage = packageDAO.findByName(name);
        aPackage.setRoute(null);
        return aPackage;
    }

    @WebMethod
    public City findCityByName(String name){
        return cityDAO.find(name);
    }

    public static void main(String[] argv) {
        Object implementor = new Admin();
        String address = "http://localhost:9010/admin";
        Endpoint.publish(address, implementor);
    }
}
