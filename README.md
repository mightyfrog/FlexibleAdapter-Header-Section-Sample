# FlexibleAdapter-Header-Section-Sample
A FlexibleAdapter sticky header-section sample.



 .../android/flexibleadapterheadersectionsample/SectionItem.kt       | 6 ++++++
 1 file changed, 6 insertions(+)

diff --git a/app/src/main/java/org/mightyfrog/android/flexibleadapterheadersectionsample/SectionItem.kt b/app/src/main/java/org/mightyfrog/android/flexibleadapterheadersectionsample/SectionItem.kt
index f5bcd34..45418a3 100644
--- a/app/src/main/java/org/mightyfrog/android/flexibleadapterheadersectionsample/SectionItem.kt
+++ b/app/src/main/java/org/mightyfrog/android/flexibleadapterheadersectionsample/SectionItem.kt
@@ -12,8 +12,14 @@ import eu.davidea.viewholders.FlexibleViewHolder
  */
 data class SectionItem(private val title: String, private val headerItem: HeaderItem) : AbstractFlexibleItem<SectionItem.ViewHolder>(), ISectionable<SectionItem.ViewHolder, HeaderItem> {
 
+    companion object {
+        val us = HeaderItem("US")
+    }
+
     override fun getLayoutRes(): Int = R.layout.section
 
+    override fun getSpanSize(spanCount: Int, position: Int) = if (headerItem == us) 2 else 3
+
     override fun getHeader(): HeaderItem = headerItem
 
     override fun setHeader(headerItem: HeaderItem) {
