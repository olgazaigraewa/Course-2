package todolist;

import java.time.LocalDate;

public interface Repeatability {

   boolean appearsIn(LocalDate localDate);

   RepeatTask getRepeatabilityType();


}