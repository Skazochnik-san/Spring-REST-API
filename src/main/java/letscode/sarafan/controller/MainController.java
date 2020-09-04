package letscode.sarafan.controller;

import letscode.sarafan.domain.Messages;
import letscode.sarafan.domain.User;
import letscode.sarafan.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;


@Controller
public class MainController {

    @Autowired
    private MessageRepo messageRepo;

    @GetMapping("/")
    public String message(){
        return "messages";
    }

    @GetMapping("/main")
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model){
        Iterable<Messages> messages;

        if(filter != null && !filter.isEmpty()){
            messages = messageRepo.findByTag(filter);
        } else {
            messages = messageRepo.findAll();
        }

        model.addAttribute("messagesList", messages);

        return "main";
    }

    @PostMapping("/main")
    public String add (
            @AuthenticationPrincipal User user,
            @RequestParam String text,
            @RequestParam String tag, Model model) {
        Messages message = new Messages(text, tag, user);

        messageRepo.save(message);

        Iterable<Messages> messages = messageRepo.findAll();

        model.addAttribute("messagesList", messages);

        return "main";
    }

}
