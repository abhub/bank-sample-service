package fr.clevermind.repository;


import fr.clevermind.domain.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

@RepositoryRestResource
public interface BankRepository extends JpaRepository<Bank, Long>{

    //select * from Bank where bank.bankName = : bn
    //@Query(...)
    Collection<Bank> findByBankName(@Param("bn") String bn);
}
