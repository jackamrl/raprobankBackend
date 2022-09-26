package com.mycompany.raprobank.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "mouvement")
//Un mouvement est soit un extrait de grand livre ou un extrait de releve bancaire

public class Mouvement extends AbstractEntity implements EntityItem<Integer>{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_mouvement")
    private Integer idMouvement;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "mois")
    private String mois;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "annee")
    private String annee;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "type")
    private String type;
    @Basic(optional = true)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "solde_initial")
    private Long soldeInitial;
    @JsonBackReference(value = "id_commptebancaire")
    @JoinColumn(name = "id_commptebancaire", referencedColumnName = "id_commptebancaire")
    //@JsonBackReference
    //@JsonIgnore
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private CompteBancaire compteBancaire;
    @JsonManagedReference(value = "mouvement")
    @OneToMany(fetch=FetchType.LAZY , cascade = CascadeType.ALL, mappedBy = "mouvement")
    //@JsonManagedReference
    private List<Operation> operationList;

    public Mouvement() {
    }

    public Mouvement(Integer idMouvement, String mois, String annee, String type, Long soldeInitial, CompteBancaire compteBancaire, List<Operation> operationList) {
        this.idMouvement = idMouvement;
        this.mois = mois;
        this.annee = annee;
        this.type = type;
        this.soldeInitial = soldeInitial;
        this.compteBancaire = compteBancaire;
        this.operationList = operationList;
    }

    public Integer getIdMouvement() {
        return idMouvement;
    }



    public String getType() {
        return type;
    }

    public Long getSoldeInitial() {
        return soldeInitial;
    }

    public CompteBancaire getCompteBancaire() {
        return compteBancaire;
    }

    public List<Operation> getOperationList() {
        return operationList;
    }

    public void setIdMouvement(Integer idMouvement) {
        this.idMouvement = idMouvement;
    }

    public String getMois() {
        return mois;
    }

    public void setMois(String mois) {
        this.mois = mois;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSoldeInitial(Long soldeInitial) {
        this.soldeInitial = soldeInitial;
    }

    public void setCompteBancaire(CompteBancaire compteBancaire) {
        this.compteBancaire = compteBancaire;
    }

    public void setOperationList(List<Operation> operationList) {
        this.operationList = operationList;
    }

    @Override
    public String toString() {
        return "Mouvement{" +
                "idMouvement=" + idMouvement +

                ", type='" + type + '\'' +
                ", soldeInitial=" + soldeInitial +
                ", compteBancaire=" + compteBancaire +
                ", operationList=" + operationList +
                '}';
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public Integer getId() {
        return idMouvement;
    }
}
