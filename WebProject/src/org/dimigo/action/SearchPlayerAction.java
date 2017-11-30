/**
 * 
 */
package org.dimigo.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.dimigo.api.API;
import org.dimigo.api.Player;

/**
 * <pre>
 * org.dimigo.action
 *   |_ SearchPlayer
 * 
 * 1. 개요 : 
 * 2. 작성일 : 2017. 11. 28.
 * </pre>
 *
 * @author	: Hvid
 * @version	: 1.0
 */
public class SearchPlayerAction implements IAction{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String playerId = request.getParameter("playerId");
		try{
			Player player = API.parsePlayerProfile(playerId);
			request.setAttribute("player", player);
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/playerprofile.jsp");
			rd.forward(request, response);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/playerprofile.jsp");
			rd.forward(request, response);
			throw e;
		}
		
	}

}
