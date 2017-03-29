package priorityq.chrisli8.washington.edu.priorityq;

/**
 * Created by ChrisLi on 3/27/17.
 */

public class TaskItem {
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
}
