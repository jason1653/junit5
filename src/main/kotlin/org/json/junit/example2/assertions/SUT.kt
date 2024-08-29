package org.json.junit.example2.assertions

data class SUT(
    val systemName: String,
    var isVerified: Boolean? = null,
    val jobs: List<Job>? = null,
    val currentJob: Job? = null
) {
    init {
        isVerified = false;
    }

    fun addJob(job: Job) {
        jobs?.toMutableList()?.add(job)

    }

}