package com.manifesting.fileConvertor.tcda.controller;

import com.manifesting.fileConvertor.tcda.entity.TcdaModel;
import com.manifesting.fileConvertor.tcda.service.TcdaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class TcdaController {


     @Autowired
    private TcdaService tcdaService;

    @PostMapping("/addOne/tcda")
    public TcdaModel addObject ( @RequestBody TcdaModel tcdaModel ) {
        return tcdaService.saveObject(tcdaModel);
    }

    @PostMapping("/addMany/tcda")
    public List<TcdaModel> addObjects ( @RequestBody List<TcdaModel> list ) {
        return tcdaService.saveObjects(list);
    }

    @GetMapping("/getAll/tcda")
    public List<TcdaModel> getAllObject () {
        return tcdaService.getTcdaModels();

    }


}
