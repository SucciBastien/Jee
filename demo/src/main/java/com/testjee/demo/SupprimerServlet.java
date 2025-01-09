package com.testjee.demo;

import java.io.IOException;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.sql.DataSource;

import com.testjee.demo.model.Formateur;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SupprimerServlet extends HttpServlet {
    @Resource(name = "DataSource")
  	private DataSource dataSource;

  	@Override
  	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
   	}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("monUniteDePersistance");

        EntityManager entityManager = emf.createEntityManager();

        Integer idFormateurToDelete = Integer.valueOf(request.getParameter("idFormateurToDelete"));

        entityManager.getTransaction().begin();
        Formateur formateurToModify = entityManager.find(Formateur.class, idFormateurToDelete);
        entityManager.remove(formateurToModify);
        entityManager.getTransaction().commit();

        response.sendRedirect("http://localhost:8080/demo");
    }
}
