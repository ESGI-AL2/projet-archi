package model;

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


}
