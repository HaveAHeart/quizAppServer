package models
import kotlinx.serialization.Serializable

@Serializable
data class AuthSuccess(val jwtToken: String)
