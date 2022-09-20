package com.mycompany.raprobank.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Size;

//Les opérations du grand livre
@Entity
@DiscriminatorValue("Grand Livre")
public class OperationGl extends Operation{
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_gl")
    private String date;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "libelle_operation_gl")
    private String libelleOperationGl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "montant")
    private Long montant;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "reference")
    private String reference;

    public OperationGl() {
    }

    public OperationGl(String date, String libelleOperationGl, Long montant, String reference) {
        this.date = date;
        this.libelleOperationGl = libelleOperationGl;
        this.montant = montant;
        this.reference = reference;
    }

    public OperationGl(Integer idOperation, Mouvement mouvement) {
        super(idOperation, mouvement);
    }

    public OperationGl(Integer idOperation, Mouvement mouvement, String date, String libelleOperationGl, Long montant, String reference) {
        super(idOperation, mouvement);
        this.date = date;
        this.libelleOperationGl = libelleOperationGl;
        this.montant = montant;
        this.reference = reference;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLibelleOperationGl() {
        return libelleOperationGl;
    }

    public void setLibelleOperationGl(String libelleOperationGl) {
        this.libelleOperationGl = libelleOperationGl;
    }

    public Long getMontant() {
        return montant;
    }

    public void setMontant(Long montant) {
        this.montant = montant;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    @Override
    public String toString() {
        return "OperationGl{" +
                "date=" + date +
                ", libelleOperationGl='" + libelleOperationGl + '\'' +
                ", montant=" + montant +
                ", reference='" + reference + '\'' +
                '}';
    }

    @Override
    public Integer getIdOperation() {
        return super.getIdOperation();
    }

    @Override
    public void setIdOperation(Integer idOperation) {
        super.setIdOperation(idOperation);
    }

    @Override
    public Mouvement getMouvement() {
        return super.getMouvement();
    }

    @Override
    public void setMouvement(Mouvement mouvement) {
        super.setMouvement(mouvement);
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
