import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.auth.jwt.*
import io.ktor.features.*
import io.ktor.routing.*
import io.ktor.serialization.*
import models.AuthData

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {
    install(ContentNegotiation) {
        json()
    }
    install(Authentication) {
        jwt("auth-jws") {
            //other algos require more than one secret key
            verifier(JWT.require(Algorithm.HMAC256("Here is the secret")).build())
            validate { jwtCredential ->
                val login = jwtCredential.payload.getClaim("login").asString()
                val pwdHash = jwtCredential.payload.getClaim("pwdHash").asString()
                //TODO null check
                AuthData(login, pwdHash)
            }
        }
    }

    registerRoutes()
}