package com.rentateamtest.test.di.components

import com.rentateamtest.test.di.PresenterScope
import com.rentateamtest.test.ui.users.UserListFragment
import com.rentateamtest.test.ui.users.UserListPresenter
import dagger.Subcomponent

@Subcomponent
@PresenterScope
interface UserListComponent {

    fun inject(fragment: UserListFragment)

    fun getUserListPresenter(): UserListPresenter

}