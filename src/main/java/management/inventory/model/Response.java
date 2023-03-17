package management.inventory.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Response<T> {
    private T data;
    private boolean error=false;
    private int ms;


}
