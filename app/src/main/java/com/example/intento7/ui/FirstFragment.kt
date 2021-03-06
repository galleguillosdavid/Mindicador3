package com.example.intento7.ui
//c9 m26
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.intento7.viewModel.SuperHeroesViewModel
import com.example.intento7.R
import com.example.intento7.model.recyclerView.PassTheData
import com.example.intento7.model.recyclerView.SuperHeroesAdapter
import com.example.intento7.model.repository.localWithRoom.SuperHeroesEntity
import kotlinx.android.synthetic.main.fragment_first.*


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment(), PassTheData {

    private val model: SuperHeroesViewModel by activityViewModels()
    lateinit var mAdapter: SuperHeroesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mAdapter = SuperHeroesAdapter(this)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//      todo"",.  var stringList: List<String> = listOf("a","b")
//        model.insertOneSuperHeroe(SuperHeroesEntity(999,"https://photos.app.goo.gl/ddzj9bqNQpejVDsz6","https://photos.app.goo.gl/ddzj9bqNQpejVDsz6","David Galleguillos","FrondaBrick",stringList,"2",stringList))
        val recyclerView = RecyclerView1
        recyclerView.adapter = mAdapter
        recyclerView.layoutManager = GridLayoutManager(context,2)
        model.liveDataFromLocal.observe(viewLifecycleOwner, Observer {
            Log.d("View", it.toString())
            mAdapter.updateAdapter(it)
        })
    }

    override fun passTheSuperHeroes(superHeroes: SuperHeroesEntity) {
        val bundle= Bundle()
        bundle.putInt("id",superHeroes.Id)
        findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment, bundle)
    }
}