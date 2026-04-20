package com.huhx0015.algorithmtester.twentytwentysix.kotlin

/**
 * You are given a list of transactions returned from an API.
 *
 * Each transaction has:
 *
 * id
 * timestamp
 * description
 * amountCents
 * type (DEBIT or CREDIT)
 * pending (true or false)
 *
 * Write a function that transforms this raw list into a UI-friendly list for a transaction screen.
 *
 * Requirements:
 * 1. Exclude pending transactions.
 * 2. Sort transactions by timestamp descending.
 * 3. Group transactions by day (YYYY-MM-DD).
 * 4. For each day, return:
 *    the date
 *    the list of transactions for that date
 *    the total debit amount for that date in cents
 * 5. Within each day, preserve the sorted order.
 * 6. If two transactions have the same timestamp, sort them by id ascending.
 */
object BuildTransactionSections {

    @JvmStatic fun main(args: Array<String>) {

    }

    data class Transaction(
        val id: Int,
        val timestamp: String, // ISO8601 example: "2026-04-18T09:30:00Z"
        val description: String,
        val amountCents: Int,
        val type: TransactionType,
        val pending: Boolean
    )

    enum class TransactionType {
        DEBIT, CREDIT
    }

    data class TransactionRow(
        val id: String,
        val description: String,
        val amountCents: Int,
        val type: TransactionType
    )

    data class TransactionSection(
        val date: String, // example: "2026-04-18"
        val rows: List<TransactionRow>,
        val totalDebitCents: Int
    )

    fun buildTransactionSections(transactions: List<Transaction>): List<TransactionSection> {
        val transactionSectionList = mutableListOf<TransactionSection>()

        // TODO: Implement transactionSection functionality.

        return transactionSectionList
    }
}