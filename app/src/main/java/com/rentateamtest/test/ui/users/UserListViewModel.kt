package com.rentateamtest.test.ui.users

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rentateamtest.test.data.Repository
import com.rentateamtest.test.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject


@HiltViewModel
class UserListViewModel @Inject constructor(
    private val repo: Repository
) : ViewModel() {


    private val errorLiveData = MutableLiveData<String>()

    val isErrorOccurred: LiveData<String>
        get() = errorLiveData
    private val isLoadingLiveData =
        MutableLiveData<Boolean>()

    val isLoading: LiveData<Boolean>
        get() = isLoadingLiveData

    private val userListLiveData = MutableLiveData<List<User>>()

    val userList: LiveData<List<User>>
        get() = userListLiveData

    fun getUsers() {

        viewModelScope.launch {
            try {
                isLoadingLiveData.postValue(true)
                userListLiveData.postValue(repo.getAllUsers())
            } catch (e: HttpException) {
                errorLiveData.postValue(e.localizedMessage)
                userListLiveData.postValue(repo.getAllLocalUsers())

            } catch (e: Throwable) {
                errorLiveData.postValue(e.localizedMessage)
                userListLiveData.postValue(emptyList())
            } finally {
                isLoadingLiveData.postValue(false)
            }


        }

    }

}