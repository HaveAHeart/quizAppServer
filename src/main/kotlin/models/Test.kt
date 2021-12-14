package models
import kotlinx.serialization.Serializable

@Serializable
data class Test(val id: Int, val name: String, val desc: String)
