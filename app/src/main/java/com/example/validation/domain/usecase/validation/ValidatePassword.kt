package com.example.validation.domain.usecase.validation

class ValidatePassword {

    //Set the password use case rules
    operator fun invoke(password: String): ValidationResult {
        if (password.length < 8) {
            return ValidationResult(
                successful = false,
                errorMessage = "Password can not lower 8 letter"
            )
        }
        val constainsLettersAndDigit =
            password.any { it.isDigit() } && password.any { it.isLetter() }
        if (!constainsLettersAndDigit) {
            return ValidationResult(
                successful = false,
                errorMessage = "Password need contain at least one number and one letter"
            )
        }
        return ValidationResult(
            successful = true
        )
    }

}