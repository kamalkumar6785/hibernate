package org.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "insurance")
public class Policy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private long insuranceNumber;
    private String insuranceType;
    private Double deposit;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private Person person;


    public long getInsuranceNumber() {
        return insuranceNumber;
    }

    public int getId() {
        return id;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setInsuranceNumber(long insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }
}
