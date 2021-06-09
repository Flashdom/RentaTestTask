package com.rentateamtest.test.ui.users

import android.util.Log
import com.rentateamtest.test.data.Repository
import com.rentateamtest.test.di.PresenterScope
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@PresenterScope
@InjectViewState
class UserListPresenter @Inject constructor(private val repo: Repository) :
    MvpPresenter<IUserListFragment>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        repo.listenLocalUsers()
    }

    fun fetchUsers() {
        viewState.showLoader()
        repo.getAllUsers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).
            subscribe({
                viewState.hideLoader()
                viewState.updateList(it)

            },
                {
                    viewState.hideLoader()
                    Log.w("a", "b")
                })
    }

}