package com.wywrot.companystructure

object Utils {

    fun getEmployees(): List<Person> {
        val boss = Person(
            "John", 45, IdGenerator.bossId,
            "Blue Street, 23", listOf(1, 2, 3, 4), null
        )
        val mary = Person(
            "Mary", 30, IdGenerator.getNextUniqueId(),
            "White Street, 34", listOf(5, 6), IdGenerator.bossId
        )
        val anna = Person(
            "Anna", 24, IdGenerator.getNextUniqueId(),
            "Orange Street, 34", currentBossId = IdGenerator.bossId
        )
        val peter = Person(
            "Peter", 55, IdGenerator.getNextUniqueId(),
            "White Street, 5", currentBossId = IdGenerator.bossId
        )
        val michael = Person(
            "Michael", 22, IdGenerator.getNextUniqueId(),
            "White Street, 89", currentBossId = IdGenerator.bossId
        )
        val sam = Person(
            "Sam", 53, IdGenerator.getNextUniqueId(),
            "Long Street, 89", currentBossId = IdGenerator.bossId
        )
        val will = Person(
            "Will", 43, IdGenerator.getNextUniqueId(),
            "Long Street, 33", currentBossId = IdGenerator.bossId
        )
        val anotherWill = Person(
            "Will", 20, IdGenerator.getNextUniqueId(),
            "White Street, 3", currentBossId = IdGenerator.bossId
        )
        return listOf(boss, mary, anna, peter, michael, sam, will)
    }
}