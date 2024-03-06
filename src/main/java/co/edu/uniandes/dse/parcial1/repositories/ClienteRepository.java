package co.edu.uniandes.dse.parcial1.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.uniandes.dse.parcial1.entities.ClienteEntity;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity,Long>{

    List<ClienteEntity> findByNumId(String numId);
    
}