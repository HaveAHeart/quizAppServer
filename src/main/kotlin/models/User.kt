package models
import kotlinx.serialization.Serializable

@Serializable
data class User(val id: Int, val login: String, val lastTestId: Int, val lastResult: Int)
