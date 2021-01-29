package com.briannur_18104006.commerc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import com.briannur_18104006.commerc.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignUpActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCreateAccount.setOnClickListener(this)
        binding.tvLogin.setOnClickListener(this)

        auth = Firebase.auth
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnCreateAccount -> {
                createAccount(binding.regisEmail.text.toString(), binding.regisPass.text.toString())
            }
            R.id.tvLogin -> {
                val intent = Intent(this@SignUpActivity, SignInActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun createAccount(email: String, password: String) {
        if (!validateForm()) {
            return
        }
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this) { task ->
            if (task.isSuccessful) {
                Toast.makeText(baseContext, "Create User Success.", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(baseContext, "Authentication failed.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validateForm(): Boolean {
        var valid = true

        val email = binding.regisEmail.text.toString()
        if (TextUtils.isEmpty(email)) {
            binding.regisEmail.error = "Required."
            valid = false
        } else {
            binding.regisEmail.error = null
        }

        val password = binding.regisPass.text.toString()
        if (TextUtils.isEmpty(password)) {
            binding.regisPass.error = "Required."
            valid = false
        } else {
            binding.regisPass.error = null
        }

        val confirm = binding.confirmPass.text.toString()
        if (TextUtils.isEmpty(confirm)) {
            binding.confirmPass.error = "Required."
        } else if (!password.equals(confirm)){
            binding.confirmPass.error = "Not match."
        } else {
            binding.confirmPass.error = null
        }
        return valid
    }
}