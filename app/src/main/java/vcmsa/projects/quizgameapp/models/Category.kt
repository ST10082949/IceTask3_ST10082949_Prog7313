package vcmsa.projects.quizgameapp.models

data class Category(
    val name: String,
    val questions: List<Question>
)