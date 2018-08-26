package org.mightyfrog.android.flexibleadapterheadersectionsample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import eu.davidea.flexibleadapter.FlexibleAdapter
import eu.davidea.flexibleadapter.common.FlexibleItemDecoration
import eu.davidea.flexibleadapter.common.SmoothScrollLinearLayoutManager
import eu.davidea.flexibleadapter.items.AbstractFlexibleItem
import kotlinx.android.synthetic.main.activity_main.*

/**
 * A FlexibleAdapter sticky header-section sample.
 *
 * @author Shigehiro Soejima
 */
class MainActivity : AppCompatActivity() {

    private val sampleData = mutableListOf<AbstractFlexibleItem<*>>().apply {
        val canada = HeaderItem("Canada")
        val provinces = listOf(
                "Ontario", "Quebec", "British Columbia", "Alberta", "Manitoba", "Saskatchewan",
                "Nova Scotia", "New Brunswick", "Newfoundland and Labrador", "Prince Edward Island",
                "Northwest Territories", "Nunavut", "Yukon"
        )
        provinces.forEach {
            add(SectionItem(it, canada))
        }

        val japan = HeaderItem("Japan")
        val prefectures = listOf(
                "Hokkaidō", "Aomori", "Iwate", "Miyagi", "Akita", "Yamagata", "Fukushima", "Ibaraki",
                "Tochigi", "Gunma", "Saitama", "Chiba", "Tokyo", "Kanagawa", "Niigata", "Toyama",
                "Ishikawa", "Fukui", "Yamanashi", "Nagano", "Gifu", "Shizuoka", "Aichi", "Mie",
                "Shiga", "Kyoto", "Osaka", "Hyōgo", "Nara", "Wakayama", "Tottori", "Shimane",
                "Okayama", "Hiroshima", "Yamaguchi", "Tokushima", "Kagawa", "Ehime", "Kōchi",
                "Fukuoka", "Saga", "Nagasaki", "Kumamoto", "Ōita", "Miyazaki", "Kagoshima", "Okinawa"
        )
        prefectures.forEach {
            add(SectionItem(it, japan))
        }

        val us = HeaderItem("US")
        val states = listOf(
                "Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut",
                "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa",
                "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan",
                "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire",
                "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio",
                "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota",
                "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia",
                "Wisconsin", "Wyoming"
        )
        states.forEach {
            add(SectionItem(it, us))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        recyclerView.apply {
            adapter = FlexibleAdapter<AbstractFlexibleItem<*>>(sampleData, this)
                    .setDisplayHeadersAtStartUp(true)
                    .setStickyHeaders(true)
            layoutManager = SmoothScrollLinearLayoutManager(context)
            addItemDecoration(FlexibleItemDecoration(context).addItemViewType(R.layout.section, 0, 1, 0, 1))
            setHasFixedSize(true)
        }
    }
}
