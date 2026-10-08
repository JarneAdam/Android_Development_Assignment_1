package be.vives.jarne.assignment_1.utility

import java.util.Locale

object Utility {
    fun formatHours(hours: Number): String {
        return String.format(Locale.US, "%.2f", hours.toDouble())
    }
}
