package fr.clevermind.web;

import fr.clevermind.domain.Bank;
import fr.clevermind.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class BankRestController {

    private BankRepository bankRepository;

    @Autowired
    public BankRestController(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

   /* @RequestMapping("/banks")
    public Collection<Bank> banks(){
        return bankRepository.findAll();
    }*/

}
