package com.mx.Tienda.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString


public class Tienda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTienda;
	private String nombre;
	private Long telefono;
	private String email;

	
	
}



