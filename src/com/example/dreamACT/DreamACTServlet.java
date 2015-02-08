package com.example.dreamACT;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class DreamACTServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.sendRedirect("index.jsp");
	}
}
