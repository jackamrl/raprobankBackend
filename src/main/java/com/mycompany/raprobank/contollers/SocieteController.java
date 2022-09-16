package com.mycompany.raprobank.contollers;

import com.mycompany.raprobank.entities.OperationGl;
import com.mycompany.raprobank.entities.Societe;
import com.mycompany.raprobank.services.SocieteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/societe")
public class SocieteController {

    private SocieteService societeService;

    @Autowired
    public SocieteController(SocieteService societeService) {
        this.societeService = societeService;
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/add")
    public ResponseEntity<Societe> addSociete(@RequestBody Societe uneSociete){
        Societe newSociete = societeService.addSociete(uneSociete);
        return new ResponseEntity<>(newSociete, HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/list")
    public ResponseEntity<List<Societe>> listSociete(){
        List<Societe> societes = societeService.findAll();
        return new ResponseEntity<>(societes,HttpStatus.OK);
    }
}
