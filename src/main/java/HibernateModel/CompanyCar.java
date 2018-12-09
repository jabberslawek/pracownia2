package HibernateModel;

import javax.persistence.*;

@Entity
@Table(name = "companycar")

public class CompanyCar {

    @Id @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "Numer_rejestracyjny")
    private String registrationNumber;

    @Column(name = "Marka_pojazdu")
    private String carBrand;

    @Column(name = "Model_pojazdu")
    private String carModel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    @Override
    public String toString() {
        return "CompanyCar{" +
                "id=" + id +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", carBrand='" + carBrand + '\'' +
                ", carModel='" + carModel + '\'' +
                '}';
    }
}
