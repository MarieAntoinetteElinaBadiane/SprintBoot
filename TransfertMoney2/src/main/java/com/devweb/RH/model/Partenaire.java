package com.devweb.RH.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(exclude = "users")
@Table(name = "partenaire")
public class Partenaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    @Column(length = 30)
    private String nomentreprise;
    @NotBlank
    @Column(length = 50)
    private String ninea;
    @NotBlank
    @Column(length = 50)
    private String adresse;
    @NotBlank
    @Column(length = 50)
    private String telephone;

    @NotBlank
    @Size(min=3, max = 50)
    private String profile;
    
    @NotBlank
    @Column(length = 50)
    private String raisonsocial;
    @OneToMany(mappedBy ="partenaire")
    @JsonIgnoreProperties("partenaire")
    private List<User> users;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getNomentreprise() { return nomentreprise; }

    public void setNomentreprise(String nomentreprise) { this.nomentreprise = nomentreprise; }

    public String getNinea() { return ninea; }

    public void setNinea(String ninea) { this.ninea = ninea; }

    public String getAdresse() { return adresse; }

    public String getProfile() { return profile; }

    public void setProfile(String profile) { this.profile = profile; }

    public void setAdresse(String adresse) { this.adresse = adresse; }

    public String getTelephone() { return telephone; }

    public void setTelephone(String telephone) { this.telephone = telephone; }

    public String getRaisonsocial() { return raisonsocial; }

    public void setRaisonsocial(String raisonsocial) { this.raisonsocial = raisonsocial; }
}