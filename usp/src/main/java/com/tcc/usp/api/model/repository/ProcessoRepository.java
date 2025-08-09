package com.tcc.usp.api.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.tcc.usp.api.model.entity.Processo;


public interface ProcessoRepository extends JpaRepository<Processo, Long>, JpaSpecificationExecutor<Processo>  {

}
