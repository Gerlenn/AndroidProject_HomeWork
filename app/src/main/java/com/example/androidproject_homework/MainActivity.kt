package com.example.androidproject_homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layoutName = findViewById<TextInputLayout>(R.id.layoutName)
        val layoutPassword = findViewById<TextInputLayout>(R.id.layoutPassword)

        val etName = findViewById<EditText>(R.id.etName)
        val etPassword = findViewById<EditText>(R.id.etPassword)

        val btn = findViewById<Button>(R.id.btnEnter)

        val dialog = AlertDialog.Builder(this)
            .setTitle(getString(R.string.info))
            .setCancelable(false)
            .setPositiveButton(getString(R.string.btn_pos_ok)) { dialog, _ ->
                Toast.makeText(this, getString(R.string.pos_message), Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton(getString(R.string.btn_negative)) { dialog, _ ->
                dialog.cancel()
            }

        btn.setOnClickListener {
            if (etName.text.toString().isEmpty() || etName.length() > 20) {
                layoutName.setErrorIconDrawable(R.drawable.ic_warning)
                etName.error = getString(R.string.errorName)
            } else if (etPassword.text.toString().isEmpty() || etPassword.length() > 20) {
                layoutPassword.setErrorIconDrawable(R.drawable.ic_warning)
                etPassword.error = getString(R.string.errorPassword)
            } else
                dialog.setMessage("Name: " + etName.text.toString()
                        + "\nPassword: " + etPassword.text.toString()).show()
        }
    }
}