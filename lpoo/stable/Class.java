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

  //Fazendo uma nova arv para suportar construtores
  private TreeMap<String, Constructor> constructors;

  //construtor padrão (sem superclasse)
  public Class(String name){
    this(name, null);
  }

  //construtor completo (com superclasse opcional)
  public Class(String name, Class superClass){
    this.name = name;
    this.superClass = superClass;
    this.methods = new TreeMap<>();
    //inicializando para evitar NullPointerException
    this.attributes = new Treemap<>();
    this.constructors = new TreeMap<>();
  }
  
    //metodo para adicionar um metodo na árvore da classe

    public void addMethod(Method novoMetodo) throws DuplicateSymbolException{
        if(this.methods.containsKey(novoMetodo.getName())){
            throw new DuplicateSymbolException();
        }
        this.methods.put(novoMetodo.getName(),novoMetodo);
        }

    public Method findMethod(String name){
        return this.methods.get(name);
      
        //Se não achar aqui, estende a busca para a superclasse (busca ascendente)
        if (metodo == null && this.superClass != null){
          return this.superClass.findMethod(name);
        }
        return metodo;
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

        // Se não achar aqui, estende a busca para a superclasse (busca ascendente)
        if (atributo == null && this.superClass != null){
          return this.superClass.findAttribute(name);
        }
        return atributo;
  }

  //métodos para construtores(novo)

  public void addConstructor(Constructor novoConstrutor) throws DuplicateSymbolException{
        if (this.constructors.containsKey(novoConstrutor.getName())){
        throw new DuplicateSymbolException();
        }
        this.constructors.put(novoConstrutor.getName(), novoConstrutor);
  }

  public Constructor findConstructor(String name){
    //Construtores não são herdados pela superclasse, então a busca é apenas local
    return this.constructors.get(name);
  }

  //getters e setters
  public String getName(){
    return this.name;
  }

  public Class getSuperclass(){
    return this.superClass;
  }

  public void setSuperClass(Class superClass){
    this.superClass = superClass;
  }
};
