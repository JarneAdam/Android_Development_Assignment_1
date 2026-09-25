package be.vives.jarne.assignment_1.models

import java.util.Date

data class ToDo(
    var number: Int,
    var title: String,
    var description: String,
    var createdByUser: User,
    var createOnDate: Date,
    var assignedToUser: User?,
    var finishedOnDate: Date?,
    var timeEstimated: Int,
    var analysisDone: Boolean = false,
    var developmentDone: Boolean = false,
    var reviewAndTestingDone: Boolean = false,
    var acceptanceDone: Boolean = false
)
