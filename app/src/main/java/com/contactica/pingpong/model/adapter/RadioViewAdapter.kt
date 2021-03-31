package com.contactica.pingpong.model.adapter

import android.content.Context
import android.view.*
import android.widget.TextView
import com.contactica.pingpong.R
import com.contactica.pingpong.model.Radio


/**
 * Adapter is the declaration of the recyclerview list item
 */
class RadioViewAdapter(private val mContext: Context, private val mData: List<Radio>) :
    androidx.recyclerview.widget.RecyclerView.Adapter<RadioViewAdapter.RadioViewHolder>() {

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RadioViewHolder {
        val view: View
        val mInflater = LayoutInflater.from(mContext)
        view = mInflater.inflate(R.layout.radio_list_view, parent, false)
        return RadioViewHolder(view)
    }

    override fun onBindViewHolder(holder: RadioViewHolder, position: Int) {
        val radioURl = mData[position].radioURL
        val radioTitle = mData[position].radioName
        val radioId = mData[position].uid.toString()

        holder.radioTitleText.text = radioTitle
        holder.radioURLText.text = radioURl
        holder.uuid.text = radioId

    }

    interface ClickListener {
        fun onClick(view: View, position: Int)
    }

    internal class RecyclerTouchListener(
        context: Context,
        private val clicker: ClickListener?
    ) : androidx.recyclerview.widget.RecyclerView.OnItemTouchListener {
        private val gestureDetector: GestureDetector =
            GestureDetector(context, object : GestureDetector.SimpleOnGestureListener() {
                override fun onSingleTapUp(e: MotionEvent): Boolean {
                    return true
                }
            })

        override fun onInterceptTouchEvent(
            rv: androidx.recyclerview.widget.RecyclerView,
            e: MotionEvent
        ): Boolean {
            val child = rv.findChildViewUnder(e.x, e.y)
            if (child != null && clicker != null && gestureDetector.onTouchEvent(e)) {
                clicker.onClick(child, rv.getChildAdapterPosition(child))
            }
            return false
        }

        override fun onTouchEvent(rv: androidx.recyclerview.widget.RecyclerView, e: MotionEvent) {

        }

        override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {

        }
    }

    class RadioViewHolder(itemView: View) :
        androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {
        internal var uuid: TextView = itemView.findViewById(R.id.uuid) as TextView
        internal var radioTitleText: TextView =
            itemView.findViewById(R.id.radioTitleView) as TextView
        internal var radioURLText: TextView = itemView.findViewById(R.id.radioUrlView) as TextView
    }
}