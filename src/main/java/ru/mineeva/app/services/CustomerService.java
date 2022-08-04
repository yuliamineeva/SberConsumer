package ru.mineeva.app.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.mineeva.app.exeption.ValidationFailedException;
import ru.mineeva.app.model.Contact;
import ru.mineeva.app.model.Customer;
import ru.mineeva.app.model.CustomerRequest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


@Slf4j
@Service
public class CustomerService {

    final String OUTPUT_FILENAME = "C:\\ForJava\\Projects\\Test\\customers\\output.txt";

    public CustomerService() {
    }

    public void saveCustomerRequest(CustomerRequest customerRequest) {
        log.info("Сохранение customerRequest");
        Contact contact = customerRequest.getContact();
        Customer customer = customerRequest.getCustomer();
        if (customer.getLogin() == null || customer.getLogin().equals("")) {
            log.warn("Поле Логин не может быть пустым");
            throw new ValidationFailedException();
        }
        customer.setContact(contact);
        writeToOutputFile(OUTPUT_FILENAME, customer.toString());
    }

//    public void saveCustomer(CustomerImport customerImport) {
//        log.info("Сохранение элемента");
//        Customer customer = new Customer(customerImport);
//        System.out.println("Метод saveCustomer" + customer);
//        writeToOutputFile(OUTPUT_FILENAME, customer.toString());
//
//    }
//
//    public void saveContact(Contact contactImport) {
//        log.info("Сохранение элемента Contact");
//        Contact contact = new Contact();
//        contact.setPhone(contactImport.getPhone());
//        contact.setEmail(contactImport.getEmail());
//        writeToOutputFile(OUTPUT_FILENAME, contact.toString());
//    }

    public void writeToOutputFile(String fileName, String customer) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) {
            bw.write(customer);
            bw.append("\r\n");
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
