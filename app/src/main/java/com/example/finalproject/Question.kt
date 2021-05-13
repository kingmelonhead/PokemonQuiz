package com.example.finalproject

data class Question(val question : String, val options : Array<String>, val correctAns : Int) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Question

        if (question != other.question) return false
        if (!options.contentEquals(other.options)) return false
        if (correctAns != other.correctAns) return false

        return true
    }

    override fun hashCode(): Int {
        var result = question.hashCode()
        result = 31 * result + options.contentHashCode()
        result = 31 * result + correctAns
        return result
    }
}