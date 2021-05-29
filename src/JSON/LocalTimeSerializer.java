package JSON;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import java.time.LocalDate;
import java.time.LocalTime;

public class LocalTimeSerializer extends Serializer<LocalDate> {
    @Override
    public void write(Kryo kryo, Output output, LocalDate localTime) {
        output.writeString(localTime.toString());
    }

    @Override
    public LocalDate read(Kryo kryo, Input input, Class<LocalDate> aClass) {
        return LocalDate.parse(input.readString());
    }
}
