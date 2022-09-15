package com.mycompany.raprobank.contollers;


import com.mycompany.raprobank.entities.OperationGl;
import com.mycompany.raprobank.services.OperationGlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OperationGlController {
    @Autowired
    private OperationGlService operationGlService;

//    @RequestMapping(path = "mydata")
//    public void importData(){
//        operationGlService.importerExtraitGl();
//    }

    @CrossOrigin(origins = "*")
    @PostMapping("/add")
    public ResponseEntity<OperationGl> addOperationGl(@RequestBody OperationGl operationGl){
        OperationGl newOperationGl = operationGlService.addOperationGl(operationGl);
        return new ResponseEntity<>(newOperationGl, HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/operationGlList")
    public ResponseEntity<List<OperationGl>> listOperationGl(){
        List<OperationGl> operationGls = operationGlService.;
        return new ResponseEntity<>(companies,HttpStatus.OK);
    }
}
