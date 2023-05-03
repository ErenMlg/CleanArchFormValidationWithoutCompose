package com.example.validation.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.validation.domain.usecase.ValidateEmail
import com.example.validation.domain.usecase.ValidatePassword
import com.example.validation.domain.usecase.ValidateRepeatedPassword
import com.example.validation.domain.usecase.ValidateTerms
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val validateEmail: ValidateEmail = ValidateEmail(),
    private val validatePassword: ValidatePassword = ValidatePassword(),
    private val validateRepeatedPassword: ValidateRepeatedPassword = ValidateRepeatedPassword(),
    private val validateTerms: ValidateTerms = ValidateTerms()
) : ViewModel() {

    private var _state = MutableStateFlow(RegistrationFormState())
    val state = _state.asStateFlow()
    private val _validationEventChannel = Channel<ValidationEvent>()
    val validationEvent = _validationEventChannel.receiveAsFlow()

    fun onEvent(event: RegistrationFormEvent) {
        when (event) {
            is RegistrationFormEvent.EmailChanged -> {
                _state.value = state.value.copy(email = event.email)
            }

            is RegistrationFormEvent.PasswordChanged -> {
                _state.value = state.value.copy(password = event.password)
            }

            is RegistrationFormEvent.RepeatedPasswordChanged -> {
                _state.value = state.value.copy(passwordRepeat = event.repeatedPassword)
            }

            is RegistrationFormEvent.AcceptedTerms -> {
                _state.value = state.value.copy(acceptedTerms = event.isAccepted)
            }

            is RegistrationFormEvent.Submit -> {
                submitData()
            }
        }
    }


    private fun submitData() {
        val emailResult = validateEmail.execute(state.value.email)
        val passwordResult = validatePassword.execute(state.value.password)
        val repeatedPasswordResult =
            validateRepeatedPassword.execute(state.value.password, state.value.passwordRepeat)
        val termsResult = validateTerms.execute(state.value.acceptedTerms)

        val hasError = listOf(
            emailResult, passwordResult, repeatedPasswordResult, termsResult
        ).any { !it.successful }

        _state.value = state.value.copy(
            emailError = emailResult.errorMessage,
            passwordError = passwordResult.errorMessage,
            passwordRepeatError = repeatedPasswordResult.errorMessage,
            termsError = termsResult.errorMessage
        )

        if (hasError){return}

        viewModelScope.launch {
            _validationEventChannel.send(ValidationEvent.Sucsess)
        }
    }

    sealed class ValidationEvent {
        object Sucsess : ValidationEvent()
    }

}