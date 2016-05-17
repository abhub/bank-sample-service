package fr.clevermind.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Bank {

    @Id
    @GeneratedValue
    private Long id;

    private String bankName;

    private String location;

    private Integer nbClient;

    public Bank(String bankName, String location, Integer nbClient) {
        this.bankName = bankName;
        this.location = location;
        this.nbClient = nbClient;
    }

    public Bank() {
    }

    public Long getId() {
        return id;
    }

    public String getBankName() {
        return bankName;
    }

    public String getLocation() {
        return location;
    }

    public Integer getNbClient() {
        return nbClient;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "id=" + id +
                ", bankName='" + bankName + '\'' +
                ", location='" + location + '\'' +
                ", nbClient=" + nbClient +
                '}';
    }
}
