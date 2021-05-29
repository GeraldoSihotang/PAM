package id.ac.unhas

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import id.ac.unhas.mem.R
import kotlinx.android.synthetic.main.fragment_selected_meme.*

class SelectedMemeFragment : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_selected_meme, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Picasso.get()
            .load(StaticData.pics)
            .into(thumb_selected)

        caption_selected.text = StaticData.text

        shareBtn.setOnClickListener{
            val text = StaticData.text.toUpperCase()
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Nama meme : $text")
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = SelectedMemeFragment()
    }
}