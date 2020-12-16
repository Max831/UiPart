package com.example.uipart1

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var editText: EditText? = null
    private var textView: TextView? = null
    private var button: Button? = null
    private var name: String? = null
    val NAME_KEY = "com.example.uipart1.MainActivity.NAME_KEY"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState?.getString(NAME_KEY) != null) {
            name = savedInstanceState.getString(NAME_KEY)
        } else {
            name = textView?.text.toString()
        }

        editText = findViewById(R.id.editTextTextPersonName)
        textView = findViewById(R.id.textView)
        button = findViewById(R.id.button)

        editText?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                // Nothing to do
            }

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                // Nothing to do
            }

            override fun afterTextChanged(editable: Editable) {
                button?.isEnabled = !TextUtils.isEmpty(editable)
            }
        })

        button?.setOnClickListener {
            val intent = Intent()
            intent.putExtra(NAME_KEY, editText?.text.toString())
            setResult(RESULT_OK, intent)
            name = editText?.text.toString()
            textView?.text = editText?.text.toString()
        }
    }

    override fun onResume() {
        super.onResume()
        if (name == null || name.equals("null")) {
            name = textView?.text.toString()
        }
        textView?.text = name
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(NAME_KEY, name)
    }

}