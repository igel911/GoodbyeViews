package com.example.goodbyeviews.ui.navigation

const val EMAIL_KEY = "email"

sealed class Destination(protected val route: String, vararg params: String) {
    val fullRoute: String = if (params.isEmpty()) route else {
        val builder = StringBuilder(route)
        params.forEach { builder.append("/{${it}}") }
        builder.toString()
    }

    sealed class NoArgumentsDestination(route: String) : Destination(route) {
        operator fun invoke(): String = route
    }

    object LoginScreen : NoArgumentsDestination("login")

    object SignUpScreen : NoArgumentsDestination("signUp")

    object EnterCodeScreen : Destination("enterCode", EMAIL_KEY) {
        operator fun invoke(fistName: String): String = route.appendParams(
            EMAIL_KEY to fistName
        )
    }

    object InterestsScreen : NoArgumentsDestination("interests")
}

internal fun String.appendParams(vararg params: Pair<String, Any?>): String {
    val builder = StringBuilder(this)

    params.forEach {
        it.second?.toString()?.let { arg ->
            builder.append("/$arg")
        }
    }

    return builder.toString()
}
