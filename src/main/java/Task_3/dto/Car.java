package Task_3.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Objects;

@Entity(name = "com.example.sp.dto.Car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int carsId;

    private String mark;

    private String model;

    private int speed;

    private int price;

    public int getCarsId() {
        return carsId;
    }

    public void setCarsId(int carsId) {
        this.carsId = carsId;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return carsId == car.carsId && Objects.equals(mark, car.mark) && Objects.equals(model, car.model) && Objects.equals(speed, car.speed) && Objects.equals(price, car.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carsId, mark, model, speed, price);
    }
// Геттеры и сеттеры
}
