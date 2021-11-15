package com.example.demo.Controllers;


import com.example.demo.entities.Allocation;
import com.example.demo.repository.AllocationRepository;
import com.example.demo.service.AllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin("*")
@RequestMapping("/apiAllocation")
public class AllocationController {
    @Autowired
    AllocationService allocationService;
    @Autowired
    AllocationRepository allocationRepository;

    @PostMapping("/addAllocation/{idLigneBudget}")
    public Allocation ajoutLigneBudget(@RequestBody Allocation a, @PathVariable  long idLigneBudget){
        return allocationService.saveAllocation(a,idLigneBudget);
    }

    @GetMapping("/getAllocationByLigne/{idLigne}")
    public Collection<Allocation> getAllocationByLigne(@PathVariable long idLigne){
        return allocationRepository.findAllocationByLignebudgetaire(idLigne);
    }

}
