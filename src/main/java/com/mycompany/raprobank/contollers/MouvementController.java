package com.mycompany.raprobank.contollers;


import com.mycompany.raprobank.entities.Mouvement;
import com.mycompany.raprobank.service.MouvementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mouvement")
public class MouvementController {

    private MouvementService mouvementService;

    @Autowired
    public MouvementController(MouvementService mouvementService) {
        this.mouvementService = mouvementService;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(value="/add",consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Mouvement> addMouvement(@RequestBody Mouvement unMouvement){
        Mouvement newMouvement = mouvementService.addMouvement(unMouvement);
        return new ResponseEntity<>(newMouvement, HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/list")
    public ResponseEntity<List<Mouvement>> listMouvement(){
        List<Mouvement> mouvements = mouvementService.findAll();
        return new ResponseEntity<>(mouvements,HttpStatus.OK);
    }
}
