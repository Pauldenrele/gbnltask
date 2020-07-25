package com.adenrele.paul.gnbltask.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer

import com.adenrele.paul.gnbltask.R
import com.adenrele.paul.gnbltask.adapters.SquadAdapter
import com.adenrele.paul.gnbltask.databinding.DetailsFragmentBinding
import com.adenrele.paul.gnbltask.models.Team
import com.adenrele.paul.gnbltask.utils.DataState
import com.adenrele.paul.gnbltask.utils.Utils
import com.guardanis.imageloader.ImageRequest
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber


@AndroidEntryPoint
class DetailsFragment : Fragment() {


    private val viewModel: DetailsViewModel by viewModels()

    private var _binding: DetailsFragmentBinding? = null

    private val binding get() = _binding!!
    private lateinit var adapter: SquadAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DetailsFragmentBinding.inflate(inflater, container, false)
        adapter = SquadAdapter()
        binding.recyclerView.adapter = adapter
        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val team = DetailsFragmentArgs.fromBundle(requireArguments()).team
        setUpDetails(team)

        viewModel.getSquadsForTeam(team.id).observe(viewLifecycleOwner, Observer {
            when (it) {
                is DataState.Success -> {
                    adapter.submitList(it.data)

                }
                is DataState.Error -> {
                    Timber.d(it.exception)
                }
            }
        })
    }


    private fun setUpDetails(team: Team) {
        team.crestUrl?.let {
            ImageRequest.create(binding.crestImage)
                .setTargetUrl(it)
                .execute()
        } ?: binding.crestImage.setImageResource(R.drawable.ic_launcher_background)

        binding.address.text = team.address
        binding.email.text = team.email
        binding.founded.text = team.founded.toString()
        binding.nickname.text = team.shortName
        binding.phone.text = team.phone
        binding.website.text = team.website

        team.colours?.let {
            for (i in team.colours.split("/")) {

                val imageView = ImageView(requireContext())
                imageView.layoutParams = ViewGroup.LayoutParams(
                    30,
                    30
                )
                imageView.setImageResource(Utils.getColorDrawable(i.trim()))
                binding.swatch.addView(imageView)
            }
        }

    }

}