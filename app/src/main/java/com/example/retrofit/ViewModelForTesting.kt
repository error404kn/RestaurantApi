package com.example.retrofit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.viewModelFactory

class ViewModelForTesting: ViewModel() {
    private var calculateNumber = ""

    fun enterNumber(number: String): String {
        calculateNumber = number
        return calculateNumber
    }

    fun clear(): String{
        calculateNumber = ""
        return calculateNumber
    }

    fun multiplyOperation(): Int {
        return calculateNumber.toInt() * 2
    }
}