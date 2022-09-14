package com.mycompany.raprobank.entities;

import javax.persistence.*;

@Entity
@Table(name = "mouvemet")
public class Mouvement extends AbstractEntity{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_mouvement")
    private Integer idMouvement;
}
