package ru.mineeva.app.exeption;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Error {

    @NotNull
    int code;

    @NotNull
    String message;
}
