package vcmsa.projects.quizgameapp

import vcmsa.projects.quizgameapp.models.Question

interface QuestionGenerator {
    fun generateScienceQuestions(): List<Question>
    fun generateHistoryQuestions(): List<Question>
    fun generateGeographyQuestions(): List<Question>
    fun generateSportsQuestions(): List<Question>
}