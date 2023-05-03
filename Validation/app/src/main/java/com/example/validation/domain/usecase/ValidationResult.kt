package com.example.validation.domain.usecase

class ValidationResult(
    val successful: Boolean,
    val errorMessage: String? = null
)