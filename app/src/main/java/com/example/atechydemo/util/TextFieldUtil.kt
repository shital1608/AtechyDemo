package com.example.atechydemo.util

import java.util.regex.Matcher
import java.util.regex.Pattern

/**
 * @author Shital Awathe
 *
 * This class contains text field related functionality.
 */
class TextFieldUtil {

    companion object{
        fun validateEmail(email: String): Boolean{
            val expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"
            val pattern: Pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
            val matcher: Matcher = pattern.matcher(email)
            return matcher.matches()
        }

        fun validatePassword(password: String): Boolean{
            //TODO
            return true
        }
    }

}