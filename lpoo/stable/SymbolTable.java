package lpoo.stable;

import java.util.*;

/**
 *
 * @Luis Eduardo Lopes dos Santos,Guilherme Escobar,Otávio Augusto
 */
public class SymbolTable
{


  public Class addClass(String name)
    throws DuplicateSymbolException {
    Class novaClasse = new Class(name);

    this.globalScope.addClass(novaClasse);

    return novaClasse;
  }



  public Class findClass(String name)
  {

    return this.globalScope.findClass(name);
  }

  public void openClass(Class clazz)
  {
    this.currentClass = clazz;
  }

  public Method addMethod(String name, ParameterList parameters)
    throws DuplicateSymbolException
  {
    Method novoMetodo = new Method(name, parameters);
     if(this.currentClass != null){
       this.currentClass.addMethod(novoMetodo);
     }
    return novoMetodo;
  }

  public List<Method> findMethods(String name, Class clazz)
  {
    // insert your code here
    return null;
  }

  public Method findMethod(String name, List<Type> argumentTypes, Class clazz)
  {
    // insert your code here
    return null;
  }
//msm lógica do openClass
  public void openMethod(Method method)
  {
    this.currentMethod = method;
  }

  public void closeMethod()
  {
    this.currentMethod = null;
  }

  public void openBlock()
  {
    // insert your code here

  }

  public void closeBlock()
  {
    // insert your code here

  }

  public void print()
  {
    // insert your code here

  }

  private GlobalScope globalScope = new GlobalScope();
  private Class currentClass = null;
  private Method currentMethod = null;

  //ponteiro aqui nesse caso vai apontar para a classe "atual" usando o current clazz q declarei no openclass la em cima
  public void opeClass(Class clazz) {
    this.currentClass = clazz;
  }

  public void closeClass(){
    this.currentClass = null; // se sair da classe,volta para o escopo global apontando para nada(null)
  }


}; // SymbolTable
