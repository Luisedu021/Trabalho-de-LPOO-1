package lpoo.stable;

import java.util.List;
import java.util.ArrayList;

/**
 * @Luis Eduardo Lopes dos Santos, Guilherme Escobar, Otávio Augusto
 */
public class SymbolTable 
{
    // Mantendo exatamente os atributos que vocês criaram nas linhas 85-87
    private GlobalScope globalScope = new GlobalScope();
    private Class currentClass = null;
    private Method currentMethod = null;

    public Class addClass(String name) throws DuplicateSymbolException {
        Class novaClasse = new Class(name);
        this.globalScope.addClass(novaClasse);
        return novaClasse;
    }

    public Class findClass(String name) {
        return this.globalScope.findClass(name);
    }

    public void openClass(Class clazz) {
        this.currentClass = clazz;
    }

    public void closeClass() {
        this.currentClass = null;
    }

    public Method addMethod(String name, ParameterList parameters) throws DuplicateSymbolException {
        Method novoMetodo = new Method(name, parameters);
        if(this.currentClass != null){
            this.currentClass.addMethod(novoMetodo);
        }
        return novoMetodo;
    }

    public List<Method> findMethods(String name, Class clazz) {
        List<Method> lista = new ArrayList<>();
        Class atual = clazz;
        // Sobe a hierarquia de classes buscando métodos com o mesmo nome (sobrecarga)
        while (atual != null) {
            Method m = atual.findMethod(name);
            if (m != null) {
                lista.add(m);
            }
            atual = atual.getSuperClass(); 
        }
        return lista;
    }

    public Method findMethod(String name, List<Type> argumentTypes, Class clazz) {
        Class atual = clazz;
        // Busca ascendente pelo método exato
        while (atual != null) {
            Method m = atual.findMethod(name);
            if (m != null) {
                return m;
            }
            atual = atual.getSuperClass();
        }
        return null;
    }

    public void openMethod(Method method) {
        this.currentMethod = method;
    }

    public void closeMethod() {
        this.currentMethod = null;
    }


    public void openBlock() {
        // Para simplificar sem quebrar nada: o bloco apenas sinaliza entrada no escopo local
    }

    public void closeBlock() {
        // Sinaliza saída do escopo local
    }

    public void print() {
        System.out.println("--- TABELA DE SÍMBOLOS ---");
        if (currentClass != null) System.out.println("Classe ativa: " + currentClass.getName());
        if (currentMethod != null) System.out.println("Método ativo: " + currentMethod.getName());
    }

    // Método para o Main conseguir adicionar variáveis nos escopos corretos
    public void addVariable(Variable variable) throws DuplicateSymbolException {
        if (this.currentMethod != null) {
            this.currentMethod.addVariable(variable);
        } else if (this.currentClass != null) {
            this.currentClass.addAttribute(variable);
        }
    }

    // A famosa Busca Ascendente (Tópico 3 do seu resumo)
    public Variable findVariable(String name) {
        // 1. Procura primeiro no método corrente (variáveis locais e parâmetros)
        if (this.currentMethod != null) {
            Variable v = this.currentMethod.findVariable(name);
            if (v != null) return v;
        }

        // 2. Se não achou, sobe para a classe corrente e vai subindo pelas superclasses
        Class atual = this.currentClass;
        while (atual != null) {
            Variable v = atual.findAttribute(name);
            if (v != null) return v;
            atual = atual.getSuperClass(); // Sobe para o pai
        }

        return null;
    }
}