package com.mx.Product.Entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumeratedValue;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table 
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

//SOBREESCRIBE EL COMANDO DELETE SQL PARA QUE EN SU LUGAR HAGA UN UPDATE Y MARQUE LA FECHADE BORRADO DANDO UN TIPO DE AUDITORIA

@SQLDelete (sql= "UPDATE PRODUCTO SET DELETE_AT = SYSDATE WHERE ID_PRODUCTO = ?")
//CADA QUE SE REALICE UNA SENTENCIA DE TIPO SELECT (NUESTRO LISTAR), FILTRARA AUTOMATICAMENTE SOLO LOS REGISTROS QUE TENGAN EN DELETE_AT COMO NULLS
//Y ESO NOS PERMIRA, VISUALIZAR EN EL FRONT, QUE SI SE ELIMINARON LOS REGISTROS, PERO SIGUIRE TENIENDO REGUARDADOS LOS REGISTROS EN LA BD
@SQLRestriction("DELETE_AT IS NULL")


public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PRODUCTO", columnDefinition = "NUMBER")
	private Integer idProducto;

	@Column(name = "NOMBRE", length = 100, nullable = false, unique = true)
	private String nombre;

	@Column(name = "DESCRIPCION", length = 100)
	private String descripcion;

	@Column(name = "PRECIO", nullable = false)
	private BigDecimal precio; // BigDecimal es el valor estandar para cantidades de dinero

	@Column(name = "STOCK", nullable = false)
	private Integer stock;

	@Column(name = "FECHA_EMPAQUE", insertable = false, updatable = false) // mapea la fecha con valor por defecto
	private LocalDateTime fechaEmpaque;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "UNIDAD_VENTA", length = 20)
	private EnumUnidad unidadVenta;
	
	@Column(name = "DELETE_AT")
	private LocalDateTime deleteAt;

}
