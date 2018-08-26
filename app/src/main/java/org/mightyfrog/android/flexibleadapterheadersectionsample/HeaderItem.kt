package org.mightyfrog.android.flexibleadapterheadersectionsample

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import eu.davidea.flexibleadapter.FlexibleAdapter
import eu.davidea.flexibleadapter.items.AbstractHeaderItem
import eu.davidea.flexibleadapter.items.IFlexible
import eu.davidea.viewholders.FlexibleViewHolder

/**
 * @author Shigehiro Soejima
 */
data class HeaderItem(private val title: String) : AbstractHeaderItem<HeaderItem.ViewHolder>() {

    override fun getLayoutRes() = R.layout.header

    override fun createViewHolder(view: View?, adapter: FlexibleAdapter<IFlexible<RecyclerView.ViewHolder>>?) = ViewHolder(view, adapter)

    override fun bindViewHolder(adapter: FlexibleAdapter<IFlexible<RecyclerView.ViewHolder>>?, holder: ViewHolder?, position: Int, payloads: MutableList<Any>?) {
        holder?.also {
            it.title.text = title
            it.subtitle.text = holder.subtitle.context.getString(R.string.header_subtitle, adapter?.getSectionItems(this)?.size)
        }
    }

    class ViewHolder(view: View?, adapter: FlexibleAdapter<*>?) : FlexibleViewHolder(view, adapter, true) {
        var title: TextView = view?.findViewById(R.id.title)!!
        var subtitle: TextView = view?.findViewById(R.id.subtitle)!!
    }
}
