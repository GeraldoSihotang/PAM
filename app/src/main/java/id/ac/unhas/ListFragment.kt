package id.ac.unhas

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import id.ac.unhas.mem.R
import kotlinx.android.synthetic.main.list_fragment.*

class ListFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() = ListFragment()
    }

    private lateinit var viewModel: ListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("ListFragment", "onCreate Called")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        return inflater.inflate(R.layout.list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("ListFragment", "onViewCreated Called")

        view_home.setHasFixedSize(true)
        view_home.layoutManager = LinearLayoutManager(context)

        if(viewModel.listmeme.size == 0) {
            viewModel.getData(view_home, progressBar , object : ListViewModel.OnClickListener {
                override fun onClick(meme: Data) {
                    StaticData.fill(meme)
                    activity?.supportFragmentManager
                        ?.beginTransaction()
                        ?.replace(R.id.fragment, SelectedMemeFragment())
                        ?.addToBackStack(null)
                        ?.commit()
                }
            })
        }
        else {
            Log.d("ListFragment", "list not empty")
            view_home.adapter = Listadapter(viewModel.listmeme, object : Listadapter.OnItemClickListener {
                override fun onClick(meme: Data) {
                    StaticData.fill(meme)
                    activity?.supportFragmentManager
                        ?.beginTransaction()
                        ?.replace(R.id.fragment, SelectedMemeFragment())
                        ?. addToBackStack(null)
                        ?.commit()
                }
            })
            progressBar.visibility = View.GONE
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("HomeFragment", "onDestroy Called")
    }

}