package net.jobintech.jobintechprogram.exceptions;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorBody {
    private String status;
    private String time;
    private String message;

}
