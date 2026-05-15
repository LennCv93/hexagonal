package com.tecsup.project.hexagonal.infraestructure.adapters.output.notification

import com.tecsup.project.hexagonal.application.ports.output.NotificationPort
import org.springframework.stereotype.Component
import java.math.BigDecimal

@Component
class ConsoleNotificationAdapter : NotificationPort {
    override fun notifyTransfer(clientEmail: String, clientName: String, amount: BigDecimal, commission: BigDecimal, transactionId: Long) {
        println("====================================")
        println("     🏦  ██████  BANK  ██████  🏦")
        println("====================================")
        println("     ✅ NOTIFICACIÓN DE TRANSFERENCIA")
        println("------------------------------------")
        println("   Cliente       : $clientName")
        println("   Email         : $clientEmail")
        println("   Monto         : S/ $amount")
        println("   Comisión      : S/ $commission")
        println("   Transacción ID: $transactionId")
        println("====================================")
    }
}

