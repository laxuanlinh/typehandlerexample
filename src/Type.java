public enum Type {

    PERSON("Person", PersonHandler.class),
    CAR("Car", CarHandler.class);


    private String name;
    private Class< ? extends Handler> handler;

    Type(String name, Class< ? extends Handler> handler) {
        this.name = name;
        this.handler = handler;
    }

    public static Handler getHandler(Type type) {
        try {
            return type.handler.getConstructor().newInstance();
        } catch (Exception e){
            throw new RuntimeException();
        }
    }
}
