package com.wywrot.companystructure

object IdGenerator {
    const val bossId = -1L
    private var id = 0L

    @Synchronized
    fun getNextUniqueId(): Long {
        id += 1
        return id
    }
}