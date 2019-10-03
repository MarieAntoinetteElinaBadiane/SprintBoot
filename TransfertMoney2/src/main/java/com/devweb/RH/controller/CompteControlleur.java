package com.devweb.RH.controller;



import com.devweb.RH.model.Compte;
import com.devweb.RH.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/compte")
public class CompteControlleur {

    @Autowired
    private CompteRepository compteRepository;

    @GetMapping(value = "/liste")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Compte> liste()
    {
        return compteRepository.findAll();
    }

    @PostMapping(value = "/add", consumes = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Compte add (@RequestBody(required = false) Compte c)
    {
        return compteRepository.save(c);
    }
}
