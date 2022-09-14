package com.mycompany.raprobank.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.crypto.Data;

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
    private Data periode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "periode")
    private String type;
    @Basic(optional = true)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "solde_initial")
    private Long soldeInitial;
    @JoinColumn(name = "id_commptebancaire", referencedColumnName = "id_commptebancaire")
    @ManyToOne(optional = false)
    private CompteBancaire compteBancaire;
}
