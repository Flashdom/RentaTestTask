package com.rentateamtest.test.ui.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.rentateamtest.test.databinding.FragmentUserListBinding
import com.rentateamtest.test.model.User
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserListFragment : Fragment() {

    private lateinit var binding: FragmentUserListBinding
    private val userListViewModel: UserListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initGUI()
        userListViewModel.getUsers()
        userListViewModel.isLoading.observe(viewLifecycleOwner, {
            binding.progressBar.isVisible = it
        })

        userListViewModel.isErrorOccurred.observe(viewLifecycleOwner, {
            Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
        })
        userListViewModel.userList.observe(viewLifecycleOwner, this::onListFetched)
    }

    private fun onListFetched(newList: List<User>) {
        (binding.userListRecyclerView.adapter as UserListAdapter).updateList(newList)

    }


    private fun initGUI() {
        with(binding.userListRecyclerView)
        {
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            adapter = UserListAdapter { item ->
                val action =
                    UserListFragmentDirections.actionNavigationUserListToUserDetailedFragment(item)
                findNavController().navigate(action)
            }
        }
    }

}