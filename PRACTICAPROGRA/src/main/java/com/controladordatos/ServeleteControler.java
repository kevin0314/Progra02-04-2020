package com.controladordatos;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.entidades.Productospv;

/**
 * Servlet implementation class ServeleteControler
 */
public class ServeleteControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServeleteControler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		EntityManager em;
		EntityManagerFactory emf;
		
		emf = Persistence.createEntityManagerFactory("PRACTICAPROGRA");
		em = emf.createEntityManager();
		Productospv pr = new Productospv();
		
		
		try {
			
			String id = request.getParameter("Id");
			String nombrepr = request.getParameter("Nproductos");
			String preciopr = request.getParameter("Pproductos");
			String cantidadpr = request.getParameter("Cproductos");
			String totalpr = request.getParameter("Tproductos");
			
		
			pr.setId(Integer.parseInt(id));
			pr.setNombreProducto(nombrepr);
			pr.setPrecioProducto(Double.parseDouble(preciopr));
			pr.setCantidadProducto(Integer.parseInt(cantidadpr));
			pr.setTotalProducto(Double.parseDouble(totalpr));
			
		} catch (Exception e) {
			
		}

		
            String acction = request.getParameter("btn");
            
            switch(acction) {
            
            case "Agregar":
            	em.getTransaction().begin();
            	em.persist(pr);
        		em.flush();
        		em.getTransaction().commit();
            	break;
            	
            case "Eliminar":
            	
            	pr = em.getReference(Productospv.class, pr.getId());
            	em.getTransaction().begin();
        		em.remove(pr);
        		em.flush();
        		em.getTransaction().commit();
            	break;
            	
            case "Editar":
            	em.getTransaction().begin();
            	em.merge(pr);
            	em.flush();
        		em.getTransaction().commit();
            	
            	break;
           
            }
            response.sendRedirect("index.jsp");
	}
	
	}


