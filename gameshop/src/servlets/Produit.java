package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ControllerForms;

@WebServlet(name = "Produit")
public class Produit extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Produit() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	this.getServletContext().getRequestDispatcher("/WEB-INF/produit.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

		ControllerForms controller = new ControllerForms();
		controller.ControleProduit(request);
		
		request.setAttribute("controller", controller);
		
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String editeur = request.getParameter("editeur");
		String createur = request.getParameter("createur");
		int sortie = Integer.parseInt(request.getParameter("sortie"));
		float prix = Float.parseFloat(request.getParameter("prix"));
		
		request.setAttribute("nom", nom);
		request.setAttribute("prenom", prenom);
		request.setAttribute("editeur", editeur);
		request.setAttribute("createur", createur);
		request.setAttribute("sortie", sortie);
		request.setAttribute("prix", prix);

		this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);

	}

}
