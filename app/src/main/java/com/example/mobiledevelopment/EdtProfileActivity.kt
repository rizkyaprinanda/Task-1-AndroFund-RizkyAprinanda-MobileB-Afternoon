package com.example.mobiledevelopment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class EdtProfileActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var etName: EditText
    private lateinit var etEmail: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edt_profile)

        etName = findViewById(R.id.etName)
        etEmail = findViewById(R.id.etEmail)

        val bundle = intent.extras
        if(bundle != null) {
            etName.setText(bundle.getString("nama"))
            etEmail.setText(bundle.getString("email"))
        }

        val btnSave: Button = findViewById(R.id.btn_save)
        btnSave.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.btn_save -> {
                val intent = Intent(this@EdtProfileActivity, ProfileActivity::class.java)
                intent.putExtra("Profile", Profile(etName.text.toString(), etEmail.text.toString()))
                startActivity(intent)
            }
        }
    }
}