package com.example.validation.dto;

import com.example.validation.annotation.YearMonth;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class User {

    @NotBlank
    private String name;
    @Email
    private String email;

//    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "핸드폰 번호의 양식과 맞지 않습니다. 01x-xxx(x)-xxxx") // 핸드폰번호 xxx-xxxx-xxxx 정규표현식
//    @JsonProperty("phone_number")
//    private String phoneNumber;
    @Max(value = 90, message = "나이는 90살 이하여야 합니다.")
    private int age;

//    @Size(min = 6, max = 6, message = "날짜 형식이 올바르지 않습니다. ex)202206")
//    @YearMonth
//    private String reqYearMonth; // YYYYMM

    @Valid
    private List<Car> cars;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", cars=" + cars +
                '}';
    }
}
