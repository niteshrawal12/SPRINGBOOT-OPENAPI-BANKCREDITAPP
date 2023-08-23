package com.openapi.example.controller;
import com.openapi.example.entity.BankCredit;
import com.openapi.example.repository.BankCreditRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/bankcredits")
public class BankCreditController {
    private final BankCreditRepository bankCreditRepository;
    @Autowired
    public BankCreditController(BankCreditRepository bankCreditRepository) {
        this.bankCreditRepository = bankCreditRepository;
    }
    @Operation(summary = "this will fetch all the BankCredit stored in the db")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200",
            description = "Fetched all the bank credit", content = {@Content(mediaType = "application/json")}),
                    @ApiResponse(responseCode = "404",description = "Not Available",content = @Content)
    })
    @GetMapping
    public List<BankCredit> getAllBankCredits() {
        return bankCreditRepository.findAll();
    }
    @GetMapping("/{id}")
    public BankCredit getBankCreditById(@PathVariable Long id) {
        return bankCreditRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bank credit not found with id: " + id));
    }
    @PostMapping
    public BankCredit createBankCredit(@RequestBody BankCredit bankCredit) {
        return bankCreditRepository.save(bankCredit);
    }
    @PutMapping("/{id}")
    public BankCredit updateBankCredit(@PathVariable Long id, @RequestBody BankCredit bankCredit) {
        BankCredit existingCredit = bankCreditRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bank credit not found with id: " + id));
        existingCredit.setAccountNumber(bankCredit.getAccountNumber());
        existingCredit.setCreditAmount(bankCredit.getCreditAmount());
        return bankCreditRepository.save(existingCredit);
    }
    @DeleteMapping("/{id}")
    public void deleteBankCredit(@PathVariable Long id) {
        bankCreditRepository.deleteById(id);
    }
}
