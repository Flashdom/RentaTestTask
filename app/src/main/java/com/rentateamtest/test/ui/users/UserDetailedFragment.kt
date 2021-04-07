package com.rentateamtest.test.ui.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.rentateamtest.test.databinding.FragmentUserDetailedBinding
import com.squareup.picasso.Picasso


class UserDetailedFragment : Fragment() {

    private lateinit var binding: FragmentUserDetailedBinding
    private val args: UserDetailedFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserDetailedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initGUI()

    }

    private fun initGUI() {
        Picasso.get().load(args.user.avatar).into(binding.circularImageView)
        binding.emailTextView.text = args.user.email
        binding.fullNameTextView.text = args.user.fullName


    }


}