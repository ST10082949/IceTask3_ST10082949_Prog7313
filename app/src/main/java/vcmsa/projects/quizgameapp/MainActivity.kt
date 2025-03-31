package vcmsa.projects.quizgameapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import vcmsa.projects.quizgameapp.models.Category

class MainActivity : AppCompatActivity() {

    private val questionGenerator: QuestionGenerator = QuestionGeneratorImpl()
    private lateinit var categories: List<Category>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize categories and questions
        categories = listOf(
            Category("Science", questionGenerator.generateScienceQuestions()),
            Category("History", questionGenerator.generateHistoryQuestions()),
            Category("Geography", questionGenerator.generateGeographyQuestions()),
            Category("Sports", questionGenerator.generateSportsQuestions())
        )

        // Set up click listeners for the category buttons
        findViewById<Button>(R.id.btnCategory1).setOnClickListener { showUsernameInput(0) }
        findViewById<Button>(R.id.btnCategory2).setOnClickListener { showUsernameInput(1) }
        findViewById<Button>(R.id.btnCategory3).setOnClickListener { showUsernameInput(2) }
        findViewById<Button>(R.id.btnCategory4).setOnClickListener { showUsernameInput(3) }
    }

    private fun showUsernameInput(categoryIndex: Int) {
        val builder = AlertDialog.Builder(this)
        val input = EditText(this)
        builder.setTitle("Enter your username")
        builder.setView(input)

        builder.setPositiveButton("OK") { dialog, _ ->
            val username = input.text.toString()
            if (username.isNotEmpty()) {
                startQuizActivity(categoryIndex, username)
                dialog.dismiss()
            } else {
                input.error = "Username cannot be empty"
            }
        }

        builder.setNegativeButton("Cancel") { dialog, _ -> dialog.cancel() }
        builder.show()
    }

    private fun startQuizActivity(categoryIndex: Int, username: String) {
        val intent = Intent(this, QuizActivity::class.java).apply {
            putExtra("CATEGORY_INDEX", categoryIndex)
            putExtra("USERNAME", username)
        }
        startActivity(intent)
    }
}