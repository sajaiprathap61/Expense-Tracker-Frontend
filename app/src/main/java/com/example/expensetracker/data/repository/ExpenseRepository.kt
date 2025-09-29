package com.example.expensetracker.data.repository

import com.example.expensetracker.data.model.Expense
import com.example.expensetracker.data.remote.ApiClient

class ExpenseRepository {
    suspend fun getExpenses(): List<Expense> {
        return ApiClient.expenseApi.getExpenses()
    }
}
