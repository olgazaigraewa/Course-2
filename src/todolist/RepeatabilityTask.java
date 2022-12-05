package todolist;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class RepeatabilityTask implements Repeatability {
    public static RepeatabilityTask SINGLE;
    public static RepeatabilityTask EVERYDAY;
    public static RepeatabilityTask WEEKLY;
    public static RepeatabilityTask MONTHLY;
    public static RepeatabilityTask YEARLY;
    private static RepeatabilityTask[] VALUES = new RepeatabilityTask[5];
    private  String format;
    private int number;

    public RepeatabilityTask(String format, int number) {
        this.format = format;
        this.number = number;
    }

    {
        SINGLE = new RepeatabilityTask("Единичная", 0);
        EVERYDAY = new RepeatabilityTask("Ежедневная", 1);
        WEEKLY = new RepeatabilityTask("Еженедельная", 2);
        MONTHLY = new RepeatabilityTask("Ежемесячная", 3);
        YEARLY = new RepeatabilityTask("Ежегодная", 4);
        VALUES = new RepeatabilityTask[]{SINGLE, EVERYDAY, WEEKLY, MONTHLY, YEARLY};
    }


    public static RepeatabilityTask[] values() {
        return VALUES.clone();
    }

    public RepeatabilityTask[] valueOf(String format) {
        return RepeatabilityTask.values();
    }


    @Override
    public void SINGLE() {
        LocalDate date = LocalDate.now();
        System.out.println(date);
    }

    @Override
    public void EVERYDAY() {
        LocalDate date = LocalDate.now();
        System.out.println(date.plusDays(1));

    }

    @Override
    public void WEEKLY() {
        LocalDate date = LocalDate.now();
        System.out.println(date.plusWeeks(1));
    }

    @Override
    public void MONTHLY() {
        LocalDate date = LocalDate.now();
        System.out.println(date.plusMonths(1));
    }

    @Override
    public void YEARLY() {
        LocalDate date = LocalDate.now();
        System.out.println(date.plusYears(1));
    }
}
