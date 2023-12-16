package com.example.validation.domain.usecase.validation

class ValidateTerms {

    //Set the usage terms use case rules
    operator fun invoke(acceptedTerms: Boolean): ValidationResult {
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