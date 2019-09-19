import java.util.HashMap;
import java.util.Map;

public class UseMapLookup implements Lookup{
    public Map<String,Object> mMap = new HashMap<>();

    @Override
    public Object find(String name) {
        if(mMap != null) {
            return mMap.get(name);
        }
        return null;
    }

    @Override
    public void add(String name, Object value) {
        if(mMap == null) {
            mMap = new HashMap<>();
        }
        mMap.put(name,value);
    }

    @Override
    public void remove(String name) {
        if(mMap == null) {
            mMap = new HashMap<>();
        } else {
            mMap.remove(name);
        }
    }
}
