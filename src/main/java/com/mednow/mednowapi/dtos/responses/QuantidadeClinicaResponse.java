package com.mednow.mednowapi.dtos.responses;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class QuantidadeClinicaResponse {
    private Long quantidadeClinica;
}
