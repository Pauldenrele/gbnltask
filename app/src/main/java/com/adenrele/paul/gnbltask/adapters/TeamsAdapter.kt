package com.adenrele.paul.gnbltask.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.adenrele.paul.gnbltask.R
import com.adenrele.paul.gnbltask.databinding.ItemTeamsBinding
import com.adenrele.paul.gnbltask.models.Team
import com.guardanis.imageloader.ImageRequest
import javax.inject.Inject


class TeamsAdapter @Inject constructor(

) : ListAdapter<Team, TeamsAdapter.TeamsViewHolder>(TeamsDiffcallBack()) {

    private var clickListener: OnTeamClickListener? = null

    fun setOnClickListener(listener: OnTeamClickListener) {
        clickListener = listener
    }

    interface OnTeamClickListener {
        fun onClick(team: Team)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemTeamsBinding.inflate(
            layoutInflater, parent, false
        )
        return TeamsViewHolder(binding)
    }


    inner class TeamsViewHolder constructor(
        val binding: ItemTeamsBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Team) {
            item.crestUrl?.let {
                ImageRequest.create(binding.teamsImage)
                    .setTargetUrl(item.crestUrl)
                    .execute()
            } ?: binding.teamsImage.setImageResource(R.drawable.ic_launcher_background)


            binding.root.setOnClickListener {
                if (clickListener != null && adapterPosition != RecyclerView.NO_POSITION) {
                    clickListener!!.onClick(getItem(adapterPosition))
                }
            }
        }
    }

    override fun onBindViewHolder(holder: TeamsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


}


class TeamsDiffcallBack : DiffUtil.ItemCallback<Team>() {
    override fun areItemsTheSame(oldItem: Team, newItem: Team): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Team, newItem: Team): Boolean {
        return oldItem == newItem
    }
}