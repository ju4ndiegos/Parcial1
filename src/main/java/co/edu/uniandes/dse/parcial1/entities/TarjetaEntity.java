package co.edu.uniandes.dse.parcial1.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Data;
import uk.co.jemos.podam.common.PodamExclude;

@Data
@Entity
public class TarjetaEntity extends BaseEntity {
    
    private String perfil;
    private String franquicia;
    private int cupo;
    
    @PodamExclude
    @ManyToOne
    private ClienteEntity cliente;
}
