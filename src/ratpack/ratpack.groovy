import ratpack.handling.RequestLogger

import static ratpack.groovy.Groovy.ratpack

ratpack {
    handlers {
        all (RequestLogger.ncsa())
        get {
            render 'Hello, World From Groovy RatPack!'
        }
        get (":name") {
            render "Hello From Groovy Ratpack, $pathTokens.name!"
        }
    }
}

