package com.adenrele.paul.gnbltask.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.adenrele.paul.gnbltask.databinding.ItemCompetitionBinding
import com.adenrele.paul.gnbltask.models.Competition

class CompetitionListAdapter(

) : ListAdapter<Competition, CompetitionListAdapter.CompetitionViewHolder>(CompetitionDiffcallBack()) {

    private var clickListener: OnCompetitionClickListener? = null

    fun setOnClickListener(listener: OnCompetitionClickListener) {
        clickListener = listener
    }

    interface OnCompetitionClickListener {
        fun onClick(competition: Competition)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompetitionViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemCompetitionBinding.inflate(
            layoutInflater, parent, false
        )
        return CompetitionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CompetitionViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    inner class CompetitionViewHolder constructor(
        val binding: ItemCompetitionBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Competition) {
            binding.leagueName.text = item.leagueName
            binding.country.text = item.country
            binding.date.text = item.startDate ?: "no start date"


            binding.root.setOnClickListener {
                if (clickListener != null && adapterPosition != RecyclerView.NO_POSITION) {
                    clickListener!!.onClick(getItem(adapterPosition))
                }
            }
        }
    }
}

class CompetitionDiffcallBack : DiffUtil.ItemCallback<Competition>() {
    override fun areItemsTheSame(oldItem: Competition, newItem: Competition): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Competition, newItem: Competition): Boolean {
        return oldItem == newItem
    }


}