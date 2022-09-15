package com.mycompany.raprobank.entities;


import javax.persistence.*;

// Il s'agit de l'opération sur chaque extrait
@Entity
@Table(name="operation")
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name="id_operation")
    private Integer idOperation;
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_mouvement", referencedColumnName = "id_mouvement")
    private Mouvement mouvement;

    public Operation() {
    }

    public Operation(Integer idOperation, Mouvement mouvement) {
        this.idOperation = idOperation;
        this.mouvement = mouvement;
    }

    public Integer getIdOperation() {
        return idOperation;
    }

    public void setIdOperation(Integer idOperation) {
        this.idOperation = idOperation;
    }

    public Mouvement getMouvement() {
        return mouvement;
    }

    public void setMouvement(Mouvement mouvement) {
        this.mouvement = mouvement;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "idOperation=" + idOperation +
                ", mouvement=" + mouvement +
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
