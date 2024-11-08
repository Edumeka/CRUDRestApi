package hn.emeka.demo.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "clientes") // Nombre de la tabla en la base de datos
public class ClientesEntity {
    @Id
    private int dni;
    
    private String nombre;
    
    @Column(name = "fechanacimiento") // Nombre de la columna en la base de datos
    private LocalDate fechaNacimiento;

    private String telefono;
    private String correo;
}
