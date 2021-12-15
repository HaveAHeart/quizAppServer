package models
import kotlinx.serialization.Serializable

@Serializable
data class Answers(val answers: List<String>, val testId: Int)
