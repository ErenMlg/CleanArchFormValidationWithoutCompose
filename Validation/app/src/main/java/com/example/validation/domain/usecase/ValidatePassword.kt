package com.example.validation.domain.usecase

import android.util.Patterns
import java.util.regex.Pattern

class ValidatePassword {

    fun execute(password: String): ValidationResult {
        if (password.length < 8) {
            return ValidationResult(
                successful = false,
                errorMessage = "Şifre 8 haneden küçük olamaz"
            )
        }
        val constainsLettersAndDigit =
            password.any { it.isDigit() } && password.any { it.isLetter() }
        if (!constainsLettersAndDigit) {
            return ValidationResult(
                successful = false,
                errorMessage = "Şifre en az bir rakam ve bir harften oluşmalıdır"
            )
        }
        return ValidationResult(
            successful = true
        )
    }

}