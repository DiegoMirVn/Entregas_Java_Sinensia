package com.curso.inicio;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.curso.model.Paciente;
import com.curso.service.ServicePaciente;

@SpringBootTest
@AutoConfigureMockMvc
class PacienteApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ServicePaciente service;

	@BeforeEach
	public void setup() {
		Paciente paciente = new Paciente();
		paciente.setNombre("Diego");
		paciente.setTelefono("223123123");

		when(service.findByNombre("Diego")).thenReturn(paciente);
	}

	@Test
	void testFindPacienteByNombre() throws Exception {
		mockMvc.perform(get("/paciente/Diego")).andExpect(status().isOk())
				.andExpect(jsonPath("$.nombre").value("Diego")).andExpect(jsonPath("$.telefono").value("223123123"));
	}

}
