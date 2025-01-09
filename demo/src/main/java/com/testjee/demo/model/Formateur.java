package com.testjee.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="formateur")
public class Formateur {
    public Formateur(){}

    public Formateur(String username, String mdp, String nom, String prenom) {
        super();
        this.username = username;
        this.mdp = mdp;
        this.nom = nom;
        this.prenom = prenom;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="idformateur", nullable=false)
    private Integer id;

    @Column(name="username", length=255, nullable=true)
    private String username;

    @Column(name="mdp", length=255, nullable=true)
    private String mdp;

    @Column(name="nom", length=255, nullable=true)
    private String nom;

    @Column(name="prenom", length=255, nullable=true)
    private String prenom;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getMdp() {
        return mdp;
    }
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
}
