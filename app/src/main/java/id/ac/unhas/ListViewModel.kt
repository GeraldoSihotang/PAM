package id.ac.unhas

import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Callback
import retrofit2.Call
import retrofit2.Response

class ListViewModel : ViewModel() {

    init {
        Log.d("ListViewModel", "Started")
    }

    var listmeme : ArrayList<Data> = arrayListOf()

    interface OnClickListener {
        fun onClick(meme: Data)
    }
    //function for taking data from api
    fun getData(recyclerView: RecyclerView, progressBar: ProgressBar, listener: OnClickListener) {
        RetrofitClient.instance.getDataMeme().enqueue(object : Callback<DataMeme> {
            override fun onResponse(call: Call<DataMeme>, response: Response<DataMeme>) {
                Log.d("ListViewModel", "Requesting")
                val data = response.body()?.data
                listmeme.addAll(data as ArrayList<Data>)
                recyclerView.adapter = Listadapter(data as ArrayList<Data>, object : Listadapter.OnItemClickListener {
                    override fun onClick(meme: Data) {
                        listener.onClick(meme)
                    }
                })
                progressBar.visibility = View.GONE
            }

            override fun onFailure(call: Call<DataMeme>, t: Throwable) {
                Log.d("ListViewModel", "Failed")
            }
        })
    }
}