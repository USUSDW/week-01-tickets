package com.github.ususdw.tickets;

import java.util.Random;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller("/")
public class TicketController {
    private static final Random random = new Random();

    private TicketQueue queue = new TicketQueue();
    private int nextId = 0;

    @GetMapping
    public String home(Model model) {
        var ticket = queue.peekNext();
        if(ticket != null) {
            model.addAttribute("ticket", ticket);
        }
        return "home";
    }

    @GetMapping("addTicket")
    public String addTicketForm(Model model) {
        model.addAttribute("ticketData", new TicketData());
        return "addTicket";
    }

    @PostMapping("addTicket")
    public String addTicket(@Valid @ModelAttribute TicketData ticket, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        var id = ++nextId;

        var newTicket = new Ticket(id, ticket.priority, ticket.subject);
        model.addAttribute("id", newTicket);
        model.addAttribute("priority", newTicket.priority);
        model.addAttribute("subject", newTicket.subject);
        model.addAttribute("createdOn", newTicket.createdOn);

        queue.addToQueue(newTicket);
        return "redirect:/";
    }

    @GetMapping("populate")
    public String populate() {
        for(int i = 0; i < 10; i++) {
            var priority = Priority.fromInt(random.nextInt(21));
            var ticket = new Ticket(++nextId, priority, "An issue description would go here.");
            queue.addToQueue(ticket);
        }
        return "redirect:/";
    }

    @GetMapping("nextTicket")
    public String nextTicket() {
        queue.getNext();
        return "redirect:/";
    }
}
