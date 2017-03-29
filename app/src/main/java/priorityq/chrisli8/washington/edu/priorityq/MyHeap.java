package priorityq.chrisli8.washington.edu.priorityq;

/**
 * Created by ChrisLi on 3/27/17.
 * used to store list of item to do. Organized as a heap
 *
 * Caution: deep copy things
 */

public class MyHeap {
    private TaskItem[] data;
    private int endIndex;

    public MyHeap() {
        this.data = new TaskItem[11];
        // Leave first index open for math reasons
        this.endIndex = 0;
    }

    public void add(TaskItem task) {
        // [0, 1, 2]
        endIndex++;
        if(endIndex > 10) {
            // doubles capacity but keeps first index open
            TaskItem[] newData = new TaskItem[(data.length - 1) * 2 + 1];
            for (int i = 1; i < data.length; i++) {
                newData[i] = data[i];
            }
            this.data = newData;
        }
        data[endIndex] = task;

    }

    // To do: write pop
    public void pop() {
        if (endIndex < 1) {
            throw new IllegalArgumentException();
        }
        data[endIndex] = null;
        endIndex--;

    }

}
