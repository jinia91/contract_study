package com.contract.consumer

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component
import retrofit2.Call
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

@Component
class TestClient(
    private val testApi: TestApi
) {
    fun call(input : TestRequest): TestResponse {
        return testApi.foo(input).execute().body()!!
    }
}

interface TestApi {
    @POST("/test")
    fun foo(
        @Body request: TestRequest
    ): Call<TestResponse>
}

@Configuration
class RetrofitConfig {
    @Bean
    fun testApi(): TestApi {
        return Retrofit.Builder()
            .baseUrl("http://localhost:8085")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TestApi::class.java)
    }
}
