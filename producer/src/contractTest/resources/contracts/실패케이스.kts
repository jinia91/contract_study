import org.springframework.cloud.contract.spec.ContractDsl.Companion.contract

contract {
    name = "name이 비면 실패를 반환한다"
    description = """
given:
request:
	name : null
    age : 10
    address : 렌딧
when:
	해당 api를 호출하면
then:
	실패한다
```
"""
    priority = 2
    ignored = false
    request {
        url = url("/test")
        method = POST
        headers {
            contentType = APPLICATION_JSON
        }
        body = body(mapOf(
            "age" to 11,
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

