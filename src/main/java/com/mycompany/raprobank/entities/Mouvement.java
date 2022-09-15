package com.mycompany.raprobank.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "mouvement")
//Un mouvement est soit un extrait de grand livre ou un extrait de releve bancaire

public class Mouvement extends AbstractEntity{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_mouvement")
    private Integer idMouvement;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "periode")
    private Date periode;
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
    @JoinColumn(name = "id_commptebancaire", referencedColumnName = "id_commptebancaire")
    @ManyToOne(optional = false)
    private CompteBancaire compteBancaire;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mouvement")
    private List<Operation> operationList;

    public Mouvement() {
    }

    public Mouvement(Integer idMouvement, Date periode, String type, Long soldeInitial, CompteBancaire compteBancaire, List<Operation> operationList) {
        this.idMouvement = idMouvement;
        this.periode = periode;
        this.type = type;
        this.soldeInitial = soldeInitial;
        this.compteBancaire = compteBancaire;
        this.operationList = operationList;
    }

    public Integer getIdMouvement() {
        return idMouvement;
    }

    public Date getPeriode() {
        return periode;
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

    public void setPeriode(Date periode) {
        this.periode = periode;
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
                ", periode=" + periode +
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
}
