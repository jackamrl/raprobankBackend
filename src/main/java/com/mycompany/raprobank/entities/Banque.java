package com.mycompany.raprobank.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "banque",  uniqueConstraints = {
        @UniqueConstraint(columnNames = "libelle_banque")
})
public class Banque extends AbstractEntity implements EntityItem<Integer> {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_banque")
    private Integer idBanque;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "libelle_banque")
    private String libelleBanque;
    @Basic(optional = true)
    @NotNull
    @Size(min = 1, max = 800)
    @Column(name = "description")
    private String description;
    //@JsonManagedReference(value = "banque")

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "banque",fetch = FetchType.EAGER)
    private List<CompteBancaire> compteBancaireList;

    public Banque() {
    }

    public Banque(Integer idBanque, String libelleBanque, String description) {
        this.idBanque = idBanque;
        this.libelleBanque = libelleBanque;
        this.description = description;
    }

    public Banque(Integer idBanque, String libelleBanque, List<CompteBancaire> compteBancaireList) {
        this.idBanque = idBanque;
        this.libelleBanque = libelleBanque;
        this.compteBancaireList = compteBancaireList;
    }

    public Banque(Integer idBanque) {
        this.idBanque = idBanque;
    }

    public Integer getIdBanque() {
        return idBanque;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLibelleBanque() {
        return libelleBanque;
    }
    @JsonIgnore
    public List<CompteBancaire> getCompteBancaireList() {
        return compteBancaireList;
    }

    public void setIdBanque(Integer idBanque) {
        this.idBanque = idBanque;
    }

    public void setLibelleBanque(String libelleBanque) {
        this.libelleBanque = libelleBanque;
    }

    public void setCompteBancaireList(List<CompteBancaire> compteBancaireList) {
        this.compteBancaireList = compteBancaireList;
    }

    @Override
    public String toString() {
        return "Banque{" +
                "idBanque=" + idBanque +
                ", libelleBanque='" + libelleBanque + '\'' +
                ", compteBancaireList=" + compteBancaireList +
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
        return idBanque;
    }
}

