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
        // Check the in state variables
        lifecycleScope.launch {
            viewModel.state.collect {
                binding.emailLayout.isErrorEnabled = it.emailError != null
                binding.emailLayout.error = it.emailError
                binding.passwordLayout.isErrorEnabled = it.passwordError != null
                binding.passwordLayout.error = it.passwordError
                binding.passwordRepeatLayout.isErrorEnabled = it.passwordRepeatError != null
                binding.passwordRepeatLayout.error = it.passwordRepeatError
                binding.terms.error = it.termsError
            }
        }
        //When change email send to state
        binding.email.doOnTextChanged { text, _, _, _ ->
            viewModel.onEvent(RegistrationFormEvent.EmailChanged(text.toString()))
        }
        //When change password send to state
        binding.password.doOnTextChanged { text, _, _, _ ->
            viewModel.onEvent(RegistrationFormEvent.PasswordChanged(text.toString()))
        }
        //When change passwordRepeat send to state
        binding.passwordRepeat.doOnTextChanged { text, _, _, _ ->
            viewModel.onEvent(RegistrationFormEvent.RepeatedPasswordChanged(text.toString()))
        }
        //When change terms send to state
        binding.terms.setOnCheckedChangeListener { _, isChecked ->
            viewModel.onEvent(RegistrationFormEvent.AcceptedTerms(isChecked))
        }
        //When change button send to state
        binding.button.setOnClickListener {
            viewModel.onEvent(RegistrationFormEvent.Submit)
        }

        //Listen the events if validation success show the toast message
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