package com.mycompany.raprobank.contollers;

import com.mycompany.raprobank.entities.OperationEb;
import com.mycompany.raprobank.entities.OperationGl;
import com.mycompany.raprobank.services.OperationEbService;
import com.mycompany.raprobank.services.OperationGlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/operationEb")
public class OperationEbController {
    private OperationEbService operationEbService;

    @Autowired
    public OperationEbController(OperationEbService operationEbService) {
        this.operationEbService = operationEbService;
    }

//    @CrossOrigin(origins = "*")
//    @PostMapping("/add")
//    public ResponseEntity<OperationEb> addOperationEb(@RequestBody OperationEb operationEb){
//        OperationEb newOperationEb = operationEbService.addOperationEb(operationEb);
//        return new ResponseEntity<>(newOperationEb, HttpStatus.CREATED);
//    }

//    @CrossOrigin(origins = "*")
//    @GetMapping("/list")
//    public ResponseEntity<List<OperationEb>> listOperationEb(){
//        List<OperationEb> operationEbs = operationEbService.findAll();
//        return new ResponseEntity<>(operationEbs,HttpStatus.OK);
//    }
}
