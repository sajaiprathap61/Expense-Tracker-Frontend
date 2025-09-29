package com.example.expensetracker.data.remote

import com.example.expensetracker.data.model.Expense
import retrofit2.http.GET

interface ExpenseApiService {
    @GET("expenses")
    suspend fun getExpenses(): List<Expense>
}
