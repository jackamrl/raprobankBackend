package com.mycompany.raprobank.entities;

import com.sun.istack.NotNull;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.util.Date;

//Les opérations de l'extrait bancaire
@Entity
@Table(name = "operation_eb")
public class OperationEb extends Operation{
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "description")
    private String description;
    @Basic(optional = true)
    @Size(min = 1, max = 200)
    @Column(name = "inst_code")
    private String instCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_valeur")
    private Date dateValeur;
    @Basic(optional = true)
    @Column(name = "debit")
    private Long debit;
    @Basic(optional = true)
    @Column(name = "credit")
    private Long credit;

//    public OperationEb(Date date, String description, String instCode, Date dateValeur, Long debit, Long credit) {
//        this.date = date;
//        this.description = description;
//        this.instCode = instCode;
//        this.dateValeur = dateValeur;
//        this.debit = debit;
//        this.credit = credit;
//    }

    public OperationEb(Integer idOperation, Mouvement mouvement, Date date, String description, String instCode, Date dateValeur, Long debit, Long credit) {
        super(idOperation, mouvement);
        this.date = date;
        this.description = description;
        this.instCode = instCode;
        this.dateValeur = dateValeur;
        this.debit = debit;
        this.credit = credit;
    }
    public OperationEb(){
    }

//    public Integer getidOpeation() {
//        return getIdOperation();
//    }

    public Date getDate() {
        return date;
    }


    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInstCode() {
        return instCode;
    }

    public void setInstCode(String instCode) {
        this.instCode = instCode;
    }

    public Date getDateValeur() {
        return dateValeur;
    }

    public void setDateValeur(Date dateValeur) {
        this.dateValeur = dateValeur;
    }

    public Long getDebit() {
        return debit;
    }

    public void setDebit(Long debit) {
        this.debit = debit;
    }

    public Long getCredit() {
        return credit;
    }

    public void setCredit(Long credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "OperationEb{" +
                "date=" + date +
                ", description='" + description + '\'' +
                ", instCode='" + instCode + '\'' +
                ", dateValeur=" + dateValeur +
                ", debit=" + debit +
                ", credit=" + credit +
                '}';
    }

    public OperationEb(Integer idOperation, Mouvement mouvement) {
        super(idOperation, mouvement);
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

}
