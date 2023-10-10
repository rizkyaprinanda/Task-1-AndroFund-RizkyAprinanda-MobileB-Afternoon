package com.example.mobiledevelopment

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import com.example.mobiledevelopment.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var tv: TextView
    private lateinit var tv2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        val fragment1Button = findViewById<Button>(R.id.fragment1)

        fragment1Button.setOnClickListener{
            val fragment = Fragment_1()

            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()

            fragmentTransaction.replace(R.id.fragment_container,fragment )
            fragmentTransaction.commit()
        }

        tv = findViewById(R.id.textView1)
        val name = intent.getParcelableExtra<Profile>("Profile")?.fullname
        val email = intent.getParcelableExtra<Profile>("Profile")?.email


            tv.text = "Nama anda $name dan email anda $email"

//

            tv2 = findViewById(R.id.textView2)
            val username = intent.getParcelableExtra<User>("User")?.username
            val password = intent.getParcelableExtra<User>("User")?.password
            tv2.text = "Selamat datang $username dan password $password"



        val btnLogout : Button = findViewById(R.id.btn_logout)
        btnLogout.setOnClickListener(this)

        val btnProfile : Button = findViewById(R.id.btn_profile)
        btnProfile.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when (v.id){
            R.id.btn_logout -> {
                val intent = Intent(this@MainActivity, LoginActivity::class.java)
                intent.putExtra("history", "Anda Sudah Logout")
                setResult(Activity.RESULT_OK, intent)
                finish()
            }


            R.id.btn_profile -> {
                val intent2 = Intent(this@MainActivity, ProfileActivity::class.java)
                startActivity(intent2)
            }

        }
    }


//    override fun onClick(v: View) {
//        when (v.id) {
//            R.id.btn_implicit -> {
////                val message = "Halo tes"
////                val intent = Intent()
////                intent.action = Intent.ACTION_SEND
////                intent.putExtra(Intent.EXTRA_TEXT, message)
////                intent.type = "text/plain"
////                startActivity(intent)
//
//                val intent = Intent()
//                intent.putExtra("History", "Anda sudah login")
//                setResult(RESULT_OK, intent)
//                finish()
//            }
//        }
//    }
}