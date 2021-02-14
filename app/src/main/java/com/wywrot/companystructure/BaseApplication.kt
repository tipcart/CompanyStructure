package com.wywrot.companystructure

import android.app.Application
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class BaseApplication : Application() {
    private val companyStructure: HashMap<String, ArrayList<Person>> = HashMap()

    companion object {
        lateinit var instance: BaseApplication
    }

    override fun onCreate() {
        super.onCreate()
        getExistCompanyStructure()
        instance = this
    }

    fun addEmployee(person: Person) {
        val list: ArrayList<Person>
        if (companyStructure.containsKey(person.name.toUpperCase(Locale.ROOT))) {
            // if the key exists - get the array list and add the value to it
            list = companyStructure[person.name.toUpperCase(Locale.ROOT)]!!
            list.add(person)
        } else {
            // if the key doesn't exist - create a new ArrayList, add the value and put it in the array list with the new key
            list = ArrayList()
            list.add(person)
            companyStructure[person.name.toUpperCase(Locale.ROOT)] = list
        }
    }

    fun getEmployeeByName(name: String) = companyStructure[name.toUpperCase(Locale.ROOT)]

    fun getAllEmployees(): ArrayList<Person> {
        val list = mutableListOf<Person>()
        companyStructure.keys.forEach {
            companyStructure[it]?.let { it1 -> list.addAll(it1) }
        }
        return list as ArrayList<Person>
    }

    private fun getExistCompanyStructure() {
        Utils.getEmployees().forEach {
            addEmployee(it)
        }
    }
}