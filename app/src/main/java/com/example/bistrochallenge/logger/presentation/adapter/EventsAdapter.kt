package com.example.bistrochallenge.logger.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bistrochallenge.R
import com.example.bistrochallenge.logger.domain.LifecycleEvent
import java.sql.Date
import java.text.DateFormat

class EventsAdapter(
    private var events: List<LifecycleEvent>
): RecyclerView.Adapter<EventsAdapter.EventViewHolder>() {

    class EventViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val eventText: TextView = view.findViewById(R.id.event_text)
        val timestampText: TextView = view.findViewById(R.id.timestamp_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            com.example.bistrochallenge.R.layout.log_item,
            parent,
            false
        )
        return EventViewHolder(view)
    }

    override fun getItemCount(): Int {
        return events.size
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val event = events[position]
        holder.eventText.text = event.eventName
        holder.timestampText.text = DateFormat.getDateTimeInstance().format(Date(event.timestamp))
    }

}