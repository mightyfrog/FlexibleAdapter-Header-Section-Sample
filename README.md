# FlexibleAdapter-Header-Section-Sample
A FlexibleAdapter sticky header-section sample.



 .../flexibleadapterheadersectionsample/HeaderItem.kt      |  2 ++
 .../flexibleadapterheadersectionsample/MainActivity.kt    | 15 ++++++++++++---
 2 files changed, 14 insertions(+), 3 deletions(-)

diff --git a/app/src/main/java/org/mightyfrog/android/flexibleadapterheadersectionsample/HeaderItem.kt b/app/src/main/java/org/mightyfrog/android/flexibleadapterheadersectionsample/HeaderItem.kt
index b54612b..808e145 100644
--- a/app/src/main/java/org/mightyfrog/android/flexibleadapterheadersectionsample/HeaderItem.kt
+++ b/app/src/main/java/org/mightyfrog/android/flexibleadapterheadersectionsample/HeaderItem.kt
@@ -13,6 +13,8 @@ data class HeaderItem(private val title: String) : AbstractHeaderItem<HeaderItem
 
     override fun getLayoutRes() = R.layout.header
 
+    override fun getSpanSize(spanCount: Int, position: Int) = spanCount
+
     override fun createViewHolder(view: View, adapter: FlexibleAdapter<*>): ViewHolder = ViewHolder(view, adapter)
 
     override fun bindViewHolder(adapter: FlexibleAdapter<*>, holder: ViewHolder, position: Int, payloads: List<*>) {
diff --git a/app/src/main/java/org/mightyfrog/android/flexibleadapterheadersectionsample/MainActivity.kt b/app/src/main/java/org/mightyfrog/android/flexibleadapterheadersectionsample/MainActivity.kt
index 7612f4d..fbcc403 100644
--- a/app/src/main/java/org/mightyfrog/android/flexibleadapterheadersectionsample/MainActivity.kt
+++ b/app/src/main/java/org/mightyfrog/android/flexibleadapterheadersectionsample/MainActivity.kt
@@ -2,10 +2,11 @@ package org.mightyfrog.android.flexibleadapterheadersectionsample
 
 import android.os.Bundle
 import android.support.v7.app.AppCompatActivity
+import android.support.v7.widget.GridLayoutManager
 import android.support.v7.widget.RecyclerView
 import eu.davidea.flexibleadapter.FlexibleAdapter
 import eu.davidea.flexibleadapter.common.FlexibleItemDecoration
-import eu.davidea.flexibleadapter.common.SmoothScrollLinearLayoutManager
+import eu.davidea.flexibleadapter.common.SmoothScrollGridLayoutManager
 import eu.davidea.flexibleadapter.items.AbstractFlexibleItem
 import kotlinx.android.synthetic.main.activity_main.*
 
@@ -16,6 +17,10 @@ import kotlinx.android.synthetic.main.activity_main.*
  */
 class MainActivity : AppCompatActivity() {
 
+    companion object {
+        const val spanCount = 2
+    }
+
     private val sampleData = mutableListOf<AbstractFlexibleItem<*>>().apply {
         val canada = HeaderItem("Canada")
         val provinces = listOf(
@@ -65,8 +70,12 @@ class MainActivity : AppCompatActivity() {
             adapter = FlexibleAdapter<AbstractFlexibleItem<*>>(sampleData, this)
                     .setDisplayHeadersAtStartUp(true)
                     .setStickyHeaders(true)
-            layoutManager = SmoothScrollLinearLayoutManager(context)
-            addItemDecoration(FlexibleItemDecoration(context).addItemViewType(R.layout.section, 0, 1, 0, 1))
+            layoutManager = SmoothScrollGridLayoutManager(context, spanCount).apply {
+                spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
+                    override fun getSpanSize(position: Int) = (adapter as FlexibleAdapter<*>).getItem(position)!!.getSpanSize(spanCount, position)
+                }
+            }
+            addItemDecoration(FlexibleItemDecoration(context).addItemViewType(R.layout.section, 1, 1, 1, 1))
             setHasFixedSize(true)
         }
     }
