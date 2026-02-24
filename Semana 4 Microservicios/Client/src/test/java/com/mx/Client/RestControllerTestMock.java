package com.mx.Client;

import static org.mockito.Mockito.when;

import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;


import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mx.Client.Controller.ClienteController;
import com.mx.Client.Entity.Cliente;
import com.mx.Client.Service.ClienteService;
import org.springframework.http.MediaType;



@WebMvcTest(ClienteController.class)
public class RestControllerTestMock {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockitoBean
	private ClienteService service;
	

	
	@Test
	void restClienteControllerListar() throws Exception{
		//crea algunis objetos y akmacenarlos en una lista estatica
		Cliente cliente1= new Cliente(1, "Gonzalo", "gon@gmail.com", 564846565, "mariposas 23", 1 );
		Cliente cliente2= new Cliente(1, "Mariana", "mariana@gmail.com", 558451515, "mariposas 23", 1 );
		
		List<Cliente> clientes = List.of(cliente1, cliente2);
		//simula en el servicio el metodo listar  NOS DEVUELVE UNA LISTA DE CLIENTES
		when(service.listar()).thenReturn(clientes);
		
		//CONVERTIR LA LISTA EN FORMATO JSON
		ObjectMapper objectMapper = new ObjectMapper();
		String listaJson= objectMapper.writeValueAsString(clientes);
		
		//realizar la solicitud 
		this.mockMvc.perform(get("/C"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().json(listaJson));
		
	
	}
	
	//BUSCAR POR ID
    @Test
    void buscarPorCliente() throws Exception {

        Cliente cliente = new Cliente(1, "Gonzalo", "gon@gmail.com", 564846565, "mariposas 23", 1);

        when(service.buscar(1)).thenReturn(cliente);

        ObjectMapper objectMapper = new ObjectMapper();
        String clienteJson = objectMapper.writeValueAsString(cliente);

        this.mockMvc.perform(get("/C/1"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().json(clienteJson));
    }

    //GUARDAR
    @Test
    void guardarCliente() throws Exception {

        Cliente cliente = new Cliente(null, "Lili", "lili@gmail.com", 551234567, "CDMX", 1);
        Cliente guardado = new Cliente(10, "Lili", "lili@gmail.com", 551234567, "CDMX", 1);

        when(service.existeTelefono(cliente.getTelefono())).thenReturn(false);
        when(service.existeCliente(cliente.getNombre(), cliente.getEmail())).thenReturn(false);
        when(service.guardar(org.mockito.ArgumentMatchers.any(Cliente.class))).thenReturn(guardado);

        ObjectMapper objectMapper = new ObjectMapper();
        String clienteJson = objectMapper.writeValueAsString(cliente);
        String guardadoJson = objectMapper.writeValueAsString(guardado);

        this.mockMvc.perform(post("/C")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(clienteJson)
            )
            .andDo(print())
            .andExpect(status().isCreated())
            .andExpect(content().json(guardadoJson));
    }

    //EDITAR
    @Test
    void editarCliente() throws Exception {

        Cliente existe = new Cliente(10, "Lili", "lili@gmail.com", 551234567, "CDMX", 1);
        Cliente editado = new Cliente(10, "Lili Editada", "lili@gmail.com", 551234567, "CDMX", 1);

        when(service.buscar(10)).thenReturn(existe);
        when(service.editar(org.mockito.ArgumentMatchers.any(Cliente.class))).thenReturn(editado);

        ObjectMapper objectMapper = new ObjectMapper();
        String editadoJson = objectMapper.writeValueAsString(editado);

        this.mockMvc.perform(put("/C/10")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(editadoJson)
            )
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().json(editadoJson));
    }

    //ELIMINAR
    @Test
    void eliminarCliente() throws Exception {

        Cliente cliente = new Cliente(10, "Lili", "lili@gmail.com", 551234567, "CDMX", 1);

        when(service.buscar(10)).thenReturn(cliente);
        doNothing().when(service).eliminar(10);

        this.mockMvc.perform(delete("/C/10"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string("Eliminado con exito"));
    }

}
