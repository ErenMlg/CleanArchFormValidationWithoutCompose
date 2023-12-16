package com.example.validation.domain.usecase.validation

class ValidateRepeatedPassword {

    //Set the repeated password use case rules
    operator fun invoke(password: String, repeatedPassword: String): ValidationResult {
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