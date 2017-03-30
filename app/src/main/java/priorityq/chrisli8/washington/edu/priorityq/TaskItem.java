package priorityq.chrisli8.washington.edu.priorityq;

import android.support.annotation.NonNull;

import java.util.Comparator;

/**
 * Created by ChrisLi on 3/27/17.
 */

public class TaskItem implements Comparable<TaskItem>{
    private int priority;
    private int duration;
    private String name;

    public TaskItem(int priority, int duration, String name) {
        this.priority = priority;
        this.duration = duration;
        this.name = name;
    }

    public void setTaskName(String name) {
        if (name == null) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public String getTaskName() {
        return this.name;
    }

    public int getPriority() {
        return this.priority;
    }

    public int getDuration() {
        return this.duration;
    }

    @Override
    // compare priorities
    // if this task has higher priority than ti it is "bigger"
    public int compareTo(@NonNull TaskItem ti) {
        if (this.getPriority() < ti.getPriority()) {
            return -1;
        } else if (this.getPriority() > ti.getPriority()) {
            return 1;
        // priorities are equal, so compare duration
        // i.e. if this task is shorter than ti it is "bigger"
        } else {
            if (this.getDuration() < ti.getDuration()) {
                return 1;
            } else if (this.getDuration() > ti.getDuration()) {
                return -1;
            // Priority and duration are the same, so compare names
            } else {
                return this.getTaskName().compareTo(ti.getTaskName());
            }
        }
    }
}
