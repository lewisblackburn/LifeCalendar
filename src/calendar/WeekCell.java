package calendar;

import java.time.LocalDate;

public class WeekCell {
    private final int index;
    private final LocalDate date;
    private boolean isLived;
    private boolean isCurrent;

    public WeekCell(int index,  LocalDate date) {
        this.index = index;
        this.date = date;
    }

    public int getIndex() { return index; }
    public LocalDate getDate() { return date; }

    public boolean isLived() { return isLived; }
    public void  setLived(boolean isLived) { this.isLived = isLived; }

    public boolean isCurrent() { return isCurrent; }
    public void  setCurrent(boolean isCurrent) { this.isCurrent = isCurrent; }
}
