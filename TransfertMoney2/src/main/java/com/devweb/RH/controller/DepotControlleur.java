package com.devweb.RH.controller;



import com.devweb.RH.model.Depot;
import com.devweb.RH.repository.DepotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/depot")
public class DepotControlleur {

    @Autowired
    private DepotRepository depotRepository;

    @GetMapping(value = "/liste")
    @PreAuthorize("hasAuthority('ROLE_CAISSIER')")
    public List<Depot> liste()
    {
        return depotRepository.findAll();
    }

    @PostMapping(value = "/add", consumes = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAuthority('ROLE_CAISSIER')")
    public Depot add (@RequestBody(required = false) Depot d)
    {

        return depotRepository.save(d);
    }
}
