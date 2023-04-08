package ca.owenpeterson.web.api.transformer.domain;

import ca.owenpeterson.web.api.client.model.ApiServerStatus;
import ca.owenpeterson.web.api.domain.ServerStatus;
import ca.owenpeterson.web.api.util.LocalDateTimeUtil;
import org.apache.commons.collections4.Transformer;
import org.springframework.stereotype.Component;

@Component
public class ServerStatusToApiServerStatusTransformer implements Transformer<ServerStatus, ApiServerStatus>, LocalDateTimeUtil {

    @Override
    public ApiServerStatus transform(ServerStatus input) {
        ApiServerStatus output = null;
        if (null != input)
        {
            output = new ApiServerStatus();
            output.setDatabaseStartTime(null != input.getStartUpTime() ? toOffesetDateTime(input.getStartUpTime()) : null);
            output.setDatabaseStatus(input.getStatus());
        }
        return output;
    }
}
