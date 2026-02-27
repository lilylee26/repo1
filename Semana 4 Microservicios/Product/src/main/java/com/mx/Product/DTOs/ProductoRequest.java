package com.mx.Product.DTOs;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.mx.Product.Entity.EnumUnidad;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder //permite construir objetos usando el patron del patron builder, ayudando a tener un mejor flujo de datos
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProductoRequest {
	
	/*este DTO se encargara de la captura de los datos del producto y de manejar las validaciones de entrada */
	@NotBlank(message = "El nombre es obligatorio") // No permite valores nulos, espacios en blanco
	@Size(min = 1, max = 100, message = "El nombre no puede tener mas de 100 caracteres")
	@Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$", message = "El nombre solo puede contener letras y espacios")
	private String nombre;

	@NotBlank(message = "La descripcion es obligatoria")
	@Size(min = 1, max = 100, message = "La descripcion no puede tener mas de 100 caracteres")
	private String descripcion;

	@NotBlank(message = "El precio es obligatorio")
	@Pattern(regexp = "\\d+", message = "El precio solo puede tener digitos")
	private BigDecimal precio;

	@NotBlank(message = "El stock es obligatorio")
	@Pattern(regexp = "\\d+", message = "El stock solo puede tener digitos")
	private Integer stock;

	@NotBlank(message = "La unidad de venta es obligatoria")
	@Size(min = 1, max = 20, message = "La unidad de ventana puede tener mas de 20 caracteres")
	private EnumUnidad unidadVenta;

	//usualmente no se recibe del productos, pero debe incluirse en el mapeo
	private LocalDateTime deleteAt;
	
	
}
