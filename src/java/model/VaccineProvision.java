package model;

public class VaccineProvision {

    private int idVaccine;
    private String name;
    private String detail;
    private double pricePerService;
    private String img;
    private String nameH;
    private int idHVP;

    public VaccineProvision() {
    }

    public VaccineProvision(int idVaccine, String name, String detail, double pricePerService, String img, String nameH) {
        this.idVaccine = idVaccine;
        this.name = name;
        this.detail = detail;
        this.pricePerService = pricePerService;
        this.img = img;
        this.nameH = nameH;
    }

    public VaccineProvision(int idVaccine, String name, String detail, double pricePerService, String nameH) {
        this.idVaccine = idVaccine;
        this.name = name;
        this.detail = detail;
        this.pricePerService = pricePerService;
        this.nameH = nameH;
    }

    public VaccineProvision(String img, double pricePerService, int idVaccine, int idHVP) {
        this.img = img;
        this.pricePerService = pricePerService;
        this.idVaccine = idVaccine;
        this.idHVP = idHVP;

    }

    public int getIdHVP() {
        return idHVP;
    }

    public void setIdHVP(int idHVP) {
        this.idHVP = idHVP;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getIdVaccine() {
        return idVaccine;
    }

    public void setIdVaccine(int idVaccine) {
        this.idVaccine = idVaccine;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public double getPricePerService() {
        return pricePerService;
    }

    public void setPricePerService(double pricePerService) {
        this.pricePerService = pricePerService;
    }

    public String getNameH() {
        return nameH;
    }

    public void setNameH(String nameH) {
        this.nameH = nameH;
    }

    @Override
    public String toString() {
        return "VaccineProvision{" + "idVaccine=" + idVaccine + ", name=" + name + ", detail=" + detail + ", pricePerService=" + pricePerService + ", img=" + img + ", nameH=" + nameH + ", idHVP=" + idHVP + '}';
    }

}