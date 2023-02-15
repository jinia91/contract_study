package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("""
given:
	무엇이든
when:
	해당 api를 호출하면
then:
	성공한다
```
""")
    request {
        method 'POST'
        url '/test'
        body(
                age: 10,
                name: "test",
                address: "렌딧"
        )
        headers {
            contentType(applicationJson())
        }
    }
    response {
        status 200
        body("""
			{
				"result": "success"
			}
			""")
        headers {
            contentType(applicationJson())
        }
    }
}