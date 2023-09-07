package com.learining.actuator.api.endpoint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "my-end-point", enableByDefault = true)
public class MyEndPoint {
    @ReadOperation
    public MyEndPointResponse getMyEndPointResponse() {
        return new MyEndPointResponse(1, "MyEndPoint", "Active");
    }
}

@AllArgsConstructor
@NoArgsConstructor
@Data
class MyEndPointResponse {
    private int id;
    private String name;
    private String status;
}
