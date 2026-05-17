package lpoo.stable;

public class Variable {
    private String name;
    private Type type; // tipo de var

    public Variable(String name, Type type) {
        this.name = name;
        this.type = type;
    }

        public String getName(){
            return this.name;}


    public Type getType() {
        return this.type;
    }
}
