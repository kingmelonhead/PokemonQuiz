package com.example.finalproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AnswerAdapter(private val questionList : Array<Question>, private val answerList : Array<ResultContainer>):
    RecyclerView.Adapter<AnswerAdapter.QuestionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnswerAdapter.QuestionViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_entity,
            parent, false)
        return QuestionViewHolder(itemView)
    }
    override fun getItemCount() = questionList.size

    override fun onBindViewHolder(holder: QuestionViewHolder, i: Int) {
        val currentQuestion = questionList[i]
        val currentAnswer = answerList[i]
        holder.question.text = currentQuestion.question
        holder.answer.text = currentAnswer.answerText
        holder.bool.text = currentAnswer.correct
        holder.time.text = currentAnswer.time

    }

    class QuestionViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var question : TextView = itemView.findViewById(R.id.question)
        var answer : TextView = itemView.findViewById(R.id.response)
        var bool : TextView = itemView.findViewById(R.id.status)
        var time : TextView = itemView.findViewById(R.id.time)
    }
}