package lpoo.stable;

import java.util.TreeMap;

/**
 *
 *Luís Eduardo Lopes dos Santos,Guilherme Escobar,Otávio Augusto
 */
public class Method
{
 private String name;
 private ParameterList parameters;
 private TreeMap<String, Variable> localVariables;

 public Method(String name, ParameterList parameters){
     this.name = name;
     this.parameters = parameters;
     this.localVariables = new TreeMap<>();
 }

 // Adiciona uma variável local ao metodo

    public void addVariable(Variable novaVariavel) throws DuplicateSymbolException {
        if (this.localVariables.containsKey(novaVariavel.getName())) {
            throw new DuplicateSymbolException();
        }
        this.localVariables.put(novaVariavel.getName(), novaVariavel);
    }

    // Procura uma variável local no metodo
    public Variable findVariable(String name) {
        return this.localVariables.get(name);
    }

 //fazendo um metodo para conseguir ler o nome e organizar
    public String getName(){
     return this.name;
    }
  
}; // Method
