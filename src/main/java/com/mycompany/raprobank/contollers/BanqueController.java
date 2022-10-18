package com.mycompany.raprobank.contollers;

import com.mycompany.raprobank.entities.Banque;
import com.mycompany.raprobank.payload.response.MessageResponse;
import com.mycompany.raprobank.repositories.BanqueRepo;
import com.mycompany.raprobank.service.BanqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/banque")
public class BanqueController {
    private BanqueService banqueService;
    private BanqueRepo banqueRepo;

    @Autowired
    public BanqueController(BanqueService banqueService, BanqueRepo banqueRepo) {
        this.banqueService = banqueService;
        this.banqueRepo = banqueRepo;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(value="/add", consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addBanque(@Valid @RequestBody Banque unebanque){
        if(banqueRepo.existsByLibelleBanque(unebanque.getLibelleBanque())){
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: libelle is aleready taken"));
        }
        //Create new banque
        Banque newBanque = banqueService.addBanque(unebanque);
        return new ResponseEntity<>(newBanque, HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/list")
    public ResponseEntity<List<Banque>> listBanque(){
        List<Banque> banques = banqueService.findAll();
        return new ResponseEntity<>(banques,HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @PostMapping(value="/findById", consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> searchBanque( @RequestBody Banque mabanque){
        Banque newBanque = banqueService.findBanqueById(mabanque.getIdBanque());
        return new ResponseEntity<>(newBanque.getLibelleBanque(), HttpStatus.OK);
    }


}
