package com.mycompany.raprobank.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

/**
 *
 * @author jacquesboyodi
 */

@Entity
@Table(name="compte_bancaire")
//To suppress serializing properties with null values
//@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
//Ignoring new fields on JSON objects
//@JsonIgnoreProperties(ignoreUnknown = true)
public class CompteBancaire extends AbstractEntity implements EntityItem<Integer> {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name="id_commptebancaire")
    private Integer idComptebancaire;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "libelle_compte")
    private String libelleCompte;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "num_compte")
    private String numCompte;
    //@JsonIgnore
    //@JsonBackReference(value = "id_banque")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_banque", referencedColumnName = "id_banque")
    @JsonBackReference(value = "id_banque")
    private Banque banque;
    //@JsonIgnore
    @JsonBackReference(value = "id_societe")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_societe", referencedColumnName = "id_societe")
    //@JsonBackReference
    private Societe societe;
    @JsonManagedReference(value = "compteBancaire")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compteBancaire",fetch=FetchType.LAZY)
    //@JsonManagedReference
    private List<Mouvement> mouvementList;

    public CompteBancaire() {
    }

    public CompteBancaire(Integer idComptebancaire, String libelleCompte, String numCompte) {
        this.idComptebancaire = idComptebancaire;
        this.libelleCompte = libelleCompte;
        this.numCompte = numCompte;
    }

    public CompteBancaire(Integer idComptebancaire, String libelleCompte, String numCompte, Banque banque, Societe societe, List<Mouvement> mouvementList) {
        this.idComptebancaire = idComptebancaire;
        this.libelleCompte = libelleCompte;
        this.numCompte = numCompte;
        this.banque = banque;
        this.societe = societe;
        this.mouvementList = mouvementList;
    }


    public Integer getIdComptebancaire() {
        return idComptebancaire;
    }

    public String getLibelleCompte() {
        return libelleCompte;
    }

    public String getNumCompte() {
        return numCompte;
    }

//    @JsonProperty("banque")
    public Banque getBanque() {
        return banque;
    }

    public Societe getSociete() {
        return societe;
    }

    public Integer getIdBanque() {
        return banque.getIdBanque();
    }
    public Integer getIdSociete() {
        return societe.getIdSociete();
    }

    public List<Mouvement> getMouvementList() {
        return mouvementList;
    }

    public void setIdComptebancaire(Integer idComptebancaire) {
        this.idComptebancaire = idComptebancaire;
    }

    public void setLibelleCompte(String libelleCompte) {
        this.libelleCompte = libelleCompte;
    }

    public void setNumCompte(String numCompte) {
        this.numCompte = numCompte;
    }

    public void setBanque(Banque banque) {
        this.banque = banque;
    }


    public void setSociete(Societe societe) {
        this.societe = societe;
    }

    public void setMouvementList(List<Mouvement> mouvementList) {
        this.mouvementList = mouvementList;
    }

    @Override
    public String toString() {
        return "CompteBancaire{" +
                "idComptebancaire=" + idComptebancaire +
                ", libelleCompte='" + libelleCompte + '\'' +
                ", numCompte='" + numCompte + '\'' +
                ", banque=" + banque +
                ", societe=" + societe +
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
        return idComptebancaire;
    }
}
