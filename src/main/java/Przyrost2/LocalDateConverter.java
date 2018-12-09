package Przyrost2;

//import org.joda.time.LocalDateTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Converter(autoApply = true)
public class LocalDateConverter implements AttributeConverter<LocalDateTime, Timestamp> {

    @Override
    public Timestamp convertToDatabaseColumn(LocalDateTime localDateTime) {
        if(localDateTime != null)
            return Timestamp.valueOf(localDateTime.toString());
        else
            return null;
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Timestamp timestamp) {
        if(timestamp != null)
            return timestamp.toLocalDateTime();
        else
            return null;
    }
}

