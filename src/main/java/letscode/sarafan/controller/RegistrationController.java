package letscode.sarafan.controller;

import letscode.sarafan.domain.Role;
import letscode.sarafan.domain.User;
import letscode.sarafan.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/registration")
    public ModelAndView registration(Map<String, Object> model) {
        return new ModelAndView("registration", model);
    }

    @PostMapping("/registration")
    public ModelAndView addUser(User user, Map<String, Object> model) {
        User userFromDb = userRepo.findByUsername(user.getUsername());

        if (userFromDb != null) {
            model.put("message", "User exists!");
            return new ModelAndView("registration", model);
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);
        Iterable<User> messages = userRepo.findAll();

        return new ModelAndView("redirect:/login", model);
    }
}