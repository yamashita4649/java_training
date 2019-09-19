interface Lookup {
    Object find(String name);
    void add(String name, Object value);
    void remove(String name);
}
