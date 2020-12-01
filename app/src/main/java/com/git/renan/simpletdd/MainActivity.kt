package com.git.renan.simpletdd

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.git.renan.simpletdd.baseActivity.BaseActivity

class MainActivity : BaseActivity() {
    lateinit var nameLabel: EditText
    lateinit var surnameLabel: EditText
    lateinit var ageLabel: EditText
    lateinit var textLabel: TextView

    var goNext: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()

        findViewById<Button>(R.id.button_ok).setOnClickListener(){
            textLabel.text = getResultText(nameLabel.text.toString(), surnameLabel.text.toString(), ageLabel.text.toString())

            if(!textLabel.text.equals("Informe todos os dados") && goNext){
                val bundle = Bundle()
                bundle.putString("name", textLabel.text.toString())

                navigate(this, ConfirmationActivity::class.java, bundle)
            }else if (!textLabel.text.equals("Informe todos os dados") && !goNext) {
                Toast.makeText(this, "Click mais uma vez para navegar", Toast.LENGTH_SHORT).show()
                goNext = true
            }
        }
    }

    fun initView(){
        nameLabel = findViewById(R.id.edit_user_name)
        surnameLabel = findViewById(R.id.edit_user_surname)
        ageLabel = findViewById(R.id.edit_user_age)
        textLabel = findViewById(R.id.result)
    }

    fun getResultText(name: String?, surname: String?, age: String?) : String{
        if(validText(name) && validText(surname) && validText(age)){
            return "$name $surname, $age anos"
        }
        goNext = false
        return "Informe todos os dados"
    }

}