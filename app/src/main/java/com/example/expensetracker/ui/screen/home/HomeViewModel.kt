package com.example.expensetracker.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.expensetracker.data.model.Expense
import com.example.expensetracker.data.repository.ExpenseRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val repository = ExpenseRepository()

    private val _expenses = MutableStateFlow<List<Expense>>(emptyList())
    val expenses: StateFlow<List<Expense>> = _expenses

    init {
        viewModelScope.launch {
            _expenses.value = repository.getExpenses()
        }
    }

    private fun fetchExpenses() {
        viewModelScope.launch {
            try {
                val data = repository.getExpenses()
                _expenses.value = data
            } catch (e: Exception) {
                e.printStackTrace()
                // TODO: handle errors properly
            }
        }
    }
}
