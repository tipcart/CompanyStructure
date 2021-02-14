package com.wywrot.companystructure

data class Person(
    val name: String, val age: Int, val employeeId: Long, val address: String,
    val currentReportsId: List<Long> = emptyList(), val currentBossId: Long? = null
)