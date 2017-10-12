package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sean Jeske
 */
public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sess = request.getSession();
        String username = (String) sess.getAttribute("username");
        if (username == null ) {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        }
        
        String action = request.getParameter("action");
        if(action != null && action.equals("logout")){
            sess.removeAttribute("username");
            sess.removeAttribute("items");
            response.sendRedirect("/ShoppingList");
            return;
        }
        
        
        request.setAttribute("username", username);
        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sess = request.getSession();
        
        String action = request.getParameter("action");
        if (action != null && action.equals("register")) {
            String username = request.getParameter("username");           
            ArrayList<String> items = new ArrayList<String>();
            sess.setAttribute("username", username);
            sess.setAttribute("items", items);
            response.sendRedirect("/ShoppingList");
        }
        
        if (action != null && action.equals("add")) {
            String item = request.getParameter("item");
            ArrayList<String> items = (ArrayList<String>) sess.getAttribute("items");
            items.add(item);
            sess.setAttribute("items", items);
            response.sendRedirect("/ShoppingList");
            
        }
        
        if (action != null && action.equals("delete")) {
            String item = request.getParameter("listItem");
            ArrayList<String> items = (ArrayList<String>) sess.getAttribute("items");
            for(Iterator<String> it = items.iterator(); it.hasNext();){
                String s = it.next();
                if(s.equals(item)){
                    it.remove();
                }
            }
            sess.setAttribute("items", items);
            response.sendRedirect("/ShoppingList");
            
        }
    }
}