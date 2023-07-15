package model;

import java.sql.Date;

public class VaccineHistory {

    private String userName;
    private Boolean gender;
    private String nameVaccine;
    private String nameHospital;
    private String date;
    private String price;

    public VaccineHistory() {
    }

    public VaccineHistory(String userName, Boolean gender, String nameVaccine, String nameHospital, String date, String price) {
        this.userName = userName;
        this.gender = gender;
        this.nameVaccine = nameVaccine;
        this.nameHospital = nameHospital;
        this.date = date;
        this.price = price;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getNameVaccine() {
        return nameVaccine;
    }

    public void setNameVaccine(String nameVaccine) {
        this.nameVaccine = nameVaccine;
    }

    public String getNameHospital() {
        return nameHospital;
    }

    public void setNameHospital(String nameHospital) {
        this.nameHospital = nameHospital;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "VaccineHistory{" + "userName=" + userName + ", gender=" + gender + ", nameVaccine=" + nameVaccine + ", nameHospital=" + nameHospital + ", date=" + date + ", price=" + price + '}';
    }

    

}