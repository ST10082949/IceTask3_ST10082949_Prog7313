package vcmsa.projects.quizgameapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import vcmsa.projects.quizgameapp.models.Score

class ResultsActivity : AppCompatActivity() {
    private lateinit var scoreTextView: TextView
    private lateinit var usernameTextView: TextView
    private lateinit var totalQuestionsTextView: TextView
    private lateinit var retryButton: Button
    private lateinit var scoresRecyclerView: RecyclerView
    private lateinit var scoresAdapter: ScoresAdapter
    private lateinit var db: FirebaseFirestore
    private val scoresList = mutableListOf<Score>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)

        // Initialize UI Components
        scoreTextView = findViewById(R.id.scoreTextView)
        usernameTextView = findViewById(R.id.usernameTextView)
        totalQuestionsTextView = findViewById(R.id.totalQuestionsTextView)
        retryButton = findViewById(R.id.retryButton)

        // Initialize RecyclerView
        scoresRecyclerView = findViewById(R.id.scoresRecyclerView)
        scoresRecyclerView.layoutManager = LinearLayoutManager(this)

        // Initialize Firestore
        db = FirebaseFirestore.getInstance()

        // Get data from Intent
        val score = intent.getIntExtra("SCORE", 0)
        val username = intent.getStringExtra("USERNAME") ?: "Guest"
        val totalQuestions = intent.getIntExtra("TOTAL_QUESTIONS", 0)

        // Display the score
        scoreTextView.text = "Score: $score/$totalQuestions"
        usernameTextView.text = "User: $username"
        totalQuestionsTextView.text = "Total Questions: $totalQuestions"

        // Load historical scores
        loadHistoricalScores()

        // Retry button action
        retryButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun loadHistoricalScores() {
        db.collection("scores")
            .get()
            .addOnSuccessListener { result ->
                scoresList.clear() // Clear current list
                for (document in result) {
                    val scoreItem = document.toObject(Score::class.java)
                    scoresList.add(scoreItem)
                }

                // Initialize and notify the adapter with the scores
                scoresAdapter = ScoresAdapter(scoresList)
                scoresRecyclerView.adapter = scoresAdapter
                scoresAdapter.notifyDataSetChanged() // Notify adapter to refresh the list
            }
            .addOnFailureListener { e ->
                // Handle the error here
            }
    }
}