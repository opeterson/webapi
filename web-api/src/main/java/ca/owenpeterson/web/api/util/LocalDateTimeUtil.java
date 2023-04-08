package ca.owenpeterson.web.api.util;

import java.time.*;

public interface LocalDateTimeUtil {

    default OffsetDateTime toOffesetDateTime(LocalDateTime localDateTime)
    {
        ZoneId winnipeg = ZoneId.of("America/Winnipeg").getRules().getOffset(Instant.now());
        return localDateTime.atOffset(ZoneOffset.of(winnipeg.getId()));
    }
}
