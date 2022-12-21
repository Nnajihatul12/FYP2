package com.example.flooddonationmanagement_najihatul;

public class FloodVictimModel {
    private String ngo;
    private String fullName;


    private String age;
    private String phoneNo;
    private String gender;
    private String occupation;
    private String incomeSalary;
    private String address1;
    private String address2;
    private String postCode;
    private String babyNo,childrenNo,teenagerNo,adultNo,elderlyNo,disabledPeopleNo;
    private String hygieneKits,cashAssitance,ambulanceService,houseCleaning,powerBank,foodAndWater,infrastructureMaintenance,medicineAndFirstAidsKits,electricalapp,clothsAndBlanket,diapersAndPads,candlesMatchAndTorchlight;

public FloodVictimModel() {
}

    public FloodVictimModel(String ngo, String fullName, String phoneNo, String gender,String age, String occupation, String incomeSalary, String Address1, String postCode, String babyNo, String childrenNo, String teenagerNo, String adultNo, String elderlyNo, String disabledPeopleNo, String hygieneKits, String cashAssitance, String ambulanceService, String houseCleaning, String powerBank, String foodAndWater, String infrastructureMaintenance, String medicineAndFirstAidsKits, String electricalapp, String clothsAndBlanket, String diapersAndPads, String candlesMatchAndTorchlight) {
        this.ngo = ngo;
        this.fullName = fullName;
        this.phoneNo = phoneNo;
        this.gender = gender;
        this.age = age;
        this.occupation = occupation;
        this.incomeSalary = incomeSalary;
        this.address1 = Address1;
        this.postCode = postCode;
        this.babyNo = babyNo;
        this.childrenNo = childrenNo;
        this.teenagerNo = teenagerNo;
        this.adultNo = adultNo;
        this.elderlyNo = elderlyNo;
        this.disabledPeopleNo = disabledPeopleNo;
        this.hygieneKits = hygieneKits;
        this.cashAssitance = cashAssitance;
        this.ambulanceService = ambulanceService;
        this.houseCleaning = houseCleaning;
        this.powerBank = powerBank;
        this.foodAndWater = foodAndWater;
        this.infrastructureMaintenance = infrastructureMaintenance;
        this.medicineAndFirstAidsKits = medicineAndFirstAidsKits;
        this.electricalapp = electricalapp;
        this.clothsAndBlanket = clothsAndBlanket;
        this.diapersAndPads = diapersAndPads;
        this.candlesMatchAndTorchlight = candlesMatchAndTorchlight;
    }
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }


    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }


    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getNgo() {
        return ngo;
    }

    public void setNgo(String ngo) {
        this.ngo = ngo;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getIncomeSalary() {
        return incomeSalary;
    }

    public void setIncomeSalary(String incomeSalary) {
        this.incomeSalary = incomeSalary;
    }


    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getBabyNo() {
        return babyNo;
    }

    public void setBabyNo(String babyNo) {
        this.babyNo = babyNo;
    }

    public String getChildrenNo() {
        return childrenNo;
    }

    public void setChildrenNo(String childrenNo) {
        this.childrenNo = childrenNo;
    }

    public String getTeenagerNo() {
        return teenagerNo;
    }

    public void setTeenagerNo(String teenagerNo) {
        this.teenagerNo = teenagerNo;
    }

    public String getAdultNo() {
        return adultNo;
    }

    public void setAdultNo(String adultNo) {
        this.adultNo = adultNo;
    }

    public String getElderlyNo() {
        return elderlyNo;
    }

    public void setElderlyNo(String elderlyNo) {
        this.elderlyNo = elderlyNo;
    }

    public String getDisabledPeopleNo() {
        return disabledPeopleNo;
    }

    public void setDisabledPeopleNo(String disabledPeopleNo) {
        this.disabledPeopleNo = disabledPeopleNo;
    }

    public String getHygieneKits() {
        return hygieneKits;
    }

    public void setHygieneKits(String hygieneKits) {
        this.hygieneKits = hygieneKits;
    }

    public String getCashAssitance() {
        return cashAssitance;
    }

    public void setCashAssitance(String cashAssitance) {
        this.cashAssitance = cashAssitance;
    }

    public String getAmbulanceService() {
        return ambulanceService;
    }

    public void setAmbulanceService(String ambulanceService) {
        this.ambulanceService = ambulanceService;
    }

    public String getHouseCleaning() {
        return houseCleaning;
    }

    public void setHouseCleaning(String houseCleaning) {
        this.houseCleaning = houseCleaning;
    }

    public String getPowerBank() {
        return powerBank;
    }

    public void setPowerBank(String powerBank) {
        this.powerBank = powerBank;
    }

    public String getFoodAndWater() {
        return foodAndWater;
    }

    public void setFoodAndWater(String foodAndWater) {
        this.foodAndWater = foodAndWater;
    }

    public String getInfrastructureMaintenance() {
        return infrastructureMaintenance;
    }

    public void setInfrastructureMaintenance(String infrastructureMaintenance) {
        this.infrastructureMaintenance = infrastructureMaintenance;
    }

    public String getMedicineAndFirstAidsKits() {
        return medicineAndFirstAidsKits;
    }

    public void setMedicineAndFirstAidsKits(String medicineAndFirstAidsKits) {
        this.medicineAndFirstAidsKits = medicineAndFirstAidsKits;
    }

    public String getElectricalapp() {
        return electricalapp;
    }

    public void setElectricalapp(String electricalapp) {
        this.electricalapp = electricalapp;
    }

    public String getClothsAndBlanket() {
        return clothsAndBlanket;
    }

    public void setClothsAndBlanket(String clothsAndBlanket) {
        this.clothsAndBlanket = clothsAndBlanket;
    }

    public String getDiapersAndPads() {
        return diapersAndPads;
    }

    public void setDiapersAndPads(String diapersAndPads) {
        this.diapersAndPads = diapersAndPads;
    }

    public String getCandlesMatchAndTorchlight() {
        return candlesMatchAndTorchlight;
    }

    public void setCandlesMatchAndTorchlight(String candlesMatchAndTorchlight) {
        this.candlesMatchAndTorchlight = candlesMatchAndTorchlight;
    }

  



}
