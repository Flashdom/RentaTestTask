package com.rentateamtest.test.ui.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.rentateamtest.test.databinding.FragmentUserListBinding
import com.rentateamtest.test.model.User
import com.rentateamtest.test.util.MyApp
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider


class UserListFragment : MvpAppCompatFragment(), IUserListFragment {

    private lateinit var binding: FragmentUserListBinding

    @Inject
    lateinit var presenterProvider: Provider<UserListPresenter>

    private val presenter by moxyPresenter { presenterProvider.get() }


    override fun onCreate(savedInstanceState: Bundle?) {
        MyApp.component?.getUserListComponent()?.inject(this)
        super.onCreate(savedInstanceState)
    }

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
        presenter.fetchUsers()

    }

    private fun initGUI() {
        with(binding.userListRecyclerView)
        {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = UserListAdapter { item ->
                val action =
                    UserListFragmentDirections.actionNavigationUserListToUserDetailedFragment(item)
                findNavController().navigate(action)
            }
        }
    }

    override fun updateList(newList: List<User>) {
        (binding.userListRecyclerView.adapter as UserListAdapter).updateList(newList)
    }

    override fun showLoader() {
        binding.progressBar.isVisible = true
    }

    override fun hideLoader() {
        binding.progressBar.isVisible = false
    }

}