package com.vuhuynh.databindinglist

import android.databinding.ObservableArrayList
import android.databinding.ObservableList

class UserListViewModel {
    var users : ObservableList<User> = ObservableArrayList<User>()
}

data class User (val name: String = "User-name", val age: Int = 21)