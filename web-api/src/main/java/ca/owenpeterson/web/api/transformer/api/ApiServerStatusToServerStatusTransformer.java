package ca.owenpeterson.web.api.transformer.api;

import ca.owenpeterson.web.api.client.model.ApiServerStatus;
import ca.owenpeterson.web.api.domain.ServerStatus;
import org.apache.commons.collections4.Transformer;
import org.springframework.stereotype.Component;

@Component
public class ApiServerStatusToServerStatusTransformer implements Transformer<ApiServerStatus, ServerStatus> {

    @Override
    public ServerStatus transform(ApiServerStatus input) {
        ServerStatus output = null;
        if (null != input)
        {
            output = new ServerStatus();
            output.setStartUpTime(null != input.getDatabaseStartTime() ? input.getDatabaseStartTime().toLocalDateTime() : null);
            output.setStatus(input.getDatabaseStatus());
        }
        return output;
    }
}
