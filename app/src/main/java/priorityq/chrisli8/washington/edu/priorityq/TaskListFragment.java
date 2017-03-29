package priorityq.chrisli8.washington.edu.priorityq;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


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

        // Defined Array values to show in ListView
        String[] values = new String[] { "Android List View",
                "Adapter implementation",
                "Simple List View In Android",
                "Create List View Android",
                "Android Example",
                "List View Source Code",
                "List View Array Adapter",
                "Android Example List View",
                "More Stuff",
                "More Stuff",
                "More Stuff",
                "More Stuff",
                "More Stuff",
                "More Stuff"
        };

        TaskItem[] tasks = new TaskItem[] {
                new TaskItem(1, 4, "Task1"),
                new TaskItem(2, 10, "Task2"),
                new TaskItem(3, 30, "Task2"),
                new TaskItem(4, 1, "Task4"),
                new TaskItem(5, 3, "Task5"),
                new TaskItem(6, 5, "Task6"),
                new TaskItem(7, 20, "Task7"),
                new TaskItem(8, 15, "Task8"),
                new TaskItem(8, 15, "Task9"),
                new TaskItem(8, 15, "Task10"),
                new TaskItem(8, 15, "Task11"),
        };

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data

        //Default ArrayAdapter
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getContext(),
//                android.R.layout.simple_list_item_1, android.R.id.text1, values);


        // Assign adapter to ListView
        listView.setAdapter(new MyAdapter(this.getContext(), tasks));
    }

}
