package com.mycompany.raprobank.contollers;

import com.mycompany.raprobank.entities.CompteBancaire;
import com.mycompany.raprobank.entities.OperationGl;
import com.mycompany.raprobank.services.CompteBancaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comptebancaire")
public class CompteBancaireController {

    private CompteBancaireService compteBancaireService;

    @Autowired
    public CompteBancaireController(CompteBancaireService compteBancaireService) {
        this.compteBancaireService = compteBancaireService;
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/add")
    public ResponseEntity<CompteBancaire> addCompteBancaire(@RequestBody CompteBancaire unCompteBancaire){
        CompteBancaire newCompteBancaire = compteBancaireService.addCompteBancaire(unCompteBancaire);
        return new ResponseEntity<>(newCompteBancaire, HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/list")
    public ResponseEntity<List<CompteBancaire>> listCompteBancaire(){
        List<CompteBancaire> compteBancaires = compteBancaireService.findAll();
        return new ResponseEntity<>(compteBancaires,HttpStatus.OK);
    }
}
