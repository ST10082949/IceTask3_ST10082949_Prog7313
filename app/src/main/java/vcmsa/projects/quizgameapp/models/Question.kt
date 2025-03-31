package vcmsa.projects.quizgameapp.models

data class Question(
    val text: String,
    val options: List<String>,
    val answerIndex: Int
)