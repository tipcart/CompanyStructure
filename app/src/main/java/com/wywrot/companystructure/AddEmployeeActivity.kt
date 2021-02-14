package com.wywrot.companystructure

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add_employee.*

class AddEmployeeActivity : AppCompatActivity() {

    private val application = BaseApplication.instance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_employee)
        setUpViews()
    }

    private fun setUpViews() {
        supportActionBar?.title = getString(R.string.add_employee)

        btnAddEmployee.setOnClickListener {
            if (fieldsAreNotEmpty()) {
                application.addEmployee(createNewPerson())
                finish()
            } else {
                Toast.makeText(
                    this, getString(R.string.all_fields_mandatory),
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    /**
     * During creating new employee, we should know list of current reports ids and current boss id.
     * To set this, there should be 2 drop down lists, with all employees displayed.
     * Because lack of this, we are setting empty list as reports and main boss as current boss.
     */
    private fun createNewPerson() = Person(
        tietName.text.toString(),
        tietAge.text.toString().toInt(),
        IdGenerator.getNextUniqueId(),
        tietAddress.text.toString(),
        emptyList(),
        IdGenerator.bossId
    )

    private fun fieldsAreNotEmpty() =
        (tietName.text?.isNotEmpty() ?: false)
                && (tietAge.text?.isNotEmpty() ?: false)
                && (tietAddress.text?.isNotEmpty() ?: false)
}