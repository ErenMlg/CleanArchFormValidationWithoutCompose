package com.example.validation.presentation

import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.lifecycleScope
import com.example.validation.R
import com.example.validation.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        lifecycleScope.launch {
            viewModel.state.collect {
                binding.textInputLayout.isErrorEnabled = it.emailError != null
                binding.textInputLayout.error = it.emailError
                binding.textInputLayout2.isErrorEnabled = it.passwordError != null
                binding.textInputLayout2.error = it.passwordError
                binding.textInputLayout3.isErrorEnabled = it.passwordRepeatError != null
                binding.textInputLayout3.error = it.passwordRepeatError
                binding.terms.error = it.termsError
            }
        }
        binding.email.doOnTextChanged { text, _, _, _ ->
            viewModel.onEvent(RegistrationFormEvent.EmailChanged(text.toString()))
        }

        binding.sifre.doOnTextChanged { text, _, _, _ ->
            viewModel.onEvent(RegistrationFormEvent.PasswordChanged(text.toString()))
        }

        binding.sifreTekrar.doOnTextChanged { text, _, _, _ ->
            viewModel.onEvent(RegistrationFormEvent.RepeatedPasswordChanged(text.toString()))
        }

        binding.terms.setOnCheckedChangeListener { _, isChecked ->
            viewModel.onEvent(RegistrationFormEvent.AcceptedTerms(isChecked))
        }

        binding.button.setOnClickListener {
            viewModel.onEvent(RegistrationFormEvent.Submit)
        }

        lifecycleScope.launch {
            viewModel.validationEvent.collect { event ->
                when (event) {
                    is MainViewModel.ValidationEvent.Sucsess -> {
                        Toast.makeText(
                            this@MainActivity,
                            "Registration successful!",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }
        }

    }
}