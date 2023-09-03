package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myapplication.Home_UI.*

class MainActivity : ComponentActivity() {
//    private var listitem by mutableStateOf<List<String>>(emptyList())
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            Column(modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(15.dp)
                .verticalScroll(rememberScrollState())) {
                var viewmodel : MyViewModel = hiltViewModel()

                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically){
                    Image(painter = painterResource(R.drawable.jet), contentDescription ="",
                        Modifier.height(70.dp))
                    Text(text = "App Note", textAlign = TextAlign.Center, style = TextStyle(
                        fontSize = 15.sp, fontWeight = FontWeight.Bold , color = Color.Black,
                    ),

                    )
                }

                Spacer(modifier = Modifier.height(10.dp))
                title(viewmodel,modifier = Modifier
                    .fillMaxWidth()
                    .height(65.dp))

                Spacer(modifier = Modifier.height(10.dp))

                note(viewmodel,modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp))

                Spacer(modifier = Modifier.height(20.dp))

                addNote(viewmodel,modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .background(Color.Green)
                    , context = applicationContext)

                Spacer(modifier = Modifier.height(20.dp))
                Text(text = "List Of Note...", textAlign = TextAlign.Start, style = TextStyle(
                    fontSize = 15.sp, fontWeight = FontWeight.Bold , color = Color.Black,
                ),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(10.dp))

                ListNote(viewmodel)


            }
        }
    }

































//@SuppressLint("SuspiciousIndentation")
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun add_note_TF(modifier: Modifier) {
//    var viewmodel : MyViewModel = hiltViewModel()
//    val note by viewmodel.note_.collectAsState()
//        OutlinedTextField(
//            value = note,
//            onValueChange = {
//                viewmodel.addNote(it)
//            },
//            modifier = modifier, // Specify the type of modifier explicitly
//            label = { Text("Enter your note") }, // Use Text for label
//            textStyle = TextStyle(
//                color = Color.Black,
//            )
//        )
//}
//
//
//@Composable
//fun button_AddNote() {
//        var viewmodel : MyViewModel = hiltViewModel()
//        Button(
//            onClick = {
//                val note = viewmodel.note_.value
//                if (note.isNotEmpty()) {
//                    Toast.makeText(
//                        applicationContext,
//                        note,
//                        Toast.LENGTH_LONG
//                    ).show()
//                    listitem = listitem + listOf(note)
//                } else {
//                    Toast.makeText(
//                        applicationContext,
//                        "Note is empty",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                }
//            },
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(50.dp),
//            shape = RoundedCornerShape(5.dp),
//            colors = ButtonDefaults.buttonColors(Color.Blue),
//        ) {
//            Text(text = "Add Note", color = Color.White, style = TextStyle(fontSize = 17.sp))
//        }
//    }
//
//@Composable
//fun listNote(){
//    LazyColumn(Modifier.fillMaxHeight()){
//        items (listitem){note->
//            Text(text =note )
//        }
//    }
//}
//
//
//
//
@Preview
@Composable
fun Preview(){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
        .padding(15.dp)) {
        var viewmodel : MyViewModel = hiltViewModel()

        title(viewmodel,modifier = Modifier
            .fillMaxWidth()
            .height(50.dp))
        note(viewmodel,modifier = Modifier
            .fillMaxWidth()
            .height(150.dp))
        addNote(viewmodel,modifier = Modifier
            .fillMaxWidth()
            .height(60.dp), context = applicationContext)
        ListNote(viewmodel)
    }
}


}

