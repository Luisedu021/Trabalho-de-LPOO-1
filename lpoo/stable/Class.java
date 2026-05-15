package lpoo.stable;

/**
 *
 * @author Luís Eduardo Lopes dos Santos
 *Otávio Ferreira Augusto
 * Guilherme Escobar
 */
public class Class
{
  private string name;
  private Class superClass;

  //fazendo o escopo interno da classe:uma arvore avl para guardar os métodos dela
    private TreeMap<String, Method > methods;

    //Construtor
    public Class(String name) {
        this.name = name;
        this.methods = new TreeMap<>();
    }
  public String getName() {return this.name ; }

}; // Class
