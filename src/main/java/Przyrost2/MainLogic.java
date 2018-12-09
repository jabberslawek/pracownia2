package Przyrost2;

import HibernateModel.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import jdk.nashorn.internal.runtime.ECMAException;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainLogic {

    private List<Brand> brandList = new ArrayList<Brand>();
    private List<BrandAmbassador> brandAmbassadorList = new ArrayList<>();
    private List<Category> categoryList = new ArrayList<>();
    private List<CompanyCar> companyCarList = new ArrayList<>();
    private List<Product> productList = new ArrayList<>();
    private String[] tableNames = {"Category", "Brand", "Product", "CompanyCar", "BrandAmbassador"};

    void getThemAll(EntityManager entityManager)  {

        for(String tableName: tableNames) {
            String str = "SELECT k FROM " + tableName + " k";
                Query query = entityManager.createQuery(str);
            if(tableName.equals("BrandAmbassador"))
                brandAmbassadorList = query.getResultList();
            if(tableName.equals("Category"))
                categoryList = query.getResultList();
            if(tableName.equals("Brand"))
                brandList = query.getResultList();
            if(tableName.equals("Product"))
                productList = query.getResultList();
            if(tableName.equals("CompanyCar"))
                companyCarList = query.getResultList();
        }
    }

    void printThemAll() {
        for(int i = 0; i < brandList.size(); i++) {
            System.out.println(brandList.get(i).toString());
        }
        for(int i = 0; i < companyCarList.size(); i++) {
            System.out.println(companyCarList.get(i).toString());
        }
        for(int i = 0; i < brandAmbassadorList.size(); i++) {
            System.out.println(brandAmbassadorList.get(i).toString());
        }
        for(int i = 0; i < categoryList.size(); i++) {
            System.out.println(categoryList.get(i).toString());
        }
        for(int i = 0; i < productList.size(); i++) {
            System.out.println(productList.get(i).toString());
        }
    }

    void addBrand(EntityManager entityManager) {
        entityManager.getTransaction().begin();
        Brand newBrand = new Brand();
        newBrand.setBrandName("Asus-" + new Random().nextInt() * 100);
        brandList.add(newBrand);
        entityManager.persist(newBrand);
        entityManager.flush();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    void addProduct(EntityManager entityManager) {
        entityManager.getTransaction().begin();
        Product newProduct = new Product();
        Category newCategory = entityManager.find(Category.class, 3);
        Brand newBrand = entityManager.find(Brand.class, 2);
        newProduct.setProducentId(newBrand);
        newProduct.setKategoriaId(newCategory);
        newProduct.setModel("X12-" + new Random().nextInt() + 10);
        productList.add(newProduct);
        entityManager.persist(newProduct);
        entityManager.flush();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    void addCategory(EntityManager entityManager) {
        entityManager.getTransaction().begin();
        Category newCategory = new Category();
        newCategory.setCategoryName("ABC-" + new Random().nextInt());
        entityManager.persist(newCategory);
        entityManager.flush();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    void addCompanyCar(EntityManager entityManager) {
        entityManager.getTransaction().begin();
        CompanyCar newCompanyCar = new CompanyCar();
        newCompanyCar.setCarModel("Fiesta-" + new Random().nextInt());
        newCompanyCar.setCarBrand("Ford-" + new Random().nextInt());
        //newCompanyCar.setRegistrationNumber("PO AB3" + new Random(99));
        companyCarList.add(newCompanyCar);
        entityManager.persist(newCompanyCar);
        entityManager.flush();
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("END");

    }

    void addBrandAmbassador(EntityManager entityManager) {
        entityManager.getTransaction().begin();
        BrandAmbassador newBrandAmbassador = new BrandAmbassador();
    }

    public static void serializeListDemo(ObjectMapper mapper, String fileSuffix, List objects) throws IOException {
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.writeValue(new File(objects.toString() + "." + fileSuffix), objects);

    }
}

