package com.example.myapplication

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

@HiltViewModel
class MyViewModel : ViewModel() {
    //------------------------------
    private var infoNoteMutableState = MutableStateFlow<List<Info_Note>>(emptyList())
    private var title_MutableStateFlow = MutableStateFlow("")
    private var note_MutableStateFlow = MutableStateFlow("")
    //------------------------------
    var title = title_MutableStateFlow.asStateFlow()
    var note = note_MutableStateFlow.asStateFlow()
    var infoNote = infoNoteMutableState.asStateFlow()
    //------------------------------

    fun addTitle(title : String){
        title_MutableStateFlow.update { title }
    }
    //-------------------------------
    fun addNote(note : String){
        note_MutableStateFlow.update { note }
    }
    //-------------------------------
   fun setnote(title:String,note:String){
       var nextNode = Info_Note(title,note)
       infoNoteMutableState.update { prevus_node ->
           prevus_node + nextNode
       }
        this.title_MutableStateFlow.update { "" }
        this.note_MutableStateFlow.update { "" }
    }
}
