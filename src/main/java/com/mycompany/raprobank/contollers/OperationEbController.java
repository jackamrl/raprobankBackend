package com.mycompany.raprobank.contollers;

import com.mycompany.raprobank.service.OperationEbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
