package hn.emeka.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hn.emeka.demo.model.ClientesEntity;

@Repository
public interface ClienteRepository  extends  JpaRepository<ClientesEntity, Integer>{

    
}
