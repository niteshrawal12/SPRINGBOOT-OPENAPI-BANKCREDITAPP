package com.openapi.example.camunda;
import com.openapi.example.entity.BankCredit;
import com.openapi.example.repository.BankCreditRepository;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class ServiceTaskDelegate implements JavaDelegate {
    private final BankCreditRepository bankCreditRepository;
    @Autowired
    public ServiceTaskDelegate(BankCreditRepository bankCreditRepository) {
        this.bankCreditRepository = bankCreditRepository;
    }
    @Override
    public void execute(DelegateExecution execution){
        try{
            double creditAmount = (double) execution.getVariable("creditAmount");
            String accountNumber = (String) execution.getVariable("accountNumber");
            BankCredit bankCredit = new BankCredit();
            bankCredit.setCreditAmount(creditAmount);
            bankCredit.setAccountNumber(accountNumber);
            bankCreditRepository.save(bankCredit);
        }catch(Exception ex){
            throw new RuntimeException("there is some issue in service task:"+ ex.getMessage(), ex);
        }
    }
}
