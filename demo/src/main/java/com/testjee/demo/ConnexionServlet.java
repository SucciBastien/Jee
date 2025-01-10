package com.testjee.demo;

import java.io.*;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.sql.DataSource;

import com.testjee.demo.model.Formateur;
import com.testjee.demo.model.PasswordUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ConnexionServlet extends HttpServlet {
	@Resource(name = "DataSource")
  	private DataSource dataSource;

  	@Override
  	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
   	}

   	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
		// on spécifie le nom de l'unité de persistence en paramètre
		if(request.getParameter("username") != null){
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("monUniteDePersistance");

			EntityManager entityManager = emf.createEntityManager();
			
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<Formateur> cq = cb.createQuery(Formateur.class);
			Root<Formateur> rootEntry = cq.from(Formateur.class);
			CriteriaQuery<Formateur> all = cq.select(rootEntry);
		
			TypedQuery<Formateur> allQuery = entityManager.createQuery(all);
			 
			String usernameToCheck = request.getParameter("username");
			String mdpToCheck = request.getParameter("password");
			System.out.println(allQuery.getResultList().getClass().getName());
			
			for (Formateur formateur : allQuery.getResultList()) {
				String username = formateur.getUsername();
				String mdp = formateur.getMdp();
				if(usernameToCheck.equals(username) && PasswordUtils.verifyPassword(mdpToCheck, mdp)){
					request.setAttribute("formateurs", allQuery.getResultList());
					request.setAttribute("formateurCo", formateur);
					request.getRequestDispatcher("/jsp/home.jsp").forward(request, response);
				}else{
					System.out.println("mot de passe ou nom d'utilisateur incorrect");
				}
			}
			if(request.getAttribute("formateurCo") == null){
				response.sendRedirect("http://localhost:8080/demo");
			}
		}
		
			
		
		
    }
}