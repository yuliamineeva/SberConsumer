package ru.mineeva.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CustomerImport {

    private String login;
    private String firstname;
    private String lastname;
    private String patronymic;
    private String passportSeries;
    private String numberSeries;

}
