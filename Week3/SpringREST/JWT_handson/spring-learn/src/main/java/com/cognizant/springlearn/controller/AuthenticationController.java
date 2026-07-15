package com.cognizant.springlearn.controller;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        LOGGER.info("Start");
        LOGGER.debug(authHeader);

        String user = getUser(authHeader);

        Map<String, String> map = new HashMap<String, String>();
        map.put("token", "");

        LOGGER.info("End");
        return map;
    }

    private String getUser(String authHeader) {
        LOGGER.debug("Start getUser");

        String encodedCredentials = authHeader.replace("Basic ", "");
        byte[] decodedBytes = Base64.getDecoder().decode(encodedCredentials);
        String decodedString = new String(decodedBytes);
        String user = decodedString.substring(0, decodedString.indexOf(":"));

        LOGGER.debug("user: {}", user);
        LOGGER.debug("End getUser");
        return user;
    }

}
