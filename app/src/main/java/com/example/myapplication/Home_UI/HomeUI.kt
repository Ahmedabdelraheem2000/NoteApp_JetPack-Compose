package com.example.myapplication.Home_UI

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.MyViewModel
import com.google.android.material.snackbar.Snackbar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun title(viewmodel: MyViewModel,modifier: Modifier){
    val title by viewmodel.title.collectAsState()
    OutlinedTextField(value = title,
        onValueChange = { viewmodel.addTitle(it) },
        modifier,
        label = { Text(text = "title") },
        singleLine = true,
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Next // Change "Next" to "Done" on the last field
        ),
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun note(viewmodel: MyViewModel,modifier: Modifier){
    val note by viewmodel.note.collectAsState()
    OutlinedTextField(value = note,
        onValueChange = { viewmodel.addNote(it) },
        modifier,
        label = { Text(text = "note.") },

        )
}

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun addNote(viewModel: MyViewModel,modifier: Modifier,context :Context){

    Button(onClick = {
        var title = viewModel.title.value
        var note = viewModel.note.value
        if (title.isEmpty()){
            Toast.makeText(context.applicationContext,"Title is Empty"+title,Toast.LENGTH_LONG).show()
        }
        if (note.isEmpty()){
            Toast.makeText(context.applicationContext,"Note is Empty"+note,Toast.LENGTH_LONG).show()
        }
        else{
            Toast.makeText(context.applicationContext,"Added note",Toast.LENGTH_LONG).show()
            viewModel.setnote(title = title , note = note)

        }
    },modifier,shape = RoundedCornerShape(5.dp)) {
        Text(text = "Add Note")
    }
}

@Composable
fun ListNote(viewModel: MyViewModel,){
    val infoNoteList by remember { viewModel.infoNote }.collectAsState()
    Column(Modifier.fillMaxSize()){
        infoNoteList.forEach{ note ->
            shapNote(note.title,note.note)
        }
    }
}

@Composable
fun shapNote(title : String , note : String){

        Column(modifier = Modifier
            .background(Color.White)
            .fillMaxWidth()
            .shadow(1.dp)
            .padding(10.dp)
        ) {
            Text(text = title, textAlign = TextAlign.Start, style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 15.sp))
            Text(text = note, textAlign = TextAlign.Start, style = TextStyle(fontWeight = FontWeight.Normal, fontSize = 15.sp))
            Spacer(modifier = Modifier.height(10.dp))
    }

}