package com.mx.Curso.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "CURSO_ROLES")
public class Rol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "ID_ROL")
	private Long idRol;

	@Column(name = "PRIVILEGIO")
	private String privilegio;

}
