package com.chris.byteflow.tool.base.custom

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView


class GridGapItemDecoration(
    private val gap: Int,
    private val includeEdge: Boolean = false
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        (parent.layoutManager as? GridLayoutManager)?.run {
            val position = parent.getChildAdapterPosition(view)
            if (position >= 0) {
                val column = position % spanCount
                if (orientation == RecyclerView.HORIZONTAL) {
                    if (includeEdge) {
                        outRect.top = gap - column * gap / spanCount
                        outRect.bottom = (column + 1) * gap / spanCount
                        if (position < spanCount) {
                            if (reverseLayout) outRect.right = gap
                            else outRect.left = gap
                        }
                        if (reverseLayout) outRect.left = gap
                        else outRect.right = gap
                    } else {
                        outRect.top = column * gap / spanCount
                        outRect.bottom = gap - (column + 1) * gap / spanCount
                        if (position >= spanCount) {
                            if (reverseLayout) outRect.right = gap
                            else outRect.left = gap
                        }
                    }
                } else {
                    if (includeEdge) {
                        outRect.left = gap - column * gap / spanCount
                        outRect.right = (column + 1) * gap / spanCount
                        if (position < spanCount) {
                            if (reverseLayout) outRect.bottom = gap
                            else outRect.top = gap
                        }
                        if (reverseLayout) outRect.top = gap
                        else outRect.bottom = gap
                    } else {
                        outRect.left = column * gap / spanCount
                        outRect.right = gap - (column + 1) * gap / spanCount
                        if (position >= spanCount) {
                            if (reverseLayout) outRect.bottom = gap
                            else outRect.top = gap
                        }
                    }
                }
            } else {
                outRect.left = 0
                outRect.right = 0
                outRect.top = 0
                outRect.bottom = 0
            }
        }
    }
}