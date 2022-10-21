package com.mycompany.raprobank.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

// Il s'agit de l'opération sur chaque extrait
@Entity
@Table(name="operation")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING,
        name = "operation_type")
@DiscriminatorValue(value="operation")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Operation extends AbstractEntity implements EntityItem<Integer>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name="id_operation")
    private Integer idOperation;
    //@JsonIgnore
    //@JsonBackReference(value = "id_mouvement")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_mouvement", referencedColumnName = "id_mouvement", nullable = false)
    private Mouvement mouvement;


    public Operation() {
    }

    public Operation(@JsonProperty("idOperation") Integer idOperation, @JsonProperty("mouvement") Mouvement mouvement) {
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

    @Override
    public Integer getId() {
        return idOperation;
    }
}
