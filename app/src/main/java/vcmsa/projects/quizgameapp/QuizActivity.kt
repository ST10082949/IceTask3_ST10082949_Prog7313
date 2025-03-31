package vcmsa.projects.quizgameapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import vcmsa.projects.quizgameapp.models.Question
import vcmsa.projects.quizgameapp.models.Score

class QuizActivity : AppCompatActivity() {

    private lateinit var questions: List<Question>
    private var questionIndex = 0
    private var score = 0
    private lateinit var username: String
    private lateinit var db: FirebaseFirestore // Firestore instance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        // Initialize Firestore
        db = FirebaseFirestore.getInstance()

        // Retrieve data from intent
        val categoryIndex = intent.getIntExtra("CATEGORY_INDEX", -1)
        username = intent.getStringExtra("USERNAME") ?: "Guest"

        // Check if categoryIndex is valid
        if (categoryIndex == -1) {
            Toast.makeText(this, "Invalid category", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        // Load questions based on the category index
        questions = getQuestionsForCategory(categoryIndex)

        // Set up the UI
        displayQuestion()

        // Answer button click listeners
        findViewById<Button>(R.id.btnAnswer1).setOnClickListener { checkAnswer(0) }
        findViewById<Button>(R.id.btnAnswer2).setOnClickListener { checkAnswer(1) }
        findViewById<Button>(R.id.btnAnswer3).setOnClickListener { checkAnswer(2) }
        findViewById<Button>(R.id.btnAnswer4).setOnClickListener { checkAnswer(3) }
    }

    private fun getQuestionsForCategory(index: Int): List<Question> {
        return when (index) {
            0 -> QuestionGeneratorImpl().generateScienceQuestions()
            1 -> QuestionGeneratorImpl().generateHistoryQuestions()
            2 -> QuestionGeneratorImpl().generateGeographyQuestions()
            3 -> QuestionGeneratorImpl().generateSportsQuestions()
            else -> emptyList()
        }
    }

    private fun displayQuestion() {
        if (questionIndex < questions.size) {
            val question = questions[questionIndex]
            findViewById<TextView>(R.id.questionTextView).text = question.text
            findViewById<Button>(R.id.btnAnswer1).text = question.options[0]
            findViewById<Button>(R.id.btnAnswer2).text = question.options[1]
            findViewById<Button>(R.id.btnAnswer3).text = question.options[2]
            findViewById<Button>(R.id.btnAnswer4).text = question.options[3]
        } else {
            // Show results if no more questions
            saveScoreToFirestore()
        }
    }

    private fun checkAnswer(selectedIndex: Int) {
        if (selectedIndex == questions[questionIndex].answerIndex) {
            score++
        }
        questionIndex++
        displayQuestion()
    }

    private fun saveScoreToFirestore() {
        val scoreData = Score(username, score, questions.size)

        db.collection("scores").add(scoreData)
            .addOnSuccessListener {
                showResults()
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Error saving score: ${e.message}", Toast.LENGTH_SHORT).show()
                showResults()
            }
    }

    private fun showResults() {
        val intent = Intent(this, ResultsActivity::class.java).apply {
            putExtra("SCORE", score)
            putExtra("USERNAME", username)
            putExtra("TOTAL_QUESTIONS", questions.size)
        }
        startActivity(intent)
        finish()
    }
}