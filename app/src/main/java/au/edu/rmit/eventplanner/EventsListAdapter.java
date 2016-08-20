package au.edu.rmit.eventplanner;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import au.edu.rmit.eventplanner.domain.Event;

/**
 * Created by Ashish on 20/08/2016.
 */
public class EventsListAdapter  extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<Event> allevents;


    public EventsListAdapter(Activity activity, List allevents) {
        this.activity = activity;
        this.allevents = allevents;
    }

    @Override
    public int getCount() {
        return allevents.size();
    }

    @Override
    public Object getItem(int location) {
        return allevents.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.row_layout, null);

        TextView event = (TextView) convertView.findViewById(R.id.event);
        TextView date = (TextView) convertView.findViewById(R.id.date);
        TextView time = (TextView) convertView.findViewById(R.id.time);


        // getting movie data for the row
        Event currentItem = allevents.get(position);

        // title
        event.setText(currentItem.getTitle());
        date.setText(currentItem.getStartDate() + "-" + currentItem.getStartTime());
        time.setText(currentItem.getLocation());

        return convertView;
    }
}
