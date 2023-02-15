package com.contract.consumer

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock

@SpringBootTest
@AutoConfigureWireMock
@AutoConfigureStubRunner(
    stubsMode = StubRunnerProperties.StubsMode.LOCAL, // Remote로 넥서스 등의 외부 dir 에서 stub 가져오기도 가능!
    ids = ["com.contract:producer:+:stubs:8085"]
)
internal class TestControllerTest {
    @Autowired
    lateinit var sut: TestClient

    @Test
    fun `호출하면 성공한다`() {
        //given
        val input = TestRequest("test", 10, "렌딧")

        //when
        val call = sut.call(input)

        //then
        Assertions.assertThat(call.result).isEqualTo("success")
    }

}