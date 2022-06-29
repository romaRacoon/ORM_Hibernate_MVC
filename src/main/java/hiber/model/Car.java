package hiber.model;

import javax.persistence.*;

@Table(name = "cars")
@Entity
public class Car {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "model")
    private String model;

    @Column(name = "series")
    private int series;

    public Car(){}

    public Car(String model, int series){
        this.model = model;
        this.series = series;
    }


    public int getSeries() {
        return series;
    }

    public String getModel() {
        return model;
    }
}
