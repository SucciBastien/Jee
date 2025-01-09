package com.testjee.demo;

import java.io.IOException;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.sql.DataSource;

import com.testjee.demo.model.Formateur;
import com.testjee.demo.model.PasswordUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AjoutServlet  extends HttpServlet {
    @Resource(name = "DataSource")
  	private DataSource dataSource;

    @Override
  	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("index.jsp").forward(request, response);
   	}
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("monUniteDePersistance");

        EntityManager entityManager = emf.createEntityManager();

        String usernameToAdd = request.getParameter("usernameAdd");
        String passwordToAdd = request.getParameter("passwordAdd");
        String nomToAdd = request.getParameter("nomAdd");
        String prenomToAdd = request.getParameter("prenomAdd");
        
        System.out.println("ok");

        entityManager.getTransaction().begin();
        Formateur formateurToAdd = new Formateur(usernameToAdd, PasswordUtils.hashPassword(passwordToAdd, null), nomToAdd, prenomToAdd);
        entityManager.persist(formateurToAdd);
        entityManager.getTransaction().commit();
        request.getRequestDispatcher("index.jsp").forward(request, response);
        
    }
}
