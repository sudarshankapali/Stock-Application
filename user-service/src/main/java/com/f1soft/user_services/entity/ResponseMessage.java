package com.f1soft.user_services.entity;

import lombok.*;
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseMessage {

    private String message;
    private Object data;
}
