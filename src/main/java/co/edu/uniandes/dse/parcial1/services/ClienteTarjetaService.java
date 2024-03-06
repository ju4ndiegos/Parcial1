package co.edu.uniandes.dse.parcial1.services;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniandes.dse.parcial1.entities.ClienteEntity;
import co.edu.uniandes.dse.parcial1.entities.TarjetaEntity;
import co.edu.uniandes.dse.parcial1.repositories.ClienteRepository;
import co.edu.uniandes.dse.parcial1.repositories.TarjetaRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ClienteTarjetaService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private TarjetaRepository tarjetaRepository;

    public void addTarjeta(Long idTarjeta, Long idCliente) throws EntityNotFoundException{
        ClienteEntity cliente = clienteRepository.getById(idCliente);
        if (cliente==null) throw new EntityNotFoundException("Cliente no encontrado");

        TarjetaEntity tarjeta = tarjetaRepository.getById(idTarjeta);

        if (tarjeta==null) throw new EntityNotFoundException("Tarjeta no encontrada");

        cliente.getTarjetas().add(tarjeta);
        tarjeta.setCliente(cliente);
        

    }
}
