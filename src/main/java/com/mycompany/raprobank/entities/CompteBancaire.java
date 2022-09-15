package com.mycompany.raprobank.entities;

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
public class CompteBancaire extends AbstractEntity {
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
    @JoinColumn(name = "id_banque", referencedColumnName = "id_banque")
    @ManyToOne(optional = false)
    private Banque banque;
    @JoinColumn(name = "id_societe", referencedColumnName = "id_societe")
    @ManyToOne(optional = false)
    private Societe societe;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compteBancaire")
    private List<Mouvement> mouvementList;

    public CompteBancaire() {
    }

    public CompteBancaire(Integer idComptebancaire, String libelleCompte, String numCompte) {
        this.idComptebancaire = idComptebancaire;
        this.libelleCompte = libelleCompte;
        this.numCompte = numCompte;
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

    public Banque getBanque() {
        return banque;
    }

    public Societe getSociete() {
        return societe;
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
}
