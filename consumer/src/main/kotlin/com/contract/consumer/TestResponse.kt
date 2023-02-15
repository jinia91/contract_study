package com.contract.consumer

data class TestResponse(
   val result: String
) {
    companion object {
        fun build() = TestResponse("success")
    }
}

