package priorityq.chrisli8.washington.edu.priorityq;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


/**
 * A simple {@link Fragment} subclass.
 */
public class TaskListFragment extends Fragment {
    public ListView listView;

    public TaskListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_task_list, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Get ListView object from xml
        listView = (ListView) view.findViewById(R.id.list);

        final Activity act = getActivity();
        List<TaskItem> taskList;
        if (act instanceof MainActivity) {
            taskList = ((MainActivity) act).getAllTasksFromDB();
        } else {
            taskList = new ArrayList<TaskItem>();
        }

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data

        //Default ArrayAdapter
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getContext(),
//                android.R.layout.simple_list_item_1, android.R.id.text1, values);


        // Assign adapter to ListView
        listView.setAdapter(new MyAdapter(this.getContext(), new
                PriorityQueue<TaskItem>(taskList)));
    }

}
