package com.f1soft.ipo_result_service.entity;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseMessage {

    private String message;
    private int allottedQuantity;

}
