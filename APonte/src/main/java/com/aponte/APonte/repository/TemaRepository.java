package com.aponte.APonte.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aponte.APonte.model.Tema;

@Repository
public interface TemaRepository extends JpaRepository<Tema, Long> {

}
