package com.example.validation.domain.usecase

import android.util.Patterns
import java.util.regex.Pattern

class ValidateEmail {

    fun execute(email: String): ValidationResult {
        if (email.isBlank()) {
            return ValidationResult(
                successful = false,
                errorMessage = "Email boş olamaz"
            )
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return ValidationResult(
                successful = false,
                errorMessage = "Doğru bir email adresi giriniz"
            )
        }
        return ValidationResult(
            successful = true
        )
    }

}