package es.uoc.precintes.dto;

import java.util.ArrayList;
import java.util.List;

public class BaseDto {

private List<ErrorDto> errores;

public BaseDto(){
	this.errores=new ArrayList<ErrorDto>();
}
public BaseDto(List<ErrorDto> errores) {
	this.errores=errores;
}


public List<ErrorDto> getErrores() {
	return errores;
}

public void setErrores(List<ErrorDto> errores) {
	this.errores = errores;
}

public boolean hasErrores() {
	return (errores.size()>0);
}

}
