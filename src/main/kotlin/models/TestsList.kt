package models
import kotlinx.serialization.Serializable

@Serializable
data class TestsList(val testsList: List<Test>)
