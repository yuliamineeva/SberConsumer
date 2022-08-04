package ru.mineeva.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private Contact contact;
    private String login;
    private String firstname;
    private String lastname;
    private String patronymic;
    private String passportSeries;
    private String numberSeries;

    public Customer(CustomerImport customerImport){
        this.login = customerImport.getLogin();
        this.firstname = customerImport.getFirstname();
        this.lastname = customerImport.getLastname();
        this.patronymic = customerImport.getPatronymic();
        this.passportSeries = customerImport.getPassportSeries();
        this.numberSeries = customerImport.getNumberSeries();
    }

    @Override
    public String toString() {
        return "Customer{" +
                "Contact{" +
                "phone='" + contact.getPhone() + '\'' +
                ", email='" + contact.getEmail() + '\'' +
                '}'+
                ", login='" + login + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", passportSeries='" + passportSeries + '\'' +
                ", numberSeries='" + numberSeries + '\'' +
                '}';
    }


}

