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

    private val images = listOf(
        R.drawable.android,
        R.drawable.flutter,
        R.drawable.react,
        R.drawable.xamarin
    )

    private var animation: Int = 0

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(
                viewGroup.context
            ).inflate(
                R.layout.complex_list_item_view_holder, viewGroup,
                false
            )
        )
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

    }

    override fun onViewAttachedToWindow(viewHolder: ViewHolder) {
        viewHolder.itemView.findViewById<ImageView>(
            R.id.complex_list_item_view_holder_icon
        ).run {
            setImageResource(images[viewHolder.adapterPosition.mod(4)])

            this@ComplexListAdapter.animation = if (viewHolder.adapterPosition.mod(2) == 0) {
                R.anim.rotate
            } else {
                R.anim.scale
            }

            AnimationUtils.loadAnimation(
                context,
                this@ComplexListAdapter.animation
            ).also { animation ->
                startAnimation(
                    animation
                )
            }
        }

        super.onViewAttachedToWindow(viewHolder)
    }

    override fun getItemCount() = dataSet.size
}