package JSON;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import java.sql.Timestamp;

public class TimestampSerializer extends Serializer<Timestamp> {

    @Override
    public void write(Kryo kryo, Output output, Timestamp timestamp) {
        output.writeString(timestamp.toString());
    }

    @Override
    public Timestamp read(Kryo kryo, Input input, Class<Timestamp> aClass) {
        return new Timestamp(input.readLong(true));
    }
}