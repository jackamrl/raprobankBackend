package com.mycompany.raprobank.contollers;

import com.mycompany.raprobank.entities.Banque;
import com.mycompany.raprobank.service.BanqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/banque")
public class BanqueController {
    private BanqueService banqueService;

    @Autowired
    public BanqueController(BanqueService banqueService) {
        this.banqueService = banqueService;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(value="/add", consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Banque> addBanque(@RequestBody Banque banque){
        Banque newBanque = banqueService.addBanque(banque);
        return new ResponseEntity<>(newBanque, HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/list")
    public ResponseEntity<List<Banque>> listBanque(){
        List<Banque> banques = banqueService.findAll();
        return new ResponseEntity<>(banques,HttpStatus.OK);
    }


}
