package hiber.model;

import javax.persistence.*;

@Entity
public class Car {
    private String model;

    @Id
    @GeneratedValue
    private int series;

    @OneToOne(mappedBy = "car", cascade = CascadeType.ALL)
    private User user;

    public Car() {}

    public Car(String model) {
        this.model = model;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public void setModel(String model) {
        this.model = model;
    }
    public void setUser(User user) {
        this.user = user;
    }

    @Id
    public int getSeries() {
        return series;
    }

    public String getModel() {
        return model;
    }
    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", series=" + series +
                ", user=" + user +
                '}';
    }
}
