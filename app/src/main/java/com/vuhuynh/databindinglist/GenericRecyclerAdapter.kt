package com.vuhuynh.databindinglist

import android.databinding.BindingAdapter
import android.databinding.DataBindingUtil
import android.databinding.ObservableList
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

class GenericRecyclerAdapter(
        val dataList: List<*>,
        val itemLayoutId: Int,
        val variable: Int) :
        RecyclerView.Adapter<GenericRecyclerAdapter.GenericViewHolder>() {

    class GenericViewHolder(val viewDataBinding: ViewDataBinding)
        : RecyclerView.ViewHolder(viewDataBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenericViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val viewDataBinding: ViewDataBinding =
                DataBindingUtil.inflate(inflater, itemLayoutId, parent, false)
        return GenericViewHolder(viewDataBinding)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: GenericViewHolder, position: Int) {
        val viewDataBinding = holder.viewDataBinding
        println("<VH> position $position dataList[position] ${dataList[position].toString()} ${BR.user}")
        viewDataBinding.setVariable(variable, dataList[position])
        viewDataBinding.executePendingBindings()
    }
}

@BindingAdapter("data", "layoutId", "variable")
fun setAdapter(recyclerView: RecyclerView,
               data: ObservableList<*>,
               layoutId: Int,
               variable: Int) {
    recyclerView.adapter = GenericRecyclerAdapter(
            dataList = data,
            itemLayoutId = layoutId,
            variable = variable
    )
}