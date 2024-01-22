package lk.ijse.dep11.edupanel.conveter;

import lk.ijse.dep11.edupanel.util.LecturerType;
import org.springframework.core.convert.converter.Converter;

public class LecturerTypeConverter implements Converter<String, LecturerType> {

    @Override
    public LecturerType convert(String source) {
        for (LecturerType type : LecturerType.values()) {
            if (type.getType().equalsIgnoreCase(source)){
                return type;
            }
        }
        return null;
    }
}
