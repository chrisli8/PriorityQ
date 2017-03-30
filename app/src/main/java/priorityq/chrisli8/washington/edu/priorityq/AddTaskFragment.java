package priorityq.chrisli8.washington.edu.priorityq;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddTaskFragment extends Fragment {
    public Button add;

    public AddTaskFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_task, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        add = (Button) view.findViewById(R.id.btn_add_task);

        // Need to set of onclick event
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainApp.getInstance().dataList.add(new TaskItem(1, 1, "Test"));
            }
        });
    }
}
