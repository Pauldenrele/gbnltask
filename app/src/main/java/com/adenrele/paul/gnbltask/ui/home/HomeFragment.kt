package com.adenrele.paul.gnbltask.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.adenrele.paul.gnbltask.adapters.CompetitionListAdapter
import com.adenrele.paul.gnbltask.databinding.FragmentHomeBinding
import com.adenrele.paul.gnbltask.models.Competition
import com.adenrele.paul.gnbltask.utils.DataState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_home.*
import timber.log.Timber

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModels()

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!
    private lateinit var adapter: CompetitionListAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = CompetitionListAdapter()
        binding.competitionsRecyclerView.adapter = adapter
        adapter.setOnClickListener(object : CompetitionListAdapter.OnCompetitionClickListener {
            override fun onClick(competition: Competition) {
                findNavController().navigate(
                    HomeFragmentDirections.actionHomeFragmentToTeamsFragment(
                        competition.leagueName, competition.id
                    )
                )
            }
        })

        homeViewModel.competition.observe(viewLifecycleOwner, Observer {
            when (it) {
                is DataState.Success -> {
                    progress_circular.visibility = View.GONE
                    adapter.submitList(it.data)
                }
                is DataState.Error -> {
                    Timber.d(it.exception)
                    progress_circular.visibility = View.GONE
                }
                is DataState.Loading -> {
                    progress_circular.visibility = View.VISIBLE
                }
            }
        })
    }

}