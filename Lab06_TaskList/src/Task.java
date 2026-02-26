import java.io.Serializable;
import java.util.Objects;

public class Task implements Serializable
{
    private String deadline, dueDate, name;
    private int priority;

    public Task()
    {
        this.deadline = "Default";
        this.dueDate = "Default";
        this.name = "Default";
        this.priority = 0;
    }

    public Task(String name, String dueDate, String deadline, int priority)
    {
        this.name = name;
        this.dueDate = dueDate;
        this.deadline = deadline;
        this.priority = priority;
    }

    public void setDueDate(String dueDate)
    {
        this.dueDate = dueDate;
    }

    public void setDeadline(String deadline)
    {
        this.deadline = deadline;
    }

    public void setPriority(int priority)
    {
        this.priority = priority;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public String getDueDate()
    {
        return dueDate;
    }

    public String getDeadline()
    {
        return deadline;
    }

    public int getPriority()
    {
        return priority;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return priority == task.priority && Objects.equals(deadline, task.deadline) && Objects.equals(dueDate, task.dueDate) && Objects.equals(name, task.name);
    }

    public String toString()
    {
        String priorityType;
        if (priority == 1)
            priorityType = "High";
        else if(priority == 2)
            priorityType = "Medium";
        else
            priorityType = "Low";

        return "Task [name=" + name + ", dueDate=" + dueDate +
                ", deadline=" + deadline + ", priority=" + priorityType + "]";
    }
}
