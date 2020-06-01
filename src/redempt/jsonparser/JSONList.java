package redempt.jsonparser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JSONList extends ArrayList<Object> {

    public int getInt(int key) {
        return (int) get(key);
    }

    public double getDouble(int key) {
        return (double) get(key);
    }

    public JSONList getList(int key) {
        return (JSONList) get(key);
    }

    public JSONMap getMap(int key) {
        return (JSONMap) get(key);
    }
    
    public String getString(int key) {
        return (String) get(key);
    }
    
    public <T> List<T> cast(Class<T> clazz) {
        return stream().map(clazz::cast).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        for (Object o : this) {
            if (o instanceof String) {
                builder.append('"').append(((String) o).replace("\\", "\\\\").replace("\"", "\\\"")).append("\", ");
                continue;
            }
            builder.append(o.toString()).append(", ");
        }
        return builder.replace(builder.length() - 2, builder.length(), "]").toString();
    }

}