package com.wywrot.companystructure

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.core.view.MenuItemCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val application = BaseApplication.instance
    private lateinit var adapter: EmployeeItemAdapter
    private lateinit var searchView: SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        setUpViews()
    }

    private fun setUpViews() {
        supportActionBar?.title = getString(R.string.employees)

        rvEmployees.layoutManager = LinearLayoutManager(this)
        fillAdapterByNewData(application.getAllEmployees())

        fabAddEmployee.setOnClickListener {
            startActivity(Intent(this, AddEmployeeActivity::class.java))
        }
    }

    private fun fillAdapterByNewData(employees: ArrayList<Person>) {
        adapter = EmployeeItemAdapter(employees)
        rvEmployees.addItemDecoration(
            DividerItemDecoration(
                rvEmployees.context,
                (rvEmployees.layoutManager as LinearLayoutManager).orientation
            )
        )
        rvEmployees.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.search_menu, menu)

        val searchItem: MenuItem = menu.findItem(R.id.action_search)
        searchView = MenuItemCompat.getActionView(searchItem) as SearchView
        searchView.setOnCloseListener { true }

        bindSearchPlate()
        bindSearchPlateView()
        setOnQueryTestListener()

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        return super.onCreateOptionsMenu(menu)
    }

    private fun bindSearchPlateView() {
        val searchPlateView: View = searchView.findViewById(androidx.appcompat.R.id.search_plate)
        searchPlateView.setBackgroundColor(
            ContextCompat.getColor(
                this,
                android.R.color.transparent
            )
        )
    }

    private fun bindSearchPlate() {
        val searchPlate =
            searchView.findViewById(androidx.appcompat.R.id.search_src_text) as EditText
        searchPlate.hint = getString(R.string.search)
    }

    private fun setOnQueryTestListener() {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                val employees = application.getEmployeeByName(query ?: "")
                if (employees != null) {
                    fillAdapterByNewData(employees)
                } else {
                    fillAdapterByNewData(arrayListOf())
                    Toast.makeText(
                        applicationContext, getString(R.string.empty_employees_list),
                        Toast.LENGTH_LONG
                    ).show()
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
    }

    override fun onBackPressed() {
        if (!searchView.isIconified) searchView.onActionViewCollapsed()
        else super.onBackPressed()
    }
}