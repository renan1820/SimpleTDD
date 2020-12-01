package com.git.renan.simpletdd.baseActivity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity: AppCompatActivity() {
    val EXTRA_ARGS: String = "EXTRA"

    fun validText(text: String?): Boolean{
        return text != null && text.isNotEmpty()
    }

    fun <T> navigate(context: Context, activity: Class<T>){
        this.navigate(context, activity, null)
    }

    fun <T> navigate(context: Context, activity: Class<T>, args: Bundle?){
        val intent = Intent(context, activity)
        if (args != null) {
            if(!args.isEmpty){
                intent.putExtra(EXTRA_ARGS, args)
            }
        }
        startActivity(intent)
    }

}