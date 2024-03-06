package co.edu.uniandes.dse.parcial1.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.Data;
import uk.co.jemos.podam.common.PodamExclude;

@Data
@Entity
public class ClienteEntity extends BaseEntity{
    
    private String nombre;
    private String apellido;
    private String numId;
    private String numTelefono;

    @PodamExclude
    @OneToMany
    private List<TarjetaEntity> tarjetas= new ArrayList<>();
}
