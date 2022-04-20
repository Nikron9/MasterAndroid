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

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        init {
            // Define click listener for the ViewHolder's View.
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.complex_list_item_view_holder, viewGroup, false)

        view.findViewById<ImageView>(R.id.complex_list_item_view_holder_icon).run {
            AnimationUtils.loadAnimation(context, R.anim.rotate).also { animation ->
                startAnimation(animation)
            }
        }

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemView.findViewById<ImageView>(R.id.complex_list_item_view_holder_icon).run {
            AnimationUtils.loadAnimation(context, R.anim.rotate).also { animation ->
                startAnimation(animation)
            }
        }
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
//        viewHolder.textView.text = dataSet[position]
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}