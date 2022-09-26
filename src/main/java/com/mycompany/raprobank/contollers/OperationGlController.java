package com.mycompany.raprobank.contollers;


import com.mycompany.raprobank.service.OperationGlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/operation")
public class OperationGlController {

    private OperationGlService operationGlService;

    @Autowired
    public OperationGlController(OperationGlService operationGlService) {
        this.operationGlService = operationGlService;
    }
//
//    @CrossOrigin(origins = "*")
//    @PostMapping("/add")
//    public ResponseEntity<OperationGl> addOperationGl(@RequestBody OperationGl operationGl){
//        OperationGl newOperationGl = operationGlService.addOperationGl(operationGl);
//        return new ResponseEntity<>(newOperationGl, HttpStatus.CREATED);
//    }

//    @CrossOrigin(origins = "*")
//    @GetMapping("/list")
//    public ResponseEntity<List<OperationGl>> listOperationGl(){
//        List<OperationGl> operationGls = operationGlService.findAll();
//        return new ResponseEntity<>(operationGls,HttpStatus.OK);
//    }
}
