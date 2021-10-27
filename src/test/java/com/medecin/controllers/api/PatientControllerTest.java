package com.medecin.controllers.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.medecin.model.Patient;
import com.medecin.repository.PatientRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebMvcTest(PatientController.class)
public class PatientControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @MockBean
    PatientRepository patientRepository;

    Patient patient1 = new Patient("Shubham", "Vishwakarma", "Male", 23, "8655676678");
    Patient patient2 = new Patient("Samriddha", "Basu", "Male", 23, "1234567890");
    Patient patient3 = new Patient("Priyanka", "Lubal", "Female", 23, "0123456789");

    @Test
    public void getAllPatientsTest() throws Exception {
        List<Patient> patients = new ArrayList<>(Arrays.asList(patient1, patient2, patient3));

        Mockito.when(patientRepository.findAll()).thenReturn(patients);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/patient").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[2].firstName", is("Priyanka")));
    }

    @Test
    public void addNewPatientTest() throws Exception {
        Patient patient = new Patient("Shubham", "Vishwakarma", "Male", 23, "8655676678");

        Mockito.when(patientRepository.save(patient)).thenReturn(patient);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/api/patient")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(patient));

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.firstName", is("Shubham")));
    }
}
