package au.edu.rmit.eventplanner;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import au.edu.rmit.eventplanner.domain.Event;

public class EventDisplayActivity extends AppCompatActivity {

    private ListView listView;
    private EventsListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_display);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AddEvent.class);
                startActivity(intent);
            }
        });
        listView = (ListView) findViewById(android.R.id.list);
        adapter = new EventsListAdapter(EventDisplayActivity.this, getData());
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_event_display, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private List<Event> getData() {
        List<Event> list = new ArrayList<>();

        Event e = new Event();
        e.setTitle("Poker Night");
        e.setLocation("Docklands");
        e.setStartDate("22, Aug");
        e.setStartTime("21:00");
        list.add(e);

        e = new Event();
        e.setTitle("Pot Luck");
        e.setLocation("Richmond");
        e.setStartDate("28, Aug");
        e.setStartTime("13:00");
        list.add(e);

        e = new Event();
        e.setTitle("Tambola Night");
        e.setLocation("Malvern");
        e.setStartDate("25, Aug");
        e.setStartTime("17:00");
        list.add(e);


        return list;
    }
}
