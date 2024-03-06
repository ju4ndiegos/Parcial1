package co.edu.uniandes.dse.parcial1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.parcial1.entities.TarjetaEntity;
import co.edu.uniandes.dse.parcial1.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.parcial1.repositories.TarjetaRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TarjetaService {
    @Autowired
    private TarjetaRepository tarjetaRepository;

    @Transactional
    public TarjetaEntity createTarjeta (TarjetaEntity tarjetaEntity) throws IllegalOperationException{
        
        if (tarjetaEntity.getPerfil().equals("Standard")){
            if (tarjetaEntity.getCupo()<=1500000) return tarjetaRepository.save(tarjetaEntity);
            else throw new IllegalOperationException("Hubo un error con el cupo de la tarjeta");
        }
        if (tarjetaEntity.getPerfil().equals("Oro")){
            if (tarjetaEntity.getCupo()>1500000 && tarjetaEntity.getCupo()<=3000000) return tarjetaRepository.save(tarjetaEntity);
            else throw new IllegalOperationException("Hubo un error con el cupo de la tarjeta");
        }
        if (tarjetaEntity.getPerfil().equals("Plata")){
            if (tarjetaEntity.getCupo()>3000000 && tarjetaEntity.getCupo()<=6000000) return tarjetaRepository.save(tarjetaEntity);
            else throw new IllegalOperationException("Hubo un error con el cupo de la tarjeta");
        }
        if (tarjetaEntity.getPerfil().equals("Negra")){
            if (tarjetaEntity.getCupo()>6000000) return tarjetaRepository.save(tarjetaEntity);
            else throw new IllegalOperationException("Hubo un error con el cupo de la tarjeta");
        }


        return null;
    }


}
