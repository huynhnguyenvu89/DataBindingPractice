package com.vuhuynh.databindinglist

import android.databinding.DataBindingUtil
import android.databinding.ObservableArrayList
import android.databinding.ObservableList
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.vuhuynh.databindinglist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val userList = UserListViewModel()
        userList.users = getUsers()
        binding.userListModel = userList
    }

    private fun getUsers() : ObservableList<User> {
        val list = ArrayList<User>()
        list.add(User("V"))
        list.add(User("U"))
        list.add(User("H"))
        list.add(User("U"))
        list.add(User("Y"))
        list.add(User("N"))
        list.add(User("H"))
        list.add(User("N"))
        list.add(User("G"))
        list.add(User("U"))
        list.add(User("Y"))
        list.add(User("E"))
        list.add(User("N"))
        list.add(User("V"))
        list.add(User("U"))
        list.add(User("H"))
        list.add(User("U"))
        list.add(User("Y"))
        list.add(User("N"))
        list.add(User("H"))
        list.add(User("N"))
        list.add(User("G"))
        list.add(User("U"))
        list.add(User("Y"))
        list.add(User("E"))
        list.add(User("N"))
        val observableArrayList = ObservableArrayList<User>()
        observableArrayList.addAll(list)
        return  observableArrayList
    }
}
