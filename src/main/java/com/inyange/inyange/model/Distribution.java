package com.inyange.inyange.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
public class Distribution {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    @Past(message = "Arrival Date must be a past date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date arrivalDate;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "schoolId")
    private School schools;
    private String sector;
    private String district;
    private String plateNo;
    @Past(message = "Arrival time must be a past date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date arrivalTime;
    private String driverName;
    private Integer Liters;
    private String litersDescription;
    private Integer lastingDays;
    private String headOfSchool;
    @Size(max = 10, message = "Telephone number should not exceed 10 digits")
    private String telephoneOfSchool;
    private String headOfFood;
    @Size(max = 10, message = "Telephone number should not exceed 10 digits")
    private String telephoneOfFood;
    private String headOfInyange;
    @Size(max = 10, message = "Telephone number should not exceed 10 digits")
    private String telephoneOfInyange;
    private String headOfKigaliDepartment;
    @Size(max = 10, message = "Telephone number should not exceed 10 digits")
    private String telephoneOfKigaliDepartment;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Date getArrivalDate() {
        return arrivalDate;
    }
    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }
    public School getSchools() {
        return schools;
    }
    public void setSchools(School schools) {
        this.schools = schools;
    }
    public String getSector() {
        return sector;
    }
    public void setSector(String sector) {
        this.sector = sector;
    }
    public String getDistrict() {
        return district;
    }
    public void setDistrict(String district) {
        this.district = district;
    }
    public String getPlateNo() {
        return plateNo;
    }
    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }
    public Date getArrivalTime() {
        return arrivalTime;
    }
    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
    public String getDriverName() {
        return driverName;
    }
    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }
    public Integer getLiters() {
        return Liters;
    }
    public void setLiters(Integer liters) {
        Liters = liters;
    }
    public String getLitersDescription() {
        return litersDescription;
    }
    public void setLitersDescription(String litersDescription) {
        this.litersDescription = litersDescription;
    }
    public Integer getLastingDays() {
        return lastingDays;
    }
    public void setLastingDays(Integer lastingDays) {
        this.lastingDays = lastingDays;
    }
    public String getHeadOfSchool() {
        return headOfSchool;
    }
    public void setHeadOfSchool(String headOfSchool) {
        this.headOfSchool = headOfSchool;
    }
    public String getHeadOfFood() {
        return headOfFood;
    }
    public void setHeadOfFood(String headOfFood) {
        this.headOfFood = headOfFood;
    }
    public String getHeadOfInyange() {
        return headOfInyange;
    }
    public void setHeadOfInyange(String headOfInyange) {
        this.headOfInyange = headOfInyange;
    }
    public String getHeadOfKigaliDepartment() {
        return headOfKigaliDepartment;
    }
    public void setHeadOfKigaliDepartment(String headOfKigaliDepartment) {
        this.headOfKigaliDepartment = headOfKigaliDepartment;
    }
    public String getTelephoneOfSchool() {
        return telephoneOfSchool;
    }
    public void setTelephoneOfSchool(String telephoneOfSchool) {
        this.telephoneOfSchool = telephoneOfSchool;
    }
    public String getTelephoneOfFood() {
        return telephoneOfFood;
    }
    public void setTelephoneOfFood(String telephoneOfFood) {
        this.telephoneOfFood = telephoneOfFood;
    }
    public String getTelephoneOfInyange() {
        return telephoneOfInyange;
    }
    public void setTelephoneOfInyange(String telephoneOfInyange) {
        this.telephoneOfInyange = telephoneOfInyange;
    }
    public String getTelephoneOfKigaliDepartment() {
        return telephoneOfKigaliDepartment;
    }
    public void setTelephoneOfKigaliDepartment(String telephoneOfKigaliDepartment) {
        this.telephoneOfKigaliDepartment = telephoneOfKigaliDepartment;
    }
    

}
