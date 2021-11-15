package com.example.demo.Controllers;


import com.example.demo.entities.DRP;
import com.example.demo.repository.DRPRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@CrossOrigin("*")
@RequestMapping("/apiDRP")
public class DRPController {
    @Autowired
    DRPRepository drpRepository;

    @GetMapping("/getDrp")
    public Collection<DRP> getAll(){
        return drpRepository.findAll();
    }

}
