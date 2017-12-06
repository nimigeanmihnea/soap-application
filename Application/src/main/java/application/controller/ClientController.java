package application.controller;

import application.stub.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

@Controller
public class ClientController {

    private Client client;
    private Login login;

    @RequestMapping(value = "/user/view", method = RequestMethod.GET)
    public String view(Model model){
        client = new ClientService().getClientPort();
        login = new LoginService().getLoginPort();

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();

        User user = login.fingUserByUsername(name);

        String packages = client.list(user);

        model.addAttribute("p", packages);

        return "/user/view";
    }

    @RequestMapping(value = "/user/search", method = RequestMethod.GET)
    public String showSearch(@PathParam("search") String search, Model model){
        if(search != null) {
            client = new ClientService().getClientPort();

            String aPackage = client.search(search);

            model.addAttribute("p", aPackage);

            return "/user/search";
        }
        return "/user/search";
    }

    @RequestMapping(value = "/user/search", method = RequestMethod.POST)
    public String search(HttpServletRequest request){
        String search = request.getParameter("search");
        return "redirect:/user/search?search=" + search;
    }

    @RequestMapping(value = "/user/status", method = RequestMethod.GET)
    public String showStatus(@PathParam("status") String status, Model model){
        if(status != null) {
            client = new ClientService().getClientPort();

            String aPackage = client.status(status);

            model.addAttribute("p", aPackage);

            return "/user/status";
        }
        return "/user/status";
    }

    @RequestMapping(value = "/user/status", method = RequestMethod.POST)
    public String status(HttpServletRequest request){
        String search = request.getParameter("search");
        return "redirect:/user/status?status=" + search;
    }
}
