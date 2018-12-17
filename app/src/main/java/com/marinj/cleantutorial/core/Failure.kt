package com.marinj.cleantutorial.core

sealed class Failure{
    class NetworkConnection: Failure()
    class ServerError: Failure()
}