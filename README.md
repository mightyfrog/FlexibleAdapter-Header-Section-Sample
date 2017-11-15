# FlexibleAdapter-Header-Section-Sample
A FlexibleAdapter sticky header-section sample.



 .../android/flexibleadapterheadersectionsample/HeaderItem.kt   |  4 ++++
 .../android/flexibleadapterheadersectionsample/MainActivity.kt | 10 +++++++---
 app/src/main/res/layout/section.xml                            |  5 ++---
 3 files changed, 13 insertions(+), 6 deletions(-)

diff --git a/app/src/main/java/org/mightyfrog/android/flexibleadapterheadersectionsample/HeaderItem.kt b/app/src/main/java/org/mightyfrog/android/flexibleadapterheadersectionsample/HeaderItem.kt
index b54612b..c404ccc 100644
--- a/app/src/main/java/org/mightyfrog/android/flexibleadapterheadersectionsample/HeaderItem.kt
+++ b/app/src/main/java/org/mightyfrog/android/flexibleadapterheadersectionsample/HeaderItem.kt
@@ -24,5 +24,9 @@ data class HeaderItem(private val title: String) : AbstractHeaderItem<HeaderItem
 
         var title: TextView = view.findViewById(R.id.title)
         var subtitle: TextView = view.findViewById(R.id.subtitle)
+
+        init {
+            setFullSpan(true)
+        }
     }
 }
diff --git a/app/src/main/java/org/mightyfrog/android/flexibleadapterheadersectionsample/MainActivity.kt b/app/src/main/java/org/mightyfrog/android/flexibleadapterheadersectionsample/MainActivity.kt
index 7612f4d..a148aed 100644
--- a/app/src/main/java/org/mightyfrog/android/flexibleadapterheadersectionsample/MainActivity.kt
+++ b/app/src/main/java/org/mightyfrog/android/flexibleadapterheadersectionsample/MainActivity.kt
@@ -5,7 +5,7 @@ import android.support.v7.app.AppCompatActivity
 import android.support.v7.widget.RecyclerView
 import eu.davidea.flexibleadapter.FlexibleAdapter
 import eu.davidea.flexibleadapter.common.FlexibleItemDecoration
-import eu.davidea.flexibleadapter.common.SmoothScrollLinearLayoutManager
+import eu.davidea.flexibleadapter.common.SmoothScrollStaggeredLayoutManager
 import eu.davidea.flexibleadapter.items.AbstractFlexibleItem
 import kotlinx.android.synthetic.main.activity_main.*
 
@@ -16,6 +16,10 @@ import kotlinx.android.synthetic.main.activity_main.*
  */
 class MainActivity : AppCompatActivity() {
 
+    companion object {
+        const val spanCount = 3
+    }
+
     private val sampleData = mutableListOf<AbstractFlexibleItem<*>>().apply {
         val canada = HeaderItem("Canada")
         val provinces = listOf(
@@ -65,8 +69,8 @@ class MainActivity : AppCompatActivity() {
             adapter = FlexibleAdapter<AbstractFlexibleItem<*>>(sampleData, this)
                     .setDisplayHeadersAtStartUp(true)
                     .setStickyHeaders(true)
-            layoutManager = SmoothScrollLinearLayoutManager(context)
-            addItemDecoration(FlexibleItemDecoration(context).addItemViewType(R.layout.section, 0, 1, 0, 1))
+            layoutManager = SmoothScrollStaggeredLayoutManager(context, spanCount)
+            addItemDecoration(FlexibleItemDecoration(context).addItemViewType(R.layout.section, 1, 1, 1, 1))
             setHasFixedSize(true)
         }
     }
diff --git a/app/src/main/res/layout/section.xml b/app/src/main/res/layout/section.xml
index 30faac3..4205f1c 100644
--- a/app/src/main/res/layout/section.xml
+++ b/app/src/main/res/layout/section.xml
@@ -1,16 +1,15 @@
 <?xml version="1.0" encoding="utf-8"?>
 <FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
     android:layout_width="match_parent"
-    android:layout_height="?android:attr/listPreferredItemHeight"
+    android:layout_height="wrap_content"
     android:background="#ffff">
 
     <TextView
         android:id="@+id/title"
         android:layout_width="match_parent"
         android:layout_height="match_parent"
-        android:layout_marginEnd="16dp"
-        android:layout_marginStart="16dp"
         android:gravity="center_vertical"
+        android:padding="16dp"
         android:textAppearance="@style/TextAppearance.AppCompat.Title" />
 
 </FrameLayout>
