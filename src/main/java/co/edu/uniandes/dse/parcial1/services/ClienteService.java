package co.edu.uniandes.dse.parcial1.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.parcial1.entities.ClienteEntity;
import co.edu.uniandes.dse.parcial1.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.parcial1.repositories.ClienteRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    public ClienteEntity createCliente (ClienteEntity clienteEntity) throws IllegalOperationException{
        String numero=clienteEntity.getNumTelefono();
        if (numero==null) throw new IllegalOperationException("El número de telefono es null");
        if (numero.length()!=13) throw new IllegalOperationException("El número no tienen +57, seguido de 10 digitos");
        if (!numero.contains("+57")) throw new IllegalOperationException("El número de telefono no empieza con +57");
        
        return clienteRepository.save(clienteEntity);
    }

    /*
     * 
     * private boolean verificarInicioNumero(String numero){

        char a = numero.charAt(0);
        if (a=="+") return false;


        if (numero.charAt(1)!="5") return false;
        if (numero.charAt(2)!="7") return false;
        return true;
    }
     */
}
