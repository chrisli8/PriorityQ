package priorityq.chrisli8.washington.edu.priorityq;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.*;

import org.w3c.dom.Text;

/**
 * Created by ChrisLi on 3/29/17.
 */

public class MyAdapter extends BaseAdapter {

    Context context;
    ArrayList<TaskItem> data;
    private static LayoutInflater inflater = null;

    public MyAdapter(Context context, ArrayList<TaskItem> data) {
        // TODO Auto-generated constructor stub
        this.context = context;
        this.data = data;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View vi = convertView;
        if (vi == null)
            vi = inflater.inflate(R.layout.listitem_task, null);

        // Set Header
        TextView text = (TextView) vi.findViewById(R.id.listitem_header);
        text.setText(data.get(position).getTaskName());

        // Set Priority
        TextView priority = (TextView) vi.findViewById(R.id.listitem_priority);
        priority.setText("" + data.get(position).getPriority()); // String concat to prevent errors

        // Set Duration
        TextView duration = (TextView) vi.findViewById(R.id.listitem_time);
        duration.setText("" + data.get(position).getDuration() + " min"); // String concat to prevent errors

        return vi;
    }


}
