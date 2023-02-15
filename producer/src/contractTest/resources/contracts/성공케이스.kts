import org.springframework.cloud.contract.spec.ContractDsl.Companion.contract

contract {
    name = "값을 다 기입하면 성공을 반환한다"
    description = """
given:
request:
	name : test
    age : 10
    address : 렌딧
when:
	해당 api를 호출하면
then:
	성공한다
```
"""
    priority = 1
    ignored = false
    request {
        url = url("/test")
//        withQueryParameters  {
//            parameter("a", "b")
//            parameter("b", "c")
//        }
        method = POST
        headers {
            contentType = APPLICATION_JSON
        }
        body = body(mapOf(
            "age" to 11,
            "name" to "test",
            "address" to "렌딧"
        ))
    }
    response {
//        delay = fixedMilliseconds(1000)
        status = OK
        headers {
            contentType = APPLICATION_JSON
        }
        body = body(mapOf(
            "result" to "success"
        ))
        async = false
    }
}

