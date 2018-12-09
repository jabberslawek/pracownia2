package HibernateModel;

import Przyrost2.LocalDateConverter;
import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name = "brandambassador")

public class BrandAmbassador {

    @Id @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "Imie")
    private String name;

    @Column(name = "Nazwisko")
    private String surname;

    @Convert(converter = LocalDateConverter.class)
    @Column(name = "Data_zatrudnienia")
    private LocalDateTime employmentDate;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "producent_id", referencedColumnName = "id")
    private Brand producerId;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "samochod_id", referencedColumnName = "id")
    private CompanyCar carId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDateTime getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(LocalDateTime employmentDate) {
        this.employmentDate = employmentDate;
    }

    public Brand getProducerId() {
        return producerId;
    }

    public void setProducerId(Brand producerId) {
        this.producerId = producerId;
    }

    public CompanyCar getCarId() {
        return carId;
    }

    public void setCarId(CompanyCar carId) {
        this.carId = carId;
    }

    @Override
    public String toString() {
        return "BrandAmbassador{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", employmentDate=" + employmentDate +
                ", producerId=" + producerId +
                ", carId=" + carId +
                '}';
    }
}
