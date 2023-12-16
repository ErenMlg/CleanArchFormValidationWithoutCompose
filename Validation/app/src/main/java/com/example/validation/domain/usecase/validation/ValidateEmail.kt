package com.example.validation.domain.usecase.validation

import android.util.Patterns

class ValidateEmail {

    //Set the email use case rules
    operator fun invoke(email: String): ValidationResult {
        if (email.isBlank()) {
            return ValidationResult(
                successful = false,
                errorMessage = "Email field can not empty"
            )
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return ValidationResult(
                successful = false,
                errorMessage = "Email pattern doesnt match"
            )
        }
        return ValidationResult(
            successful = true
        )
    }

}