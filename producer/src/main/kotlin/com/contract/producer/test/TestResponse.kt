package com.contract.producer.test

data class TestResponse(
   val result: String
) {
    companion object {
        fun success() = TestResponse("success")
        fun fail() = TestResponse("fail")
    }
}

