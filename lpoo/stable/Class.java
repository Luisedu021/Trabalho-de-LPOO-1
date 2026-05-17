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

    //método para adicionar um método na árvore da classe
    public void addMethod(Method novoMetodo) throws DuplicateSymbolException{
        if(this.methods.containsKey(novoMetodo.getName())){
            throw new DuplicateSymbolException();
        }
        this.methods.put(novoMetodo.getName(),novoMetodo);
        }
        public Method findMethod(String name){
        return this.methods.get(name);
    }

    //Construtor
    public Class(String name) {
        this.name = name;
        this.methods = new TreeMap<>();
    }
  public String getName() {return this.name ; }

}; // Class
