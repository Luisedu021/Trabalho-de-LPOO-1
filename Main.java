import lpoo.stable.*;

public final class Main {
  public static void main(String[] args) {
    try {
      SymbolTable st = new SymbolTable();

      System.out.println("Adicionando String...");
      st.addClass("String");

      System.out.println("Adicionando e abrindo Test...");
      lpoo.stable.Class clazz = st.addClass("Test");
      st.openClass(clazz);

      // Comentando
       Method method = st.addMethod("main", null);
      st.openMethod(method);

      //add depois blocos,variaveis,etc.
       st.closeMethod();

      System.out.println("Fechando Test...");
      st.closeClass();

      System.out.println("Teste concluido com sucesso! Classes adicionadas na Tabela.");

    } catch (DuplicateSymbolException e) {
      System.out.println("Erro semântico: Símbolo Duplicado!");
    }
  }
}