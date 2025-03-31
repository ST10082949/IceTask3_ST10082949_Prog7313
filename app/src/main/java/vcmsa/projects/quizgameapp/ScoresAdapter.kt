package vcmsa.projects.quizgameapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import vcmsa.projects.quizgameapp.models.Score

class ScoresAdapter(private val scores: List<Score>) : RecyclerView.Adapter<ScoresAdapter.ScoreViewHolder>() {

    inner class ScoreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val usernameTextView: TextView = itemView.findViewById(R.id.usernameTextView)
        val scoreTextView: TextView = itemView.findViewById(R.id.scoreTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScoreViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_score, parent, false)
        return ScoreViewHolder(view)
    }

    override fun onBindViewHolder(holder: ScoreViewHolder, position: Int) {
        val scoreItem = scores[position]
        holder.usernameTextView.text = scoreItem.username
        holder.scoreTextView.text = "Score: ${scoreItem.score}/${scoreItem.totalQuestions}"
    }

    override fun getItemCount(): Int {
        return scores.size
    }
}