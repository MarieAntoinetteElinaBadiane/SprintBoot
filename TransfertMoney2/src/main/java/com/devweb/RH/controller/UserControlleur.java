package com.devweb.RH.controller;

import com.devweb.RH.model.Ajoutuser;
import com.devweb.RH.model.Partenaire;
import com.devweb.RH.model.Role;
import com.devweb.RH.model.User;
import com.devweb.RH.repository.PartenaireRepository;
import com.devweb.RH.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin
@RequestMapping(value = "/user")
public class UserControlleur {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    private PartenaireRepository partenaireRepository;

    @GetMapping(value = "/liste")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<User> liste(){
        return userRepository.findAll();
    }

    @PostMapping(value = "/add", consumes = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAuthority('ROLE_SUPERADMIN')")
    public String add (@RequestBody(required = false) User u)
    {
        u.setPassword(encoder.encode(u.getPassword()));
        Set<Role> roles = new HashSet<>();
        Role role= new Role();
        role.setId((long) 1);
        // Adding elements into HashSet usind add()
        roles.add(role);
        u.setRoles(roles);
        userRepository.save(u);
        return "L'utilisateur a bien ajouté";
    }


    @PostMapping(value = "/ajoutuser",consumes = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String add(@RequestBody(required = false) Ajoutuser aj){

        Partenaire p = new Partenaire();
        p.setNinea(aj.getNinea());
        p.setAdresse(aj.getAdresse());
        p.setNomentreprise(aj.getNomentreprise());
        p.setTelephone(aj.getTelephone());
        p.setRaisonsocial(aj.getRaisonsocial());
        p.setProfile(aj.getProfile());

        partenaireRepository.save(p);

        User u = new User();
        u.setNom(aj.getNom());
        u.setPrenom(aj.getPrenom());
        u.setProfile(aj.getProfile());
        u.setUsername(aj.getUsername());
        u.setPassword(encoder.encode(aj.getPassword()));
        u.setPartenaire(p);

        Set<Role> roles = new HashSet<>();
        Role role= new Role();
        role.setId((long) 3);
        // Adding elements into HashSet usind add()
        roles.add(role);
        u.setRoles(roles);
        userRepository.save(u);

        userRepository.save(u);

        return "Le partenaire a bien ajouté un utilisateur";
    }
}
