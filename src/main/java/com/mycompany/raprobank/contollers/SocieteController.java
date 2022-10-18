package com.mycompany.raprobank.contollers;

import com.mycompany.raprobank.entities.Societe;
import com.mycompany.raprobank.payload.response.MessageResponse;
import com.mycompany.raprobank.repositories.SocieteRepo;
import com.mycompany.raprobank.service.SocieteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/societe")
public class SocieteController {

    private SocieteService societeService;
    private SocieteRepo societeRepo;

    @Autowired
    public SocieteController(SocieteService societeService, SocieteRepo societeRepo) {
        this.societeService = societeService;
        this.societeRepo = societeRepo;
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/add")
    public ResponseEntity<?> addSociete(@Valid  @RequestBody Societe uneSociete){
        if(societeRepo.existsByLibelleSociete(uneSociete.getLibelleSociete())){
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: libelle is aleready taken"));
        }
        //Create new societe
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
