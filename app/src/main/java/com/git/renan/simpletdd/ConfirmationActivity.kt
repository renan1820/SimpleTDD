package com.git.renan.simpletdd

import android.os.Bundle
import android.widget.TextView
import com.git.renan.simpletdd.baseActivity.BaseActivity

class ConfirmationActivity: BaseActivity() {
    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmation)
        intiView()

        if(intent != null && intent.hasExtra(EXTRA_ARGS)){
            val bundle: Bundle? = intent.extras?.getBundle(EXTRA_ARGS)

            if(bundle != null && !bundle.isEmpty){
                textView.text = bundle.getString("name")
            }
        }
    }

    fun intiView(){
        textView = findViewById(R.id.result_name)
    }
}