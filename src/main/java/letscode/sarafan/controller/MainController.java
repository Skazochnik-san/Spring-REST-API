package letscode.sarafan.controller;

import letscode.sarafan.domain.Messages;
import letscode.sarafan.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ModelAndView message(Map<String, Object> model){
        return new ModelAndView("messages", model);
    }

    @GetMapping("/main")
    public ModelAndView main(Map<String, Object> model){
        Iterable<Messages> messages = messageRepo.findAll();

        model.put("messagesList", messages);

        return new ModelAndView("main", model);
    }

    @PostMapping("/main")
    public ModelAndView add (@RequestParam String text,@RequestParam String tag, Map<String, Object> model) {
        Messages message = new Messages(text, tag);

        messageRepo.save(message);

        Iterable<Messages> messages = messageRepo.findAll();

        model.put("messagesList", messages);

        return new ModelAndView("main", model);
    }

    @PostMapping("/filter")
    public ModelAndView filter (@RequestParam String filter, Map<String, Object> model) {
        Iterable<Messages> messages;
        if(filter != null && !filter.isEmpty()){
            messages = messageRepo.findByTag(filter);
        } else {
            messages = messageRepo.findAll();
        }

        model.put("messagesList", messages);

        return new ModelAndView("main", model);
    }
}