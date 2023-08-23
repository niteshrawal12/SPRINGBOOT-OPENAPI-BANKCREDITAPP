package com.openapi.example.controller;

import com.openapi.example.entity.BankCredit;
import com.openapi.example.repository.BankCreditRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(BankCreditController.class)
class BankCreditControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BankCreditRepository mockBankCreditRepository;

    @Test
    void testGetAllBankCredits() throws Exception {
        // Setup
        // Configure BankCreditRepository.findAll(...).
        final BankCredit bankCredit = new BankCredit();
        bankCredit.setId(0L);
        bankCredit.setAccountNumber("accountNumber");
        bankCredit.setCreditAmount(0.0);
        final List<BankCredit> bankCredits = List.of(bankCredit);
        when(mockBankCreditRepository.findAll()).thenReturn(bankCredits);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/api/bankcredits")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isNotNull();
        assertThat(response.getContentAsString()).isNotNull();
    }

    @Test
    void testGetAllBankCredits_BankCreditRepositoryReturnsNoItems() throws Exception {
        // Setup
        when(mockBankCreditRepository.findAll()).thenReturn(Collections.emptyList());

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/api/bankcredits")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isNotNull();
        assertThat(response.getContentAsString()).isNotNull();
    }

    @Test
    void testGetBankCreditById() throws Exception {
        // Setup
        // Configure BankCreditRepository.findById(...).
        final BankCredit bankCredit1 = new BankCredit();
        bankCredit1.setId(0L);
        bankCredit1.setAccountNumber("accountNumber");
        bankCredit1.setCreditAmount(0.0);
        final Optional<BankCredit> bankCredit = Optional.of(bankCredit1);
        when(mockBankCreditRepository.findById(0L)).thenReturn(bankCredit);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/api/bankcredits/{id}", 0)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isNotNull();
        assertThat(response.getContentAsString()).isNotNull();
    }


    @Test
    void testCreateBankCredit() throws Exception {
        // Setup
        // Configure BankCreditRepository.save(...).
        final BankCredit bankCredit = new BankCredit();
        bankCredit.setId(0L);
        bankCredit.setAccountNumber("accountNumber");
        bankCredit.setCreditAmount(0.0);
        final BankCredit entity = new BankCredit();
        entity.setId(0L);
        entity.setAccountNumber("accountNumber");
        entity.setCreditAmount(0.0);
        when(mockBankCreditRepository.save(entity)).thenReturn(bankCredit);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/api/bankcredits")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isNotNull();
        assertThat(response.getContentAsString()).isNotNull();
    }

    @Test
    void testUpdateBankCredit() throws Exception {
        // Setup
        // Configure BankCreditRepository.findById(...).
        final BankCredit bankCredit1 = new BankCredit();
        bankCredit1.setId(0L);
        bankCredit1.setAccountNumber("accountNumber");
        bankCredit1.setCreditAmount(0.0);
        final Optional<BankCredit> bankCredit = Optional.of(bankCredit1);
        when(mockBankCreditRepository.findById(0L)).thenReturn(bankCredit);

        // Configure BankCreditRepository.save(...).
        final BankCredit bankCredit2 = new BankCredit();
        bankCredit2.setId(0L);
        bankCredit2.setAccountNumber("accountNumber");
        bankCredit2.setCreditAmount(0.0);
        final BankCredit entity = new BankCredit();
        entity.setId(0L);
        entity.setAccountNumber("accountNumber");
        entity.setCreditAmount(0.0);
        when(mockBankCreditRepository.save(entity)).thenReturn(bankCredit2);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(put("/api/bankcredits/{id}", 0)
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isNotNull();
        assertThat(response.getContentAsString()).isNotNull();
    }

    @Test
    void testUpdateBankCredit_BankCreditRepositoryFindByIdReturnsAbsent() throws Exception {
        // Setup
        when(mockBankCreditRepository.findById(0L)).thenReturn(Optional.empty());

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(put("/api/bankcredits/{id}", 0)
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isNotNull();
        assertThat(response.getContentAsString()).isNotNull();
    }

    @Test
    void testDeleteBankCredit() throws Exception {
        // Setup
        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(delete("/api/bankcredits/{id}", 0)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isNotNull();
        verify(mockBankCreditRepository).deleteById(0L);
    }
}
