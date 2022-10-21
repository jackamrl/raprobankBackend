package com.mycompany.raprobank.contollers;

import com.mycompany.raprobank.entities.Operation;
import com.mycompany.raprobank.entities.OperationEb;
import com.mycompany.raprobank.entities.OperationGl;
import com.mycompany.raprobank.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/operation")
public class OperationController {

    private OperationService operationService;

    @Autowired
    public OperationController(OperationService operationService) {
        this.operationService = operationService;
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/add")
    public ResponseEntity<Operation> addOperation(@RequestBody Operation uneOperation){
        Operation newOperation = operationService.addOperation(uneOperation);
        return new ResponseEntity<>(newOperation, HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/list")
    public ResponseEntity<List<Operation>> listOperation(){
        List<Operation> operations = operationService.findAll();
        return new ResponseEntity<>(operations,HttpStatus.OK);
    }


    @CrossOrigin(origins = "*")
    @GetMapping("/listGl")
    public ResponseEntity<List<OperationGl>> listOperationGl(){
        List<OperationGl> operationgls = operationService.findOperationGl();
        return new ResponseEntity<>(operationgls,HttpStatus.OK);
    }


    @CrossOrigin(origins = "*")
    @GetMapping("/listEb")
    public ResponseEntity<List<OperationEb>> listOperationEb(){
        List<OperationEb> operationEbs = operationService.findOperationEb();
        return new ResponseEntity<>(operationEbs,HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/addOperationEb", consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Operation> addOperationEb(@RequestBody OperationEb uneOperationEb){
        OperationEb newOperationEb = operationService.addOperationEb(uneOperationEb);
        return new ResponseEntity<>(newOperationEb, HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/addOperationGl",consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Operation> addOperationGl(@RequestBody OperationGl uneOperationGl){
        OperationGl newOperationGl = operationService.addOperationGl(uneOperationGl);
        return new ResponseEntity<>(newOperationGl, HttpStatus.CREATED);
    }
}
