package be.vives.jarne.assignment_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import be.vives.jarne.assignment_1.models.MockupToDo
import be.vives.jarne.assignment_1.models.ToDo
import be.vives.jarne.assignment_1.ui.theme.Assignment_1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Assignment_1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val toDo = MockupToDo.getToDos().first()
                    MyToDoLayout(
                        toDo = toDo,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MyToDoLayout(toDo: ToDo, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Top section with image, number, and status
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            // Using a default icon for the image, as per instructions "kan je een afbeelding importeren..."
            // You can replace R.drawable.ic_launcher_foreground with your actual imported image
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "ToDo Image",
                modifier = Modifier
                    .size(64.dp)
                    .padding(end = 16.dp)
            )
            Column {
                Text(text = "ToDo: ${toDo.number}", fontWeight = FontWeight.Bold)
                Text(text = "Status: ${toDo.statusDescription}")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Red divider
        HorizontalDivider(color = Color.Red, thickness = 2.dp)

        Spacer(modifier = Modifier.height(16.dp))

        // Title and Description
        Text(text = "Title:", fontWeight = FontWeight.Bold)
        Text(text = toDo.title, modifier = Modifier.padding(bottom = 8.dp))

        Text(text = "Description:", fontWeight = FontWeight.Bold)
        Text(text = toDo.description, modifier = Modifier.padding(bottom = 16.dp))

        // Time estimated and remaining
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(text = "Time Estimated:", fontWeight = FontWeight.Bold)
                Text(text = "${toDo.timeEstimated} hrs")
            }
            Column {
                Text(text = "Time Remaining:", fontWeight = FontWeight.Bold)
                Text(text = "${toDo.timeRemaining} hrs")
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Boxed area for boolean flags
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .border(2.dp, Color.Gray)
                .padding(16.dp)
        ) {
            Column {
                SwitchRow(label = "Analysis Done", checked = toDo.analysisDone)
                SwitchRow(label = "Development Done", checked = toDo.developmentDone)
                SwitchRow(label = "Review & Testing Done", checked = toDo.reviewAndTestingDone)
                SwitchRow(label = "Acceptance Done", checked = toDo.acceptanceDone)
            }
        }
    }
}

@Composable
fun SwitchRow(label: String, checked: Boolean) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
    ) {
        Text(text = label)
        Switch(checked = checked, onCheckedChange = null)
    }
}

class ToDoPreviewParameterProvider : PreviewParameterProvider<ToDo> {
    private val toDos = MockupToDo.getToDos()
    override val values = toDos.asSequence()
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview(
    @PreviewParameter(ToDoPreviewParameterProvider::class, limit = 3) toDo: ToDo
) {
    Assignment_1Theme {
        MyToDoLayout(toDo)
    }
}
