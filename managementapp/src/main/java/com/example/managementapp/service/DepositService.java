package com.example.managementapp.service;

import ch.qos.logback.core.pattern.parser.OptionTokenizer;
import com.example.managementapp.controller.DepositNotFound;
import com.example.managementapp.dao.DepositRepository;
import com.example.managementapp.entity.DepositModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DepositService {

    @Autowired
    private DepositRepository depositRepository;

    public void addDeposit(DepositModel depositModel) {
        depositRepository.save(depositModel);
    }

    public void removeDeposit(int id) {
        depositRepository.deleteById(id);
    }
    public void removeDeposit(String name) {
        depositRepository.deleteDepositByName(name);
    }

    public List<DepositModel> getDeposits() {
        return depositRepository.findAll();
    }


    public DepositModel getDeposits(int depositID) throws DepositNotFound {
        Optional<DepositModel> optionalDepositModel = depositRepository.findById(depositID);
        if (optionalDepositModel.isEmpty()) {
            throw new DepositNotFound("Deposit with id:" + depositID + "doesn't exist");
        }
        DepositModel depositModel = optionalDepositModel.get();

        return depositModel;
    }

    public void updateDeposit(DepositModel modifiedDeposit) throws DepositNotFound {

        DepositModel depositModel1 = getDeposits(modifiedDeposit.getId());

        depositModel1.setId(modifiedDeposit.getId());
        depositModel1.setName(modifiedDeposit.getName());

        depositRepository.save(modifiedDeposit);



    }
}
