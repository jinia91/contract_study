package com.contract.producer.test

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ContractTestController {
    @PostMapping("/test")
    fun foo(request : TestRequest): TestResponse {
        return TestResponse.build()
    }
}