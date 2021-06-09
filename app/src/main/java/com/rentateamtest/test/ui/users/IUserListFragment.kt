package com.rentateamtest.test.ui.users

import com.rentateamtest.test.model.User
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

interface IUserListFragment : MvpView {

    @AddToEndSingle
    fun updateList(newList: List<User>)

    @AddToEndSingle
    fun showLoader()

    @AddToEndSingle
    fun hideLoader()
}