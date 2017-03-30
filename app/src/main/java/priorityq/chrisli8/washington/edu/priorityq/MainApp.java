package priorityq.chrisli8.washington.edu.priorityq;

import android.app.Application;
import java.util.*;

/**
 * Created by ChrisLi on 3/29/17.
 */

public class MainApp extends Application {

    private static MainApp mInstance = null;

    //private static MainApp singleton;

    public ArrayList<TaskItem> dataList;

    private MainApp() {
        this.dataList = new ArrayList<TaskItem>();
    }

    public static MainApp getInstance(){
        if(mInstance == null)
        {
            mInstance = new MainApp();
        }
        return mInstance;
    }

    public ArrayList<TaskItem> getList() {
        return this.dataList;
    }
//    @Override
//    public void onCreate() {
//        dataList = new ArrayList<TaskItem>();
//
//        super.onCreate();
//        singleton = this; // need to look up singleton
//
//    }

}
