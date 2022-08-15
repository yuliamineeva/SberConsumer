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


@Slf4j
@Service
public class CustomerService {

    final String OUTPUT_FILENAME = "C:\\ForJava\\Repositories\\Sber\\customers\\output.txt";
//    final String OUTPUT_FILENAME = "output.txt"; // C:\ForJava\Programms\apache-tomcat-9.0.65\bin\output.txt

    public CustomerService() {
    }

    /**
     * Извлечение объектов Customer и Contact
     *
     * @param customerRequest запрос для сохранения
     */
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

    /**
     * Запись объекта Customer в файл
     *
     * @param fileName имя файла
     * @param customer объект Customer, содержащий Contact
     */
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
