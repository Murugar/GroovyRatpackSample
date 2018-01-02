import ratpack.groovy.test.GroovyRatpackMainApplicationUnderTest
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class HelloWorldSpec extends Specification {

    @AutoCleanup
    @Shared
    GroovyRatpackMainApplicationUnderTest systemUnderTest = new GroovyRatpackMainApplicationUnderTest()

    def 'Should render \'Hello, World!\''() {
        expect:
            systemUnderTest.httpClient.text == 'Hello, World From Groovy RatPack!'
    }

    @Unroll
    def 'Should render \'Hello, #output!\''() {
        expect:
            systemUnderTest.httpClient.getText(path) == "Hello From Groovy Ratpack, $output!"

        where:
            path                |   output
            'Test1'             |   'Test1'
            'Test2'             |   'Test2'
            'Test1%20Test2'     |   'Test1 Test2'
    }
}
