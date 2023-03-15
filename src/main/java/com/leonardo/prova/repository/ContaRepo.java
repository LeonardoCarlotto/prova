package com.leonardo.prova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leonardo.prova.model.ContaModel;

@Repository
public interface ContaRepo extends JpaRepository<ContaModel, Long> {

}
