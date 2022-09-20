package com.mycompany.raprobank.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "societe")
public class Societe extends AbstractEntity implements EntityItem<Integer>{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_societe")
    private Integer idSociete;
    @Basic(optional = true)
    @Size(min = 1, max = 1000)
    @Column(name = "description")
    private String description;
    @JsonManagedReference(value = "societe")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "societe", fetch = FetchType.EAGER)
    //@JsonManagedReference
    private List<CompteBancaire> compteBancaireList;

    public Societe() {
    }

    public Societe(Integer idSociete, String description) {
        this.idSociete = idSociete;
        this.description = description;
    }

    public Societe(Integer idSociete, String description, List<CompteBancaire> compteBancaireList) {
        this.idSociete = idSociete;
        this.description = description;
        this.compteBancaireList = compteBancaireList;
    }


    public Integer getIdSociete() {
        return idSociete;
    }

    public void setIdSociete(Integer idSociete) {
        this.idSociete = idSociete;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<CompteBancaire> getCompteBancaireList() {
        return compteBancaireList;
    }

    public void setCompteBancaireList(List<CompteBancaire> compteBancaireList) {
        this.compteBancaireList = compteBancaireList;
    }

    @Override
    public String toString() {
        return "Societe{" +
                "idSociete=" + idSociete +
                ", description='" + description + '\'' +
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
        return idSociete;
    }
}
