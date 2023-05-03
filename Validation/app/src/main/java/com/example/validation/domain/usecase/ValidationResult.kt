package com.example.validation.domain.usecase

class ValidationResult(
    // set the validation result class for the communication
    val successful: Boolean,
    val errorMessage: String? = null
)