package org.f1soft.currentissue.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ServerResponse {
    private String message;
    private Object data;
}
