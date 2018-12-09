package HibernateModel;

import javax.persistence.*;

@Entity
@Table(name="brand")
public class Brand {

    @Id @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "Nazwa")
    private String brandName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", brandName='" + brandName + '\'' +
                '}';
    }
}
