package com.example.validation.domain.usecase

import android.util.Patterns
import java.util.regex.Pattern

class ValidateRepeatedPassword {

    //Set the repeated password use case rules
    fun execute(password: String, repeatedPassword: String): ValidationResult {
        if (repeatedPassword != password) {
            return ValidationResult(
                successful = false,
                errorMessage = "Passwords doesnt match"
            )
        }
        return ValidationResult(
            successful = true
        )
    }

}