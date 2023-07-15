package model;

public class Appointment {
    private int idAppointment;
    private int idUserVaccineA;
    private String username;
    private String vaccineName;
    private String hospitalName;
    private double price;
    private String gender;
    private String date;
    private String startAt;
    private String endAt;

    public Appointment() {
    }

    public Appointment(int idAppointment, int idUserVaccineA, String username, String vaccineName, String hospitalName, double price, String gender, String date, String startAt, String endAt) {
        this.idAppointment = idAppointment;
        this.idUserVaccineA = idUserVaccineA;
        this.username = username;
        this.vaccineName = vaccineName;
        this.hospitalName = hospitalName;
        this.price = price;
        this.gender = gender;
        this.date = date;
        this.startAt = startAt;
        this.endAt = endAt;
    }

    public int getIdAppointment() {
        return idAppointment;
    }

    public void setIdAppointment(int idAppointment) {
        this.idAppointment = idAppointment;
    }

    public int getIdUserVaccineA() {
        return idUserVaccineA;
    }

    public void setIdUserVaccineA(int idUserVaccineA) {
        this.idUserVaccineA = idUserVaccineA;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartAt() {
        return startAt;
    }

    public void setStartAt(String startAt) {
        this.startAt = startAt;
    }

    public String getEndAt() {
        return endAt;
    }

    public void setEndAt(String endAt) {
        this.endAt = endAt;
    }

    @Override
    public String toString() {
        return "Appointment{" + "idAppointment=" + idAppointment + ", idUserVaccineA=" + idUserVaccineA + ", username=" + username + ", vaccineName=" + vaccineName + ", hospitalName=" + hospitalName + ", price=" + price + ", gender=" + gender + ", date=" + date + ", startAt=" + startAt + ", endAt=" + endAt + '}';
    }


}
