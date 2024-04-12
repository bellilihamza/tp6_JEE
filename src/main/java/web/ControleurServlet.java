package web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.connector.Response;
import dao.IMotoDao;
import dao.MotoDaoImpl;
import metier.entities.Moto;

@WebServlet(name = "cs", urlPatterns = { "/controleur", "*.do" })
public class ControleurServlet extends HttpServlet {
    private IMotoDao metier;

    @Override
    public void init() throws ServletException {
        metier = new MotoDaoImpl();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getServletPath();
        if (path.equals("/index.do")) {
            request.getRequestDispatcher("motos.jsp").forward(request, response);
        } else if (path.equals("/chercher.do")) {
            String motCle = request.getParameter("motCle");
            MotoModele model = new MotoModele();
            model.setMotCle(motCle);
            List<Moto> motos = metier.motosParMC(motCle);
            model.setMotos(motos);
            request.setAttribute("model", model);
            request.getRequestDispatcher("motos.jsp").forward(request, response);
        } else if (path.equals("/saisie.do")) {
            request.getRequestDispatcher("saisieMoto.jsp").forward(request, response);
        } else if (path.equals("/save.do") && request.getMethod().equals("POST")) {
            String nom = request.getParameter("nomMoto");
            double prix = Double.parseDouble(request.getParameter("prix"));
            Moto moto = metier.save(new Moto(nom, prix));
            request.setAttribute("moto", moto);
            request.getRequestDispatcher("confirmation.jsp").forward(request, response);
        } else if (path.equals("/supprimer.do")) {
            Long id = Long.parseLong(request.getParameter("id"));
            metier.deleteMoto(id);
            response.sendRedirect("chercher.do?motCle=");
        } else if (path.equals("/editer.do")) {
            Long id = Long.parseLong(request.getParameter("id"));
            Moto moto = metier.getMoto(id);
            request.setAttribute("moto", moto);
            request.getRequestDispatcher("editerMoto.jsp").forward(request, response);
        } else if (path.equals("/update.do")) {
            Long id = Long.parseLong(request.getParameter("id"));
            String nom = request.getParameter("nomMoto");
            double prix = Double.parseDouble(request.getParameter("prix"));
            Moto moto = new Moto();
            moto.setIdMoto(id);
            moto.setNomMoto(nom);
            moto.setPrix(prix);
            metier.updateMoto(moto);
            request.setAttribute("moto", moto);
            request.getRequestDispatcher("confirmation.jsp").forward(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
	