package com.mycompany.raprobank.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "societe")
public class Societe extends AbstractEntity{

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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "societe")
    private List<CompteBancaire> compteBancaireList;
    
}
