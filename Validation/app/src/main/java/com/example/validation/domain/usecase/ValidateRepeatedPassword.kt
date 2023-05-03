package com.example.validation.domain.usecase

import android.util.Patterns
import java.util.regex.Pattern

class ValidateRepeatedPassword {

    fun execute(password: String, repeatedPassword: String): ValidationResult {
        if (repeatedPassword != password) {
            return ValidationResult(
                successful = false,
                errorMessage = "Şifreler uyuşmuyor"
            )
        }
        return ValidationResult(
            successful = true
        )
    }

}