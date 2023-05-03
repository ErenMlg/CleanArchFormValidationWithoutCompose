package com.example.validation.presentation

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class RegistrationFormState(
    var email: String = "",
    val emailError: String? = null,
    var password: String = "",
    val passwordError: String? = null,
    var passwordRepeat: String = "",
    val passwordRepeatError: String? = null,
    var acceptedTerms: Boolean = false,
    val termsError: String? = null
)