package com.example.spendwise.ui

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.airbnb.epoxy.TypedEpoxyController
import com.example.spendwise.R
import com.example.spendwise.ViewBindingKotlinModel
import com.example.spendwise.data.dummyData
import com.example.spendwise.databinding.FiltersItemBinding
import com.example.spendwise.databinding.SubscriptionItemBinding
import java.io.Serializable

class ItemEpoxyController(
    val context: Context,
    val subs:Boolean
): TypedEpoxyController<List<Pair<Int, String>>>() {

    override fun buildModels(data: List<Pair<Int, String>>?) {
        var ind = 0
        if(data.isNullOrEmpty()){
            return
        }
        data.forEach{ item->
            ItemEpoxyModel(item,context,this,subs).id(ind).addTo(this)
            ind++
        }
    }

    data class ItemEpoxyModel(
        val item: Pair<Int, String>,
        val context: Context,
        val itemEpoxyController: ItemEpoxyController,
        val subs:Boolean
    ): ViewBindingKotlinModel<SubscriptionItemBinding>(R.layout.subscription_item) {

        override fun SubscriptionItemBinding.bind() {
            if(subs)
                imageView.setOnClickListener {
                    val fragment = Lunch()
                    val fragmentManager: FragmentManager =
                        (context as AppCompatActivity).supportFragmentManager
                    val transaction: FragmentTransaction = fragmentManager.beginTransaction()
                    transaction.replace(dummyData.layout, fragment)
                    transaction.addToBackStack(null)
                    transaction.commit()
                }
            imageView.setImageResource(item.first)
            textView.text = item.second
        }

    }

}

class FiltersEpoxyController(
    val context: Context,
): TypedEpoxyController<List<String>>() {

    override fun buildModels(data: List<String>?) {
        if(data.isNullOrEmpty()){
            return
        }
        data.forEach{ item->
            ItemEpoxyModel(item).id(1).addTo(this)
        }
    }

    data class ItemEpoxyModel(
        val item: String
    ): ViewBindingKotlinModel<FiltersItemBinding>(R.layout.filters_item) {

        override fun FiltersItemBinding.bind() {
            textView2.text = item
        }

    }

}