package org.example.entity;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "firstName")
    private String fname;
    @Column(name = "lastName")
    private String lname;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<Policy> policyDetail;

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Policy> getPolicyDetail() {
        return policyDetail;
    }

    public void setPolicyDetail(List<Policy> policyDetail) {
        this.policyDetail = policyDetail;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("Person {" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", email='" + email + '\'' +
                ", Insurance Number= ");

        for(Policy acc : policyDetail){
            res.append(acc.getInsuranceNumber());
        }

        res.append(" }");

        return res.toString();
    }
}

