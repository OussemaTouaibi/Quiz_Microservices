package com.esprit.quiz.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "model_user", uniqueConstraints = {@UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email")})
public class User {
    private static final long serialVersionUID = 6711457437559348053L;
    @Id
    @GeneratedValue
    private int id;

    @Size(max = 30)
    private String name;

    @Size(max = 30)
    private String username;

    @NotBlank
    @Size(max = 120)
    private String password;

    @Size(max = 50)
    private String email;



    @OneToMany(mappedBy = "auteur")
    @JsonIgnore
    private Set<Commentaire> commentaire;

    public User(String name, String username, String email) {
        super();
        this.name = name;
        this.username = username;
        this.email = email;
    }

    public User(String companyKey, String name, String email, String password, String username, String numTel) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
    
    }

    public User(String name, String username, String email, int nbReclamation) {
        super();
        this.name = name;
        this.username = username;
        this.email = email;
    }

    public User() {
        // TODO Auto-generated constructor stub
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getusername() {
        return username;
    }

    public void setusername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Commentaire> getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(Set<Commentaire> commentaire) {
        this.commentaire = commentaire;
    }


}
