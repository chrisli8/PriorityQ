package priorityq.chrisli8.washington.edu.priorityq;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private MyHeap tasks;
    private FragmentManager fragManager;

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

        tasks = new MyHeap();
        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
