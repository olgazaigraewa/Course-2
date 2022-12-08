package todolist;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class WeeklyTask extends Task {
    public WeeklyTask(String title, TypeTask typeTask, String taskContent, LocalDateTime taskDateTime) {
        super(title, typeTask, taskContent, taskDateTime);
    }

    @Override
    public boolean appearsIn(LocalDate localDate) {
        LocalDate taskDate = this.getTaskDateTime().toLocalDate();
        return localDate.equals(taskDate) || (localDate.isAfter(taskDate)
                && localDate.getDayOfWeek().equals(taskDate.getDayOfWeek()));
    }

    @Override
    public RepeatTask getRepeatabilityType() {
        return RepeatTask.WEEKLY;
    }
}
