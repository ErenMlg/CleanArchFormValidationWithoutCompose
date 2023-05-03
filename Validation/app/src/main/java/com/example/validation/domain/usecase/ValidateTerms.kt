package com.example.validation.domain.usecase

import android.util.Patterns
import java.util.regex.Pattern

class ValidateTerms {

    fun execute(acceptedTerms: Boolean): ValidationResult {
        if (!acceptedTerms) {
            return ValidationResult(
                successful = false,
                errorMessage = "Kullanım koşullarını kabul ediniz"
            )
        }
        return ValidationResult(
            successful = true
        )
    }

}