package educare.educareapispringboot.exception;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
public class ApiException {

    private List<String> errorList;

    public ApiException(String message) {
        errorList = Arrays.asList(message);
    }

    public ApiException(List<String> errorList) {
        this.errorList = errorList;
    }


}