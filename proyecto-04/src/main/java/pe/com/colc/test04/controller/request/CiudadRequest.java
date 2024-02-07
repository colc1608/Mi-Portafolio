package pe.com.colc.test04.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CiudadRequest {


    private Integer idAlumno;
    private String ciudadNombre;
    private Integer ciudadCodigoPostal;

}
