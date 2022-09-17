package cybersoft.javabackend.java18.gira;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class WelcomeResource {
    @GetMapping("/welcome")
    public String welcome(HttpServletRequest req) {
        //get ip address from request
        String ip = req.getRemoteAddr();
        return String.format("Welcome %s to Gira Application", ip);
    }
}
