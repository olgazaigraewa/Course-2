package todolist;

public interface Repeatability {
    boolean SINGLE = false;
    boolean EVERYDAY = false;
    boolean WEEKLY = false;
    boolean MONTHLY = false;
    boolean YEARLY = false;

    void SINGLE();

    void EVERYDAY();

    void WEEKLY();

    void MONTHLY();

    void YEARLY();

}
