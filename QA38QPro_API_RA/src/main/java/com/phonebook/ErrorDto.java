package com.phonebook;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
public class ErrorDto {
    private String error;
    private String path;
    private int status;
    private Object message;
}
