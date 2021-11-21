package sv.edu.catolica.gabsshopapp.models;

import java.io.Serializable;

public class MyCartModel implements Serializable {

    String currentTime;
    String currentDate;
    String productName;
    String productPrice;

    public MyCartModel() {
    }

    public MyCartModel(String currentTime, String currentDate, String productName, String productPrice) {
        this.currentTime = currentTime;
        this.currentDate = currentDate;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }
}
