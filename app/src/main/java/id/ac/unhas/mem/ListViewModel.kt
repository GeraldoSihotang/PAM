package id.ac.unhas.mem

import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView

class ListViewModel : ViewModel() {

    init {
        Log.d("ListViewModel", "Started")
    }

    var listmeme : ArrayList<meme> = arrayListOf()

    interface onClickListener {
        fun onClick(meme: meme)
    }
    //function for taking data from api
    fun getData(recyclerView: RecyclerView, progressBar: ProgressBar, listener: onClickListener) {
        progressBar.visibility = View.GONE
    }
}