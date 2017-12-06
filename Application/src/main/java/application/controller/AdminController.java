package application.controller;

import application.stub.*;
import application.stub.Package;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AdminController {

    private Admin service;
    private Login login;

    @RequestMapping(value = "/admin/remove", method = RequestMethod.GET)
    public String showRemovePackage(){
        return "/admin/remove";
    }

    @RequestMapping(value = "/admin/remove", method = RequestMethod.POST)
    public String remove(HttpServletRequest request){
        String name = request.getParameter("name");
        service = new AdminService().getAdminPort();
        Package aPackage =  service.getPackage(name);

        if(aPackage != null) {
            service.remove(aPackage);
            return "redirect:/home";
        }else
            return "redirect:/error_page";
    }

    @RequestMapping(value = "/admin/add", method = RequestMethod.GET)
    public String showAddPackage(){
        return "/admin/add";
    }

    @RequestMapping(value = "/admin/add", method = RequestMethod.POST)
    public String add(HttpServletRequest request){
        Package aPackage = new Package();
        login = new LoginService().getLoginPort();
        service = new AdminService().getAdminPort();

        aPackage.setSender(login.fingUserByUsername(request.getParameter("sender")));
        aPackage.setDestination(login.fingUserByUsername(request.getParameter("receiver")));
        aPackage.setName(request.getParameter("name"));
        aPackage.setDescription(request.getParameter("description"));
        aPackage.setSenderCity(service.findCityByName(request.getParameter("senderCity")));
        aPackage.setDestinationCity(service.findCityByName(request.getParameter("destinationCity")));

        service.add(aPackage);

        return "redirect:/home";
    }

    @RequestMapping(value = "/admin/tracking", method = RequestMethod.GET)
    public String showTracking(){
        return "/admin/tracking";
    }

    @RequestMapping(value = "/admin/tracking", method = RequestMethod.POST)
    public String track(HttpServletRequest request){
        String name = request.getParameter("name");

        service = new AdminService().getAdminPort();
        Package aPackage =  service.getPackage(name);

        aPackage.setTracking(true);

        service.update(aPackage);

        return "redirect:/home";
    }

    @RequestMapping(value = "/admin/status", method = RequestMethod.GET)
    public String showStatus(){
        return "/admin/status";
    }

    @RequestMapping(value = "/admin/status", method = RequestMethod.POST)
    public String update(HttpServletRequest request){
        String name = request.getParameter("name");
        String cityName = request.getParameter("city");

        service = new AdminService().getAdminPort();

        City city = service.findCityByName(cityName);
        Package aPackage = service.getPackage(name);

        service.status(aPackage, city);

        return "redirect:/home";

    }
}
