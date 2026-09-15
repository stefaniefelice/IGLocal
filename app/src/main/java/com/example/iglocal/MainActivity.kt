package com.example.iglocal

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.iglocal.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_BIO = "extra_bio"
    }

    private val editProfileLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val data = result.data
                val newName = data?.getStringExtra(EXTRA_NAME)
                val newBio = data?.getStringExtra(EXTRA_BIO)

                binding.tvUsername.text = newName
                binding.tvBio.text = newBio
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEdit.setOnClickListener {
            val intent = Intent(this, EditProfileActivity::class.java)
            intent.putExtra(EXTRA_NAME, binding.tvUsername.text.toString())
            intent.putExtra(EXTRA_BIO, binding.tvBio.text.toString())
            editProfileLauncher.launch(intent)
        }

        binding.ivAvatar.setOnClickListener {
            val intent = Intent(this, PhotoDetailActivity::class.java)
            intent.putExtra(EXTRA_NAME, binding.tvUsername.text.toString())
            startActivity(intent)
        }
    }
}