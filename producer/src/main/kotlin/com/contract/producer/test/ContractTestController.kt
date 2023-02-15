package com.contract.producer.test

import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ContractTestController {
    @PostMapping("/test")
    fun foo(@RequestBody request: TestRequest): TestResponse {
        return if (isValid(request)) TestResponse.success()
            else TestResponse.fail()
    }

    private fun isValid(request: TestRequest): Boolean = with(request) {
        (name != null) and (age != null) and (address != null)
    }

}