package com.rentateamtest.test.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.rentateamtest.test.data.database.UserContract
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = UserContract.TABLE_NAME)
data class User(
    @PrimaryKey
    @ColumnInfo(name = UserContract.Columns.id)
    val id: Int,
    @ColumnInfo(name = UserContract.Columns.email)
    val email: String,
    @ColumnInfo(name = UserContract.Columns.fullName)
    val fullName: String,
    @ColumnInfo(name = UserContract.Columns.avatar)
    val avatar: String
) : Parcelable
