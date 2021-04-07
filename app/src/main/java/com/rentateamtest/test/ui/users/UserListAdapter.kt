package com.rentateamtest.test.ui.users

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.rentateamtest.test.model.User
import com.rentateamtest.test.databinding.ItemUserBinding
import com.squareup.picasso.Picasso

class UserListAdapter(private val onItemClick:(item: User) -> Unit): RecyclerView.Adapter<UserListAdapter.UserListViewHolder>() {

    private val differ = AsyncListDiffer(this, UserItemCallback())

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListViewHolder {
        return UserListViewHolder(ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: UserListViewHolder, position: Int) {
        holder.bind(differ.currentList[position], onItemClick)
    }

    override fun getItemCount(): Int = differ.currentList.size


    fun updateList(newList: List<User>)
    {
        differ.submitList(newList)
    }


    class UserListViewHolder(private val binding : ItemUserBinding): RecyclerView.ViewHolder(binding.root)
    {
        fun bind(item: User, onItemClick:(item: User) -> Unit)
        {
            binding.fullNameTextView.text = item.fullName
            binding.root.setOnClickListener { onItemClick(item) }
        }
    }


    class UserItemCallback : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
           return oldItem == newItem
        }
    }


}