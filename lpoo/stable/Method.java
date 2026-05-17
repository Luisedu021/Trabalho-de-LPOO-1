package lpoo.stable;

/**
 *
 *Luís Eduardo Lopes dos Santos,Guilherme Escobar,Otávio Augusto
 */
public class Method
{
 private String name;
 private ParameterList parameters;

 public Method(String name, ParameterList parameters){
     this.name = name;
     this.parameters = parameters;
 }

 //fazendo um método para conseguir ler o nome e organizar
    public String getName(){
     return this.name;
    }
  
}; // Method
