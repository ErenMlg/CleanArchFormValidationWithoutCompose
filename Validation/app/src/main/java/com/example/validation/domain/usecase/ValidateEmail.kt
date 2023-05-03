package com.example.validation.domain.usecase

import android.util.Patterns
import java.util.regex.Pattern

class ValidateEmail {

    //Set the email use case rules
    fun execute(email: String): ValidationResult {
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