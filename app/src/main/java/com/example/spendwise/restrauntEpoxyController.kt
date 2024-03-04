package com.example.spendwise

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.airbnb.epoxy.TypedEpoxyController
import com.example.spendwise.data.dummyData
import com.example.spendwise.data.restraunt
import com.example.spendwise.databinding.DishesItemBinding
import com.example.spendwise.databinding.RestrauntItemBinding
import com.example.spendwise.ui.Dishes
import com.example.spendwise.ui.Lunch

class restrauntEpoxyController(
    val context: Context,
): TypedEpoxyController<List<restraunt>>() {

    override fun buildModels(data: List<restraunt>?) {
        if(data.isNullOrEmpty()){
            return
        }
        data.forEach{ item->
            ItemEpoxyModel(item,context,this).id(1).addTo(this)
        }
    }

    data class ItemEpoxyModel(
        val item: restraunt,
        val context: Context,
        val itemEpoxyController: restrauntEpoxyController
    ): ViewBindingKotlinModel<RestrauntItemBinding>(R.layout.restraunt_item) {
        private var isDisplayed = true

        override fun RestrauntItemBinding.bind() {

            imageView4.setImageResource(item.name)

            val controller = ChlidEpoxyController(context)
            epoxyRecyclerView5.setController(controller)
            controller.setData(item.list)
        }

    }

}

class ChlidEpoxyController(
    val context: Context,
): TypedEpoxyController<List<Int>>(){

    override fun buildModels(data: List<Int>?) {
        if(data.isNullOrEmpty()){
            return
        }
        data.forEach{ item->
            ChildEpoxyModel(item,context).id(1).addTo(this)
        }
    }

    data class ChildEpoxyModel(
        val name:Int,
        val context: Context,
    ): ViewBindingKotlinModel<DishesItemBinding>(R.layout.dishes_item){
        override fun DishesItemBinding.bind() {
            imageView5.setOnClickListener {
                val fragment = Dishes()
                val fragmentManager: FragmentManager =
                    (context as AppCompatActivity).supportFragmentManager
                val transaction: FragmentTransaction = fragmentManager.beginTransaction()
                transaction.replace(dummyData.layout, fragment)
                transaction.addToBackStack(null)
                transaction.commit()
            }
            imageView5.setImageResource(name)
        }

    }

}