package models
import io.ktor.auth.*
import kotlinx.serialization.Serializable

@Serializable
data class AuthData(val login: String, val pwdHash: String) : Principal
