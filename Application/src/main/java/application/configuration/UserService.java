package application.configuration;

import application.entity.SpringUser;
import application.stub.Login;
import application.stub.LoginService;
import application.stub.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            Login service = new LoginService().getLoginPort();
            User user = service.fingUserByUsername(username);
            SpringUser springUser = new SpringUser(user.getUsername(), user.getPassword(), user.getRole());
            springUser.isEnabled();
            return springUser;
        }catch (UsernameNotFoundException ex){
            ex.printStackTrace();
            return null;
        }
    }
}
