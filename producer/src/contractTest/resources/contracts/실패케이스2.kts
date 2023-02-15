import org.springframework.cloud.contract.spec.ContractDsl.Companion.contract


contract {
    name = "age가 비면 실패를 반환한다"
    description = """
given:
request:
	name : test
    age : null
    address : 렌딧
when:
	해당 api를 호출하면
then:
	실패한다
```
"""
    priority = 3
    ignored = false
    request {
        url = url("/test")
        method = POST
        headers {
            contentType = APPLICATION_JSON
        }
        body = body(mapOf(
            "name" to "test",
            "address" to "렌딧"
        ))
    }
    response {
        status = OK
        headers {
            contentType = APPLICATION_JSON
        }
        body = body(mapOf(
            "result" to "fail"
        ))
        async = false
    }
}

