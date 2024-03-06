package co.edu.uniandes.dse.parcial1.repositories;

import co.edu.uniandes.dse.parcial1.entities.*;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarjetaRepository extends JpaRepository<TarjetaEntity,Long> {

    List<TarjetaEntity> findByCliente(ClienteEntity cliente);
    
}
