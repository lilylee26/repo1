package com.mx.Client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.springframework.dao.EmptyResultDataAccessException;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import com.mx.Client.Entity.Cliente;
import com.mx.Client.Repository.ClienteRepository;
import com.mx.Client.Service.ClienteService;
import com.netflix.discovery.converters.Auto;

import jakarta.transaction.Transactional;

@SpringBootTest
@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:application.properties") // especifica cual conficugacion se usa de db
@Transactional // sirve para la transaccion de una db pero aqui me esta ayudando a
//realizar un rollback de todas las operaciones que mande como preuba
public class TestIntegration {

	@Autowired
	private ClienteService service;

	@Autowired
	private ClienteRepository dao;

	@BeforeEach
	void setUp() {
		dao.deleteAll(); // para aseurarnos que con cada prueba se iniciara con una db vacia

	}

	// verificar un guardado exitoso
	@Test
	void testGuardadoExitoso() {
		Cliente cliente = new Cliente();
		cliente.setNombre("Raul");
		cliente.setEmail("Raul@gmail.com");
		cliente.setTelefono(546565666L);
		cliente.setDireccion("Calle boulevard");
		cliente.setTiendaId(1);

		service.guardar(cliente);

		// pruebas (funciona al id incremental
		assertTrue(cliente.getIdCliente() > 0, "el id si se genereo automaticamente");
		// si es true o exitoso vere el mesnaje en consola
		System.out.println(cliente);
		// prueba si se guardo y al buscar no marca error

		Cliente guardado = dao.findById(cliente.getIdCliente())
				.orElseThrow(() -> new AssertionError("Deberia existir y por lo tanto buscar"));

		// verificar si el buscar, los valores coinciden
		assertNotNull(guardado);
		assertEquals("Raul", guardado.getNombre()); // verificar que lo que yo mande si se guardo en la bd
		assertEquals("Raul@gmail.com", guardado.getEmail());
		assertEquals(546565666L, guardado.getTelefono());
		assertEquals("Calle boulevard", guardado.getDireccion());
		assertEquals(1, guardado.getTiendaId());

	}

	// bucar si existe
	@Test
	void testBuscarPorIdExitoso() {
		// crear regustro
		Cliente cli = new Cliente("Mariana", "Mariana123@gmail.com", 56555645615L, "E. Zapata", 1);
		// almacenar en la db
		service.guardar(cli);
		// obtener el id
		int idCliente = cli.getIdCliente();

		// validar si existe
		Optional<Cliente> encontrado = dao.findById(idCliente);
		System.out.println(encontrado);

		// comprobar si existe
		assertTrue(encontrado.isPresent(), "Bederia encontrar el id");
		assertEquals("Mariana", encontrado.get().getNombre());// verificfica que si lo encontro coincide con el valor
																// esoerado

	}

	@Test
	void testListadoExitoso() {

		Cliente cliente1 = new Cliente("Raul", "raul@gmail.com", 546565666L, "Calle boulevard", 1);
		Cliente cliente2 = new Cliente("Mariana", "mariana@gmail.com", 56555645615L, "E. Zapata", 1);

		service.guardar(cliente1);
		service.guardar(cliente2);

		var lista = service.listar();

		assertNotNull(lista);
		assertEquals(2, lista.size());

		System.out.println("Si esta el listado");

		for (Cliente c : lista) {
			System.out.println(c);
		}

		assertEquals("Mariana", lista.get(0).getNombre());
		assertEquals("Raul", lista.get(1).getNombre());
	}

	@Test
	void testEditarIdNoExiste() {

		Cliente cliente = new Cliente();
		cliente.setIdCliente(999); // id que no existe
		cliente.setNombre("Nuevo");
		cliente.setEmail("nuevo@gmail.com");
		cliente.setTelefono(955453153659L);
		cliente.setDireccion("Av editar");
		cliente.setTiendaId(1);

		String resp = service.edita(cliente);

		assertNotNull(resp);
		assertEquals("No existe ese cliente", resp);

		System.out.println(resp);
	}

	@Test
	void testEliminarIdNoExiste() {

		int idNoExiste = 9999;

		String resp = service.eliminar(idNoExiste);

		assertNotNull(resp);
		assertEquals("El id que intenta eliminar no existe", resp);

		System.out.println(resp);
	}

}
