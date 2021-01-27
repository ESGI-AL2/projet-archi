package domain;

import java.time.LocalDateTime;

public class Choice {
    private Order order;
    private boolean isConserved;
    private LocalDateTime ldt;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public boolean isConserved() {
        return isConserved;
    }

    public void setConserved(boolean isConserved) {
        this.isConserved = isConserved;
    }

    public LocalDateTime getLdt() {
        return ldt;
    }

    public void setLdt(LocalDateTime ldt) {
        this.ldt = ldt;
    }

    public Choice(Order order, boolean isConserved, LocalDateTime ldt) {
        this.order = order;
        this.isConserved = isConserved;
        this.ldt = ldt;
    }
    public void print () {
        if (isConserved) System.out.println("Billet n°".concat(Integer.toString(order.getId())).concat(" a été conservé par ").concat(order.getUser().getFirstName()).concat (" ").concat(order.getUser().getLastName()).concat(" le ").concat(ldt.toString()));
        if (!isConserved) System.out.println("Billet n°".concat(Integer.toString(order.getId())).concat(" n'a pas été conservé par ").concat(order.getUser().getFirstName()).concat (" ").concat(order.getUser().getLastName()).concat(" le ").concat(ldt.toString()));
    }


}
