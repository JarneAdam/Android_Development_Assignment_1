package be.vives.jarne.assignment_1.models

import java.util.Date

object MockupToDo {
    fun getUsers(): List<User> {
        return listOf(
            User(1, "jdoe", "John", "Doe", "pass123", true),
            User(2, "asmith", "Alice", "Smith", "pass123", true),
            User(3, "bwilliams", "Bob", "Williams", "pass123", false)
        )
    }

    fun getToDos(): List<ToDo> {
        val users = getUsers()
        return listOf(
            ToDo(
                1,
                "Setup project",
                "Create a new Android Studio project with Compose",
                users[0],
                Date(),
                null,
                null,
                4,
                false, false, false, false
            ),
            ToDo(
                2,
                "Implement Models",
                "Create User and ToDo data classes",
                users[0],
                Date(),
                users[1],
                null,
                2,
                true, false, false, false
            ),
            ToDo(
                3,
                "Create Mock Data",
                "Generate a list of users and todos for testing",
                users[1],
                Date(),
                users[1],
                null,
                1,
                true, true, false, false
            ),
            ToDo(
                4,
                "Design UI",
                "Create Jetpack Compose layout for ToDo details",
                users[2],
                Date(),
                users[0],
                null,
                8,
                true, true, true, false
            ),
            ToDo(
                5,
                "Testing and QA",
                "Ensure everything works as expected",
                users[0],
                Date(),
                users[2],
                Date(),
                5,
                true, true, true, true
            )
        )
    }
}
