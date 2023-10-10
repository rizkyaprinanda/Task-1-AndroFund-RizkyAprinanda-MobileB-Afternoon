package com.example.mobiledevelopment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class ProfileActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var etName: TextView
    private lateinit var etEmail: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        etName = findViewById(R.id.etName)
        etEmail = findViewById(R.id.etEmail)

        val bundle = intent.extras
        if(bundle != null) {
            etName.setText(bundle.getString("nama"))
            etEmail.setText(bundle.getString("email"))

            val name = intent.getParcelableExtra<Profile>("Profile")?.fullname
            val email = intent.getParcelableExtra<Profile>("Profile")?.email

            etName.text = name
            etEmail.text = email



        }



        val btnEdit: Button = findViewById(R.id.btn_edtProfile)
        btnEdit.setOnClickListener(this)

        val btnBack: Button = findViewById(R.id.btn_back)
        btnBack.setOnClickListener(this)


    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.btn_edtProfile -> {
                val intent = Intent(this@ProfileActivity, EdtProfileActivity::class.java)
                startActivity(intent)
            }

            R.id.btn_back -> {
                val intent2 = Intent(this@ProfileActivity, MainActivity::class.java)
                intent2.putExtra("Profile", Profile(etName.text.toString(), etEmail.text.toString()))
                startActivity(intent2)
            }
        }
    }
}