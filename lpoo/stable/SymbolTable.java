package lpoo.stable;

import java.util.*;

/**
 *
 * @author // put your name(s) here
 */
public class SymbolTable
{
  public Class addClass(String name)
    throws DuplicateSymbolException
          Class novaClasse = new Class(name);

  Class novaClasse = new Class(name);

  this.GlobalScope.AddClass(novaClasse);

    return novaClasse;

    // insert your code here
    return null;
  }

  public Class findClass(String name)
  {

    return this.globalScope.findClass(name);
  }

  public void openClass(Class clazz)
  {
    // insert your code here
  }

  public void closeClass()
  {
    // insert your code here
  }

  public Method addMethod(String name, ParameterList parameters)
    throws DuplicateSymbolException
  {
    // insert your code here
    return null;
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

  public void openMethod(Method method)
  {
    // insert your code here
  }

  public void closeMethod()
  {
    // insert your code here
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

  private GlobalScope globalScope = new GLobalScope();
  private Class currentClass = null;
  private Method currentMethod = null;

  public void opeClass(Class clazz) {
    this.currentClass = clazz;
  }

  public void closeClass(){
    this.currentClass = null; // se sair da classe,volta para o escopo global
  }
  // insert your code here

}; // SymbolTable
