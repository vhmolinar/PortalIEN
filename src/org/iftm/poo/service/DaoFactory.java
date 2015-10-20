/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iftm.poo.service;

import org.iftm.poo.model.dao.AutorDao;
import org.iftm.poo.model.dao.CategoriaDao;
import org.iftm.poo.model.dao.GenericDao;
import org.iftm.poo.model.dao.ItemLivroDao;
import org.iftm.poo.model.dao.LivroDao;
import org.iftm.poo.model.dao.TemplateDao;
import org.iftm.poo.model.domain.Autor;
import org.iftm.poo.model.domain.Categoria;
import org.iftm.poo.model.domain.ItemLivro;
import org.iftm.poo.model.domain.Livro;

/**
 * Design Patterns
 * 
 * Singleton e Abstract Factory
 * @author vhmolinar
 */
public class DaoFactory {
    
    private static DaoFactory instance;
    
    public static DaoFactory get(){
        if(instance == null){
            instance = new DaoFactory();
        }
        return instance;
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public <T extends TemplateDao> T resolve(){
        return (T) new GenericDao();
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public <T extends TemplateDao> T resolve(Class tipoEntidade){
        if(tipoEntidade == Livro.class){
            return (T) new LivroDao();
        } else if(tipoEntidade == ItemLivro.class){
            return (T) new ItemLivroDao();
        } else if(tipoEntidade == Categoria.class){
            return (T) new CategoriaDao();
        } else if(tipoEntidade == Autor.class){
            return (T) new AutorDao();
        } else {
            return resolve();
        }
    }
}
