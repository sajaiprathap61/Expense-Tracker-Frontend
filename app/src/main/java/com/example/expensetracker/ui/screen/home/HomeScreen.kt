package com.example.expensetracker.ui.screen.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.expensetracker.ui.screen.pages.ListOfExpense
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun HomeScreen(viewModel: HomeViewModel = viewModel()) {
    val expenses by viewModel.expenses.collectAsState()
    ListOfExpense(expenses)
}


