package application.controller;

import application.stub.Login;
import application.stub.LoginService;
import application.stub.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RegisterController {

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String show(){
        return "/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(HttpServletRequest request){

        String name = request.getParameter("name");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = "ROLE_USER";

        User user = new User();

        user.setName(name);
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(role);

        Login service = new LoginService().getLoginPort();
        service.add(user);
        return "redirect:/login";
    }
}
