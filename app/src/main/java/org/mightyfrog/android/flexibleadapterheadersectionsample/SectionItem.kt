package org.mightyfrog.android.flexibleadapterheadersectionsample

import android.view.View
import android.widget.TextView
import eu.davidea.flexibleadapter.FlexibleAdapter
import eu.davidea.flexibleadapter.items.AbstractFlexibleItem
import eu.davidea.flexibleadapter.items.ISectionable
import eu.davidea.viewholders.FlexibleViewHolder

/**
 * @author Shigehiro Soejima
 */
data class SectionItem(private val title: String, private val headerItem: HeaderItem) : AbstractFlexibleItem<SectionItem.ViewHolder>(), ISectionable<SectionItem.ViewHolder, HeaderItem> {

    companion object {
        val us = HeaderItem("US")
    }

    override fun getLayoutRes(): Int = R.layout.section

    override fun getSpanSize(spanCount: Int, position: Int) = if (headerItem == us) 2 else 3

    override fun getHeader(): HeaderItem = headerItem

    override fun setHeader(headerItem: HeaderItem) {
        // no-op, passed as a constructor argument
    }

    override fun createViewHolder(view: View, adapter: FlexibleAdapter<*>): ViewHolder = ViewHolder(view, adapter)

    override fun bindViewHolder(adapter: FlexibleAdapter<*>, holder: ViewHolder, position: Int, payloads: List<*>) {
        holder.title.text = title
    }

    class ViewHolder(view: View, adapter: FlexibleAdapter<*>) : FlexibleViewHolder(view, adapter) {

        var title: TextView = view.findViewById(R.id.title)
    }
}
