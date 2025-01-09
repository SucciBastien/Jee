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

public class ModifierServlet extends HttpServlet {
    @Resource(name = "DataSource")
  	private DataSource dataSource;

  	@Override
  	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
   	}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("monUniteDePersistance");

        EntityManager entityManager = emf.createEntityManager();

        Integer idUpdated = Integer.valueOf(request.getParameter("idFormateurToUpdate"));
        String usernameUpdated = request.getParameter("usernameFormateurToUpdate");
        String nomUpdated = request.getParameter("nomFormateurToUpdate");
        String prenomUpdated = request.getParameter("prenomFormateurToUpdate");

        entityManager.getTransaction().begin();
        Formateur formateurToUpdate = entityManager.find(Formateur.class, idUpdated);
        formateurToUpdate.setUsername(usernameUpdated);
        if(request.getParameter("mdpFormateurToUpdate") != ""){
            String mdpUpdated = PasswordUtils.hashPassword(request.getParameter("mdpFormateurToUpdate"), null);
            formateurToUpdate.setMdp(mdpUpdated);
        }
        formateurToUpdate.setNom(nomUpdated);
        formateurToUpdate.setPrenom(prenomUpdated);
        entityManager.merge(formateurToUpdate);
        entityManager.getTransaction().commit();

        request.setAttribute("formateurCo", formateurToUpdate);
        request.getRequestDispatcher("/jsp/home.jsp").forward(request, response);
    }
}
