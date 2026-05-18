package lpoo.stable;

/**
 * @author Luís Eduardo Lopes dos Santos
 * @author Otávio Ferreira Augusto
 * @author Guilherme Escobar
 */
public class DuplicateSymbolException extends Exception
{
  // id de serialização padrão para classes que estendem Exception
  private static final long serialVersionUID = 1L;

  //construtor padrão
  public DuplicateSymbolException() {
    super("Símbolo duplicado detectado no escopo atual.");
  }

  // construtor personalizado que aceita o noome do símbolo que causou o erro
  public DuplicateSymbolException(String symbolName) {
    super("Erro: O símbolo '" + symbolName + "' ja foi declarado neste escopo.");
  }
} // DuplicateSymbolException
