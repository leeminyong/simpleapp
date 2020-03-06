package com.aiden.andmodule.activity;

import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AbsListView.MultiChoiceModeListener;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.aiden.andmodule.R;
import com.aiden.andmodule.adapter.MultiListViewAdapter;
import com.aiden.andmodule.model.WorldPopulation;

import java.util.ArrayList;
import java.util.List;

public class MultiDelListActivity extends BaseActivity {

    // Declare Variables
    ListView list;
    MultiListViewAdapter listviewadapter;
    List<WorldPopulation> worldpopulationlist = new ArrayList<WorldPopulation>();
    String[] rank;
    String[] country;
    String[] population;
    int[] flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from listview_main.xml
        setContentView(R.layout.listview_main);

        // Generate sample data into string arrays
        rank = new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10","11", "12", "13", "14", "15", "16", "17", "18", "19", "20" };

        country = new String[] { "China", "India", "United States",
                "Indonesia", "Brazil", "Pakistan", "Nigeria", "Bangladesh",
                "Russia", "Japan","China", "India", "United States",
                "Indonesia", "Brazil", "Pakistan", "Nigeria", "Bangladesh",
                "Russia", "Japan" };

        population = new String[] { "1,354,040,000", "1,210,193,422",
                "315,761,000", "237,641,326", "193,946,886", "182,912,000",
                "170,901,000", "152,518,015", "143,369,806", "127,360,000",
                "1,354,040,000", "1,210,193,422",
                "315,761,000", "237,641,326", "193,946,886", "182,912,000",
                "170,901,000", "152,518,015", "143,369,806", "127,360,000"};

        flag = new int[] { R.drawable.cat, R.drawable.dog,
                           R.drawable.lion, R.drawable.tiger,
                R.drawable.cat, R.drawable.dog, R.drawable.lion,
                R.drawable.lion, R.drawable.tiger, R.drawable.cat,
                R.drawable.cat, R.drawable.dog,
                R.drawable.lion, R.drawable.tiger,
                R.drawable.cat, R.drawable.dog, R.drawable.lion,
                R.drawable.lion, R.drawable.tiger, R.drawable.cat};

        for (int i = 0; i < rank.length; i++) {
            WorldPopulation worldpopulation = new WorldPopulation(flag[i],
                    rank[i], country[i], population[i]);
            worldpopulationlist.add(worldpopulation);
        }

        // Locate the ListView in listview_main.xml
        list = (ListView) findViewById(R.id.listview);

        // Pass results to MultiListViewAdapter Class
        listviewadapter = new MultiListViewAdapter(this, R.layout.listview_item,
                worldpopulationlist);

        // Binds the Adapter to the ListView
        list.setAdapter(listviewadapter);
        list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        // Capture ListView item click
        list.setMultiChoiceModeListener(new MultiChoiceModeListener() {

            @Override
            public boolean onCreateActionMode(android.view.ActionMode mode, Menu menu) {
                mode.getMenuInflater().inflate(R.menu.del_list, menu);
                return true;
            }
            @Override
            public boolean onPrepareActionMode(android.view.ActionMode mode, Menu menu) { return false;    }

            @Override
            public boolean onActionItemClicked(android.view.ActionMode mode, MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.delete:
                        // Calls getSelectedIds method from MultiListViewAdapter Class
                        SparseBooleanArray selected = listviewadapter.getSelectedIds();
                        // Captures all selected ids with a loop
                        for (int i = (selected.size() - 1); i >= 0; i--) {
                            if (selected.valueAt(i)) {
                                WorldPopulation selecteditem = listviewadapter.getItem(selected.keyAt(i));
                                // Remove selected items following the ids
                                listviewadapter.remove(selecteditem);
                            }
                        }
                        // Close CAB
                        mode.finish();
                        return true;
                    default:
                        return false;
                }
            }

            @Override
            public void onDestroyActionMode(android.view.ActionMode mode) {
                listviewadapter.removeSelection();
            }
            @Override
            public void onItemCheckedStateChanged(android.view.ActionMode mode, int position, long id, boolean checked) {
                // Capture total checked items
                final int checkedCount = list.getCheckedItemCount();
                // Set the CAB title according to total checked items
                mode.setTitle(checkedCount + " Selected");
                // Calls toggleSelection method from MultiListViewAdapter Class
                listviewadapter.toggleSelection(position);
            }

        });
    }
}
