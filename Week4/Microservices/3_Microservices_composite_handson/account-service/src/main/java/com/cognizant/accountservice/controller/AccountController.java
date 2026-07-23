package com.cognizant.accountservice.controller;

import com.cognizant.accountservice.model.Account;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @GetMapping("/accounts/{number}")
    public Account getAccount(@PathVariable String number) {

        return new Account(
                number,
                "Savings",
                50000.00
        );
    }
}