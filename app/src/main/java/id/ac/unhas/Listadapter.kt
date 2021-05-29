package id.ac.unhas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import id.ac.unhas.mem.R
import kotlinx.android.synthetic.main.item_list.view.*

class Listadapter(private val listMeme : ArrayList<Data>, val listener: OnItemClickListener) : RecyclerView.Adapter<Listadapter.ListHolder>() {
    interface OnItemClickListener {
        fun onClick(meme: Data)
    }

    class ListHolder(itemview : View) : RecyclerView.ViewHolder(itemview) {
        fun bind(meme: Data, listener: OnItemClickListener) {
            with(itemView) {
                Picasso.get()
                    .load(meme.image)
                    .into(thumbnail_img)
                caption.text = meme.name

                itemView.setOnClickListener{
                    listener.onClick(meme)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ListHolder(view)
    }

    override fun onBindViewHolder(holder: ListHolder, position: Int) {
        holder.bind(listMeme[position], listener)
    }

    override fun getItemCount(): Int {
        return listMeme.size
    }
}