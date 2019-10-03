package com.devweb.RH.controller;

import com.devweb.RH.model.*;
import com.devweb.RH.repository.CompteRepository;
import com.devweb.RH.repository.PartenaireRepository;
import com.devweb.RH.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin

@RequestMapping(value = "/partenaire") // comme symfony Api/...
public class PartenaireControleur {

    @Autowired // sa permet de donner le reference de l'objet
    private PartenaireRepository partenaireRepository;
@Autowired
    PasswordEncoder encoder;
@Autowired
private UserRepository userRepository;
@Autowired
private CompteRepository compteRepository;

    @GetMapping(value = "/liste")
    @PreAuthorize("hasAuthority('ROLE_SUPERADMIN')")
    public List<Partenaire> list(){
        return  partenaireRepository.findAll();
    }

    @PostMapping (value = "/add",consumes = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAuthority('ROLE_SUPERADMIN')")
    public String add(@RequestBody(required = false) Ajout a){

Partenaire p = new Partenaire();
p.setNinea(a.getNinea());
p.setAdresse(a.getAdresse());
p.setNomentreprise(a.getNomentreprise());
p.setTelephone(a.getTelephone());
p.setRaisonsocial(a.getRaisonsocial());
p.setProfile(a.getProfile());

    partenaireRepository.save(p); // on peut utiliser aussi saveOnUpdate   return "redirect:/user";

        Compte c = new Compte();
        c.setDatecreation(a.getDatecreation());
        c.setNumerocompte(a.getNumerocompte());
        c.setSolde(a.getSolde());
        c.setPartenaire(p);

        compteRepository.save(c);


        User u = new User();
        u.setNom(a.getNom());
        u.setPrenom(a.getPrenom());
        u.setProfile(a.getProfile());
        u.setUsername(a.getUsername());
        u.setPassword(encoder.encode(a.getPassword()));
        u.setPartenaire(p);
        u.setCompte(c);
         userRepository.save(u);

        Set<Role> roles = new HashSet<>();
        Role role= new Role();
        role.setId((long) 2);
        // Adding elements into HashSet usind add()
        roles.add(role);
        u.setRoles(roles);
        userRepository.save(u);

         return "Le partenaire a bien ajouté un utilisateur à un compte";
    }

    }

