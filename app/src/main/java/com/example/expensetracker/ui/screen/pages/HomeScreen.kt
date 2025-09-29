package com.example.expensetracker.ui.screen.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.expensetracker.R
import com.example.expensetracker.data.model.Expense

@Composable
@Preview
fun HomeScreen() {

    val ranges = listOf("Today", "Month", "Year")
    val amount = 2789
    val expenses = listOf(
        Expense(title = "Shopping", amount = 120, date = "Sep 28, 2025", icon = "shopping"),
        Expense(title = "Groceries", amount = 80, date = "Sep 27, 2025", icon = "groceries"),
        Expense(title = "Vegetables", amount = 50, date = "Sep 26, 2025", icon = "vegetables"),
    )


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .padding(20.dp)
    ) {

        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp) // Set gap between items
        ) {

// Intro Text
            Column() {
                Text(
                    text = "Hello,", style = TextStyle(fontSize = 50.sp)
                )

                Text(
                    text = "User", style = TextStyle(fontSize = 50.sp)
                )
            }

// Row content
            EqualWidthRow(ranges)

// Status Box
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(2.dp, Color.Black, shape = RoundedCornerShape(12.dp))
            ) {
                Column(
                    modifier = Modifier.padding(12.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Text(text = "Amount", style = TextStyle(fontSize = 20.sp))
                    Text(text = "$ $amount", style = TextStyle(fontSize = 16.sp))
                }
            }

            ListOfExpense(expenses)
        }
    }
}


@Composable
fun EqualWidthRow(ranges: List<String>) {

    val fontSize = 16

    Row(
        modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
    ) {
        ranges.forEach { range ->
            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(4.dp)
                    .border(2.dp, Color.Black, shape = RoundedCornerShape(12.dp))
                    .padding(12.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(text = range, fontSize = fontSize.sp, textAlign = TextAlign.Center)
            }
        }
    }
}

@Composable
fun ListOfExpense(expenses: List<Expense>) {

// List of Expense
    Column(
        modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(text = "List of Expenses:", style = TextStyle(fontSize = 20.sp))

        expenses.forEach { expense ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(2.dp, Color.Black, shape = RoundedCornerShape(12.dp))
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.shopping),
                    contentDescription = "Category Icons",
                    modifier = Modifier.width(50.dp)
                )
                Text(text = expense.title, fontSize = 16.sp)
                Spacer(modifier = Modifier.weight(1f))
                Column(
                    modifier = Modifier.padding(10.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Text(text = "$ ${expense.amount}", fontSize = 16.sp, textAlign = TextAlign.End)
                    Text(text = expense.date)
                }
            }
        }
    }
}