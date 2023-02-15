package com.contract.producer.test

data class TestResponse(
   val result: String
) {
    companion object {
        fun build() = TestResponse("success")
    }
}

