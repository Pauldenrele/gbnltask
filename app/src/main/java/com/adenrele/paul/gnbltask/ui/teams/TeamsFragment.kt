package com.adenrele.paul.gnbltask.ui.teams

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.adenrele.paul.gnbltask.adapters.TeamsAdapter
import com.adenrele.paul.gnbltask.databinding.FragmentTeamsBinding
import com.adenrele.paul.gnbltask.models.Team
import com.adenrele.paul.gnbltask.utils.DataState
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_home.*
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class TeamsFragment : Fragment() {

    @Inject
    lateinit var requestManager: RequestManager

    @Inject
    lateinit var requestOptions: RequestOptions

    private val viewModel: TeamViewModel by viewModels()

    private var _binding: FragmentTeamsBinding? = null

    private val binding get() = _binding!!

    private lateinit var adapter: TeamsAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTeamsBinding.inflate(inflater, container, false)
        adapter = TeamsAdapter()
        binding.recyclerView.adapter = adapter
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = TeamsFragmentArgs.fromBundle(requireArguments()).id

        viewModel.getTeams(id).observe(viewLifecycleOwner, Observer {
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



        adapter.setOnClickListener(object : TeamsAdapter.OnTeamClickListener{
            override fun onClick(team: Team) {
                findNavController().navigate(TeamsFragmentDirections.actionTeamsFragmentToDetailsFragment(
                    team.name,team
                ))
            }
        })

    }
}