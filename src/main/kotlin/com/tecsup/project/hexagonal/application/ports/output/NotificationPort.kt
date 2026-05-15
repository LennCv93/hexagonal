package com.tecsup.project.hexagonal.application.ports.output

import java.math.BigDecimal

interface NotificationPort {
    fun notifyTransfer(clientEmail: String, clientName: String, amount: BigDecimal, commission: BigDecimal, transactionId: Long)
}

