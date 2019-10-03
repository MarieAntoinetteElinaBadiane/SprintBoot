package com.devweb.RH.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Data
@EqualsAndHashCode(exclude = "user")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 50)
    private String nomcompletenvoi;
    @Column(length = 50)
    private String nomcompletretrait;
    @Column(length = 15)
    private String telephoneenvoi;
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private java.util.Date dateenvoi;
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private java.util.Date dateretrait;
    private int montantenvoi;
    private int codeenvoi;
    private int commissionetat;
    private int commissionenvoi;
    private int commissionretrait;
    private int commissionadmin;
    private int cnienvoi;
    private int cniretrait;
    private String telephoneretrait;
    private String statut;
    @JoinColumn(name = "user_id",referencedColumnName ="id")
    @ManyToOne(optional = false)

    @JsonIgnoreProperties("users")
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomcompletenvoi() {
        return nomcompletenvoi;
    }

    public void setNomcompletenvoi(String nomcompletenvoi) {
        this.nomcompletenvoi = nomcompletenvoi;
    }

    public String getNomcompletretrait() {
        return nomcompletretrait;
    }

    public void setNomcompletretrait(String nomcompletretrait) {
        this.nomcompletretrait = nomcompletretrait;
    }

    public String getTelephoneenvoi() {
        return telephoneenvoi;
    }

    public void setTelephoneenvoi(String telephoneenvoi) {
        this.telephoneenvoi = telephoneenvoi;
    }

    public java.util.Date getDateenvoi() {
        return dateenvoi;
    }

    public void setDateenvoi(java.util.Date dateenvoi) {
        this.dateenvoi = dateenvoi;
    }

    public java.util.Date getDateretrait() {
        return dateretrait;
    }

    public void setDateretrait(Date dateretrait) {
        this.dateretrait = dateretrait;
    }

    public int getMontantenvoi() {
        return montantenvoi;
    }

    public void setMontantenvoi(int montantenvoi) {
        this.montantenvoi = montantenvoi;
    }

    public int getCodeenvoi() {
        return codeenvoi;
    }

    public void setCodeenvoi(int codeenvoi) {
        this.codeenvoi = codeenvoi;
    }

    public int getCommissionetat() {
        return commissionetat;
    }

    public void setCommissionetat(int commissionetat) {
        this.commissionetat = commissionetat;
    }

    public int getCommissionenvoi() {
        return commissionenvoi;
    }

    public void setCommissionenvoi(int commissionenvoi) {
        this.commissionenvoi = commissionenvoi;
    }

    public int getCommissionretrait() {
        return commissionretrait;
    }

    public void setCommissionretrait(int commissionretrait) {
        this.commissionretrait = commissionretrait;
    }

    public int getCommissionadmin() {
        return commissionadmin;
    }

    public void setCommissionadmin(int commissionadmin) {
        this.commissionadmin = commissionadmin;
    }

    public int getCnienvoi() {
        return cnienvoi;
    }

    public void setCnienvoi(int cnienvoi) {
        this.cnienvoi = cnienvoi;
    }

    public int getCniretrait() {
        return cniretrait;
    }

    public void setCniretrait(int cniretrait) {
        this.cniretrait = cniretrait;
    }

    public String getTelephoneretrait() {
        return telephoneretrait;
    }

    public void setTelephoneretrait(String telephoneretrait) {
        this.telephoneretrait = telephoneretrait;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }
}