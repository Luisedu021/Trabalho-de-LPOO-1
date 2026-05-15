import lpoo.stable.*;

/**
 *
 * @author // put your name(s) here
 */
public final class Main
{
  public static void main(String[] args)
  {
    try
    {
      //criando um objeto aqui
      SymbolTable st = new SymbolTable();
  //adicionando classe
      st.addClass("String");

      lpoo.stable.Class clazz = st.addClass("Test");

      st.openClass(clazz);

      Method method = st.addMethod("main", null);

      st.openMethod(method);
      // add blocks, variables, etc.
      st.closeMethod();
      st.closeClass();
      // insert your code here

    }
    catch (DuplicateSymbolException e)
    {
      System.out.println("Erro semântico: " + e.getMessage());
    }
  }

}; // Main