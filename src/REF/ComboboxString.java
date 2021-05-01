package REF;

public class ComboboxString {
    private String key;
    private String value;

    public ComboboxString() {
    }

    public ComboboxString(String value) {
        this.value = value;
    }

    public ComboboxString(String key, String value)
    {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString()
    {
        return key;
    }

    public String getKey()
    {
        return key;
    }

    public String getValue()
    {
        return value;
    }

}
