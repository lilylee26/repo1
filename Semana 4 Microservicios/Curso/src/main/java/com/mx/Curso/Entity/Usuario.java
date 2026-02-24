package com.mx.Curso.Entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "CURSO_USUARIOS")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_USUARIO")
	private Long idUsuario;

	@Column(name = "NOMBRE")
	private String nombre;

	@Column(name = "APP")
	private String app;

	@Column(name = "APM")
	private String apm;

	@Column(name = "SEXO")
	private String sexo;

	@Column(name = "CORREO")
	private String correo;

	@Column(name = "FECHA_NACIMIENTO")
	private Date fechaNacimiento;

	@Column(name = "FECHA_CREACION")
	private Date fechaCreacion;


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="ROL_ID")
	private Rol rol;

}
