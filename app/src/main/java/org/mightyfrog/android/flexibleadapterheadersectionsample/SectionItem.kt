package org.mightyfrog.android.flexibleadapterheadersectionsample

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import eu.davidea.flexibleadapter.FlexibleAdapter
import eu.davidea.flexibleadapter.items.AbstractFlexibleItem
import eu.davidea.flexibleadapter.items.IFlexible
import eu.davidea.flexibleadapter.items.ISectionable
import eu.davidea.viewholders.FlexibleViewHolder

/**
 * @author Shigehiro Soejima
 */
data class SectionItem(private val title: String, private val headerItem: HeaderItem) : AbstractFlexibleItem<SectionItem.ViewHolder>(), ISectionable<SectionItem.ViewHolder, HeaderItem> {

    override fun getLayoutRes(): Int = R.layout.section

    override fun getHeader(): HeaderItem = headerItem

    override fun setHeader(headerItem: HeaderItem) {
        // no-op, passed as a constructor argument
    }

    override fun createViewHolder(view: View?, adapter: FlexibleAdapter<IFlexible<RecyclerView.ViewHolder>>?): ViewHolder = ViewHolder(view, adapter)

    override fun bindViewHolder(adapter: FlexibleAdapter<IFlexible<RecyclerView.ViewHolder>>?, holder: ViewHolder?, position: Int, payloads: MutableList<Any>?) {
        holder?.let {
            it.title.text = title
        }
    }

    class ViewHolder(view: View?, adapter: FlexibleAdapter<*>?) : FlexibleViewHolder(view, adapter) {

        var title: TextView = view?.findViewById(R.id.title)!!
    }
}
