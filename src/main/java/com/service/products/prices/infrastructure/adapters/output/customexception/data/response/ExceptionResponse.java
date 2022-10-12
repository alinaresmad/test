package com.service.products.prices.infrastructure.adapters.output.customexception.data.response;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {

	private LocalDateTime date;

    private String message;

    private List<String> details;

}
