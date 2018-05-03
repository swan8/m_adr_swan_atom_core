package swan.atom.core.extentions

import android.graphics.Rect
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.View

fun RecyclerView.withAnyItemDecoration(space: Int, headerCount: Int): RecyclerView.ItemDecoration {
    return object : RecyclerView.ItemDecoration() {
        override fun getItemOffsets(outRect: Rect?, view: View?, parent: RecyclerView?, state: RecyclerView.State?) {
            when (parent?.layoutManager) {
                is GridLayoutManager -> {
                    outRect?.let { rect ->
                        rect.left = 0
                        rect.top = 0
                        rect.right = space
                        rect.bottom = space
                    }

                    val spanCount: Int = (layoutManager as GridLayoutManager).spanCount
                    val position: Int = parent.getChildAdapterPosition(view)
                    when (position) {
                        in 0 until spanCount -> {
                            outRect?.let { rect ->
                                rect.left = space.takeIf {
                                    position == headerCount
                                } ?: 0

                                rect.top = space.takeIf {
                                    headerCount == 0
                                } ?: 0

                                rect.right = space.takeIf {
                                    position > headerCount - 1
                                } ?: 0
                            }
                        }

                        else -> {
                            when (position % spanCount) {
                                headerCount -> {
                                    outRect?.left = space
                                }
                            }
                        }
                    }

                }

                is LinearLayoutManager -> {

                }

                is StaggeredGridLayoutManager -> {

                }

                else ->
                    super.getItemOffsets(outRect, view, parent, state)
            }
        }
    }
}