package com.example.iglocal

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.iglocal.databinding.ActivityEditProfileBinding

class EditProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val currentName = intent.getStringExtra(MainActivity.EXTRA_NAME)
        val currentBio = intent.getStringExtra(MainActivity.EXTRA_BIO)

        binding.edtName.setText(currentName)
        binding.edtBio.setText(currentBio)

        binding.btnSave.setOnClickListener {
            val resultIntent = Intent()
            resultIntent.putExtra(MainActivity.EXTRA_NAME, binding.edtName.text.toString())
            resultIntent.putExtra(MainActivity.EXTRA_BIO, binding.edtBio.text.toString())
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}