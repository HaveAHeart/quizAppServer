package models
import kotlinx.serialization.Serializable

@Serializable
data class Question(val id: Int, val testId: Int, val value: Int, val questionText: String,
                    val var1: String, val var2: String, val var3: String, val var4: String, val answer: Int)
