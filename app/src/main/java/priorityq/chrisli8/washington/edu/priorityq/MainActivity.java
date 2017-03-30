package priorityq.chrisli8.washington.edu.priorityq;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private FragmentManager fragManager;
    private SQLiteDatabase db;
    private PriorityQueue<TaskItem> taskItems;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_dequeue);
                    fragManager.beginTransaction()
                            .replace(R.id.content, new DequeueTaskFragment())
                            .commit();
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_enqueue);
                    fragManager.beginTransaction()
                            .replace(R.id.content, new AddTaskFragment())
                            .commit();
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_task_list);
                    fragManager.beginTransaction()
                            .replace(R.id.content, new TaskListFragment())
                            .commit();
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragManager = getSupportFragmentManager();
        fragManager.beginTransaction()
                .replace(R.id.content, new DequeueTaskFragment())
                .commit();

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        this.db = openOrCreateDatabase("TASK_DB", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS TASK (taskId INTEGER PRIMARY KEY AUTOINCREMENT, taskName VARCHAR, taskPriority SMALLINT, taskDuration INT)");
    }

    // currently vulnerable to SQL injection
    void saveTaskToDB(String taskName, int taskPriority, int taskDuration) {
        db.execSQL("INSERT INTO TASK (taskName, taskPriority, " +
                "taskDuration) VALUES (\"" + taskName + "\", " +
                taskPriority + ", " + taskDuration + ");");
    }

    // Return a List of all TaskItems in the DB
    List<TaskItem> getAllTasksFromDB() {
        Cursor c = this.db.rawQuery("SELECT * FROM TASK", null);
        final List<TaskItem> list = new ArrayList<>();
        try {
            while (c.moveToNext()) {
                String taskName = c.getString(c.getColumnIndex("taskName"));
                int taskPriority = c.getInt(c.getColumnIndex
                        ("taskPriority"));
                int taskDuration = c.getInt(c.getColumnIndex
                        ("taskDuration"));
                TaskItem taskItem = new TaskItem(taskPriority, taskDuration,
                        taskName);
                list.add(taskItem);
            }
        } finally {
            c.close();
        }
        return list;
    }

}
