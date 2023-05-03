package com.example.validation.domain.usecase

import android.util.Patterns
import java.util.regex.Pattern

class ValidateTerms {

    //Set the usage terms use case rules
    fun execute(acceptedTerms: Boolean): ValidationResult {
        if (!acceptedTerms) {
            return ValidationResult(
                successful = false,
                errorMessage = "Please accept useage terms"
            )
        }
        return ValidationResult(
            successful = true
        )
    }

}