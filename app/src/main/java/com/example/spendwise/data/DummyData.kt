package com.example.spendwise.data

import com.example.spendwise.R

object dummyData {

    val filtersList = listOf("Sort By","Veg","Non Veg","4+ Rating","Under 100")

    val subscriptionList: List<Pair<Int, String>> = listOf(
        Pair(R.drawable.breakfast, "BREAKFAST"),
        Pair(R.drawable.lunch, "LUNCH"),
        Pair(R.drawable.dinner, "DINNER"),
    )

    val popularMealsList: List<Pair<Int, String>> = listOf(
        Pair(R.drawable.veg_thali, "Veg Thali"),
        Pair(R.drawable.briyani, "Biryani"),
        Pair(R.drawable.chicken_thali, "Chicken Thali"),
        Pair(R.drawable.pulao, "Pulao"),
        Pair(R.drawable.briyani2, "Biryani"),
    )

    val offersList: List<Pair<Int, String>> = listOf(
        Pair(R.drawable.offer2, ""),
        Pair(R.drawable.offer1, "")
    )

    val list = listOf(
        R.drawable.details,
        R.drawable.details1,
        R.drawable.details,
        R.drawable.details1,
        R.drawable.details,
        R.drawable.details1,
        R.drawable.details,
        R.drawable.details1,
        R.drawable.details,
        R.drawable.details1,
        R.drawable.details,
        R.drawable.details1,
        R.drawable.details,
        R.drawable.details1,
    )

    val restraunts = listOf(
        restraunt(R.drawable.restaurnt1, listOf(R.drawable.r1,R.drawable.r1_2)),
        restraunt(R.drawable.restraunt2, listOf(R.drawable.r2,R.drawable.r2_2)),
        restraunt(R.drawable.restaurnt1, listOf(R.drawable.r1,R.drawable.r1_2)),
        restraunt(R.drawable.restraunt2, listOf(R.drawable.r2,R.drawable.r2_2)),
        restraunt(R.drawable.restaurnt1, listOf(R.drawable.r1,R.drawable.r1_2)),
        restraunt(R.drawable.restraunt2, listOf(R.drawable.r2,R.drawable.r2_2)),
        )

    var layout:Int = 0
}