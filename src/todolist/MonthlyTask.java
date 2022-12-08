package todolist;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MonthlyTask extends Task {
    public MonthlyTask(String title, TypeTask typeTask, String taskContent, LocalDateTime taskDateTime) {
        super(title, typeTask, taskContent, taskDateTime);
    }

    @Override
    public boolean appearsIn(LocalDate localDate) {
        LocalDate taskDate = this.getTaskDateTime().toLocalDate();
        return localDate.equals(taskDate) || (localDate.isAfter(taskDate) && localDate.getDayOfMonth() == taskDate.getDayOfMonth());
    }

    @Override
    public RepeatTask getRepeatabilityType() {
        return RepeatTask.MONTHLY;
    }
}
