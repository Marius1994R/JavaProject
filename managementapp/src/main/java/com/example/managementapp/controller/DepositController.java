package com.example.managementapp.controller;

import com.example.managementapp.entity.DepositModel;
import com.example.managementapp.service.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DepositController {

    @Autowired
    private DepositService depositService;

    @GetMapping("viewDeposits")
    public String viewDeposits(Model model) {

        List<DepositModel> depositModelList = depositService.getDeposits();
        model.addAttribute("deposits", depositModelList);
        return  "deposits";
    }


    @GetMapping("addDeposit")
    public String addDeposit(Model model) {

        model.addAttribute("deposit", new DepositModel());
        return "addDeposit";
    }

    @PostMapping("add-new-deposit")
    public String addNewDepartment (DepositModel depositModel) {
        depositService.addDeposit(depositModel);
        return "redirect:/viewDeposits";

    }
//
//    @GetMapping("edit-deposit/{depositId}")
//    public String editDepositPage (@PathVariable("depositId") int depositID, Model model) throws DepositNotFound {
//        DepositModel depositModel = depositService.getDeposits(depositID);
//
//        List<DepositModel> deposit = depositService.getDeposits();
//        model.addAttribute("deposits", deposit);
//
//        return "edit-deposit";
//    }
//
//    @PostMapping("edit-new-deposit")
//    public String editDeposit(DepositModel depositModel) throws DepositNotFound {
//
//        depositService.updateDeposit(depositModel);
//        return "redirect:/viewDeposits";
//    }

}
