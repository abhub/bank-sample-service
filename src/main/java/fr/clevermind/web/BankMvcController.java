package fr.clevermind.web;

import fr.clevermind.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BankMvcController {

    private BankRepository bankRepository;

    @Autowired
    public BankMvcController(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    @RequestMapping("/banks.htm")
    public String banks(Model model){
        model.addAttribute("banks", bankRepository.findAll());
        return "banks";
    }
}
