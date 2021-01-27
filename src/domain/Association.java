package domain;

import java.time.LocalDateTime;

public class Association {
    private boolean isConserved;
    private LocalDateTime ldt;

    public Association(boolean isConserved, LocalDateTime ldt) {
        this.isConserved = isConserved;
        this.ldt = ldt;
    }

    public boolean isConserved() {
        return isConserved;
    }

    public LocalDateTime getLdt() {
        return ldt;
    }
}
