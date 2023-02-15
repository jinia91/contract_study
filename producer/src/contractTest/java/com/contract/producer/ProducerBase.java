package com.contract.producer;


import com.contract.producer.test.ContractTestController;
import io.restassured.module.mockmvc.RestAssuredMockMvc;

import org.junit.jupiter.api.BeforeEach;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;


@AutoConfigureMessageVerifier
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class ProducerBase {

    @Autowired
    private ContractTestController sut;

    @BeforeEach
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(sut);
    }
}