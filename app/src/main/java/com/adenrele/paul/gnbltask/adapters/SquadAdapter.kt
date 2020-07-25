package com.adenrele.paul.gnbltask.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.adenrele.paul.gnbltask.databinding.ItemPlayerBinding
import com.adenrele.paul.gnbltask.models.Squad
import com.adenrele.paul.gnbltask.utils.Utils
import javax.inject.Inject


class SquadAdapter @Inject constructor(

) : ListAdapter<Squad, SquadAdapter.SquadViewHolder>(SquadDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SquadViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemPlayerBinding.inflate(
            layoutInflater, parent, false
        )
        return SquadViewHolder(binding)
    }


    inner class SquadViewHolder constructor(
        val binding: ItemPlayerBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Squad) {
            val n = item.name?.split(" ")
            if (!n.isNullOrEmpty() && n.size > 1) {
                binding.textView3.text = n[0].first() + n[1].first().toString()
            }
            binding.playerName.text = item.name
            binding.position.text = item.position
            binding.country.text = item.country
            item.birthDate?.let {
                binding.birth.text = Utils.getDate(item.birthDate!!)
            }
        }
    }

    override fun onBindViewHolder(holder: SquadViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}


class SquadDiffCallBack : DiffUtil.ItemCallback<Squad>() {
    override fun areItemsTheSame(oldItem: Squad, newItem: Squad): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Squad, newItem: Squad): Boolean {
        return oldItem == newItem
    }

}