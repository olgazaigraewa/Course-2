package todolist;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class SinglTask extends Task {
    public SinglTask(String title, TypeTask typeTask, String taskContent, LocalDateTime taskDateTime) {
        super(title, typeTask, taskContent, taskDateTime);
    }

    @Override
    public boolean appearsIn(LocalDate localDate) {
        return localDate.equals(this.getTaskDateTime().toLocalDate());
    }

    @Override
    public RepeatTask getRepeatabilityType() {
        return RepeatTask.SINGLE;
    }




}

