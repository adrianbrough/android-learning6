package uk.co.westcumbriandataandanalysis.android_learning6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListNotesActivity extends AppCompatActivity {

    private List<Note> notes = new ArrayList<Note>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_notes);

        notes.add(new Note("First Note", "XX", new Date()));
        notes.add(new Note("Second Note", "XX", new Date()));
        notes.add(new Note("Third Note", "XX", new Date()));
        notes.add(new Note("Fourth Note", "XX", new Date()));
        notes.add(new Note("Fifth Note", "XX", new Date()));
        notes.add(new Note("Sixth Note", "XX", new Date()));
        notes.add(new Note("X First Note", "XX", new Date()));
        notes.add(new Note("X Second Note", "XX", new Date()));
        notes.add(new Note("X Third Note", "XX", new Date()));
        notes.add(new Note("X Fourth Note", "XX", new Date()));
        notes.add(new Note("X Fifth Note", "XX", new Date()));
        notes.add(new Note("X Sixth Note", "XX", new Date()));

        populateList();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        notes.add(new Note("Added note", "Blah", new Date()));
        populateList();

        return true;
    }

    private void populateList() {
        ListView notesListView = (ListView)findViewById(R.id.notesListView);

        List<String> values = new ArrayList<String>();

        for(Note note: notes)
        {
            values.add(note.getTitle());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, android.R.id.text1, values);

        notesListView.setAdapter(adapter);
    }
}
