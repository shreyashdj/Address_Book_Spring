package com.bridgelabz.addressbook.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO {
    private String msg;
    private Object data;
}