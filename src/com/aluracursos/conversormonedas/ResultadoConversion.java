package com.aluracursos.conversormonedas;

import com.google.gson.annotations.SerializedName;

public record ResultadoConversion(
        @SerializedName("result")
        String result,
        @SerializedName("conversion_result")
        Double conversion_result,

        @SerializedName("conversion_rate")
        Double conversion_rate) {


}
