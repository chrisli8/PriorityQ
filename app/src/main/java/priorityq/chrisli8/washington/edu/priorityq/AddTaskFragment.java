package priorityq.chrisli8.washington.edu.priorityq;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddTaskFragment extends Fragment {


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
    public void onStart() {
        super.onStart();
        final Activity act = getActivity();
        Button b = (Button) act.findViewById(R.id.save_task_btn);
        final EditText nameResponse = (EditText) act.findViewById(R.id
                .name_response);
        final EditText priorityResponse = (EditText) act.findViewById(R
                .id.priority_response);
        final EditText durationResponse = (EditText) act.findViewById(R
                .id.duration_response);
        b.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                String taskName = nameResponse.getText().toString();
                int taskPriority = Integer.parseInt(priorityResponse.getText
                        ().toString());
                int taskDuration = Integer.parseInt(durationResponse.getText
                        ().toString());
                if (act instanceof MainActivity) {
                    ((MainActivity) act).saveTaskToDB(taskName, taskPriority,
                            taskDuration);
                }
            }
        });
    }
}
