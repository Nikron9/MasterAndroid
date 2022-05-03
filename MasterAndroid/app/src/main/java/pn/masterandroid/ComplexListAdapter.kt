package pn.masterandroid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class ComplexListAdapter(
    private val dataSet: Array<String>
) : RecyclerView.Adapter<ComplexListAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(
                viewGroup.context
            ).inflate(
                R.layout.complex_list_item_view_holder, viewGroup,
                false
            ).also { view ->
                view.findViewById<ImageView>(
                    R.id.complex_list_item_view_holder_icon
                ).run {
                    AnimationUtils.loadAnimation(
                        context,
                        R.anim.rotate
                    ).also { animation ->
                        startAnimation(
                            animation
                        )
                    }
                }
            }
        )
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemView.findViewById<ImageView>(
            R.id.complex_list_item_view_holder_icon
        ).run {
            AnimationUtils.loadAnimation(
                context,
                R.anim.rotate
            ).also { animation ->
                startAnimation(
                    animation
                )
            }
        }
    }

    override fun getItemCount() = dataSet.size
}