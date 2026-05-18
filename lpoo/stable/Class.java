package lpoo.stable;
import java.util.TreeMap;

/**
 *
 * @author Luís Eduardo Lopes dos Santos
 *Otávio Ferreira Augusto
 * Guilherme Escobar
 */
public class Class
{
  private String name;
  private Class superClass;

  //fazendo o escopo interno da classe:uma arvore avl para guardar os métodos dela
    private TreeMap<String, Method > methods;

  //fazendo uma nova arv para guardar os atributos da classe(variaveis da variable.java)
  private TreeMap<String, Variable> attributes;

    //metodo para adicionar um metodo na árvore da classe

    public void addMethod(Method novoMetodo) throws DuplicateSymbolException{
        if(this.methods.containsKey(novoMetodo.getName())){
            throw new DuplicateSymbolException();
        }
        this.methods.put(novoMetodo.getName(),novoMetodo);
        }

    public Method findMethod(String name){
        return this.methods.get(name);
    }

  //metodo p add atributo na classe

  public void addAttribute(Variable novaVariavel) throws DuplicateSymbolException{
        if(this.attributes.containsKey(novaVariavel.getName())){
            throw new DuplicateSymbolException();
        }
        this.attributes.put(novaVariavel.getName(), novaVariavel);
  }

  //metodo para procurar atributo em classe

  public Variable findAttribute(String name){
        return this.attributes.get(name);
  }

    //Construtor
    public Class(String name) {
        this.name = name;
        this.methods = new TreeMap<>();
    }
  public String getName() {return this.name ; }

};
