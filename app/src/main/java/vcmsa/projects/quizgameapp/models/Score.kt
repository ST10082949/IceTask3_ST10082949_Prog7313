package vcmsa.projects.quizgameapp.models

data class Score(
    val username: String = "",
    val score: Int = 0,
    val totalQuestions: Int = 0,
    val timestamp: Long = 0
)