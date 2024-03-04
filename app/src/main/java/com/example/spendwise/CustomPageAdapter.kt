package com.example.spendwise

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import java.util.Random


class CustomPagerAdapter(private val mContext: Context, private val pageList: List<String>) :
    PagerAdapter() {

    override fun instantiateItem(collection: ViewGroup, position: Int): Any {
        val llRow: LinearLayout
        val tvPagetext: TextView
        val inflater = LayoutInflater.from(mContext)
        val layout = inflater.inflate(R.layout.row_viewpager, collection, false) as ViewGroup
        llRow = layout.findViewById<View>(R.id.llRow) as LinearLayout
        tvPagetext = layout.findViewById<View>(R.id.tvPagetext) as TextView
        val rnd = Random()
        val color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
        llRow.setBackgroundColor(color)
        tvPagetext.text = pageList[position]
        collection.addView(layout)
        return layout
    }

    override fun destroyItem(container: ViewGroup, position: Int, view: Any) {
        container.removeView(view as View?)
    }

    override fun destroyItem(container: View, position: Int, `object`: Any) {
        throw UnsupportedOperationException("Required method destroyItem was not overridden")
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun getCount(): Int {
        return pageList.size
    }
}