package com.devweb.RH.repository;

import com.devweb.RH.model.Partenaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface PartenaireRepository extends JpaRepository<Partenaire, Integer> {
    
}