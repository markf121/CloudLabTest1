package ie.mydit.flanagan6.mark;

import java.io.IOException;

import javax.servlet.http.*;

@SuppressWarnings("serial")
public class DifferencesProduct extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Cloud Computing Lab Test 1");
		
		
		
		String AString, BString, CString, DString;
		int A, B, C, D, result;

		AString = req.getParameter("A");//Read in the value for A from the URL
		BString = req.getParameter("B");//Read in the value for A from the URL	
		CString = req.getParameter("C");
		DString = req.getParameter("D");
		
		if( (BString == null) || (AString == null) || (CString == null) || (DString == null) )//Check for null Entries
		{
			//Print out errror message
			resp.getWriter().println("No values for A or B found. Please enter values into the url in the following format:"
					+ " <someurl>/differencesproduct?A=someIntegerValue&B=someIntegerValue");
			
			//Set String variables to default values set in the web.xml file
			AString = getServletConfig().getInitParameter("A");
			BString = getServletConfig().getInitParameter("B");
			CString = getServletConfig().getInitParameter("C");
			DString = getServletConfig().getInitParameter("D");
			
			resp.getWriter().println("\n\nDefault Paramaters " +AString +BString+ CString + DString + " used instead");
			
			//Parse both strings as integers
			A = Integer.parseInt(AString);
			B = Integer.parseInt(BString);
			C = Integer.parseInt(CString);
			D = Integer.parseInt(DString);
		}
		else{
			//Check if A is an integer with a try catch
			try{
				A = Integer.parseInt(AString);
			}
			catch(NumberFormatException e){
				resp.getWriter().println("value for A is not an Integer. Please enter values into the url in the following format:"
						+ " <someurl>/differencesproduct?A=someIntegerValue&B=someIntegerValue&C=someIntegerValue&D=someIntegerValue");
				AString = getServletConfig().getInitParameter("A");
				A = Integer.parseInt(AString);
				resp.getWriter().println("\n\nDefault Paramater for A, " +AString+ ", used instead");
			}
			
			//Check if A is an integer with a try catch
			try{
				B = Integer.parseInt(BString);
			}
			catch(NumberFormatException e){
				resp.getWriter().println("Value for B is not an Integer. Please enter values into the url in the following format:"
						+ " <someurl>/differencesproduct?A=someIntegerValue&B=someIntegerValue&C=someIntegerValue&D=someIntegerValue");
				BString = getServletConfig().getInitParameter("B");
				B = Integer.parseInt(BString);
				resp.getWriter().println("\n\nDefault Paramater for B, " +BString+ ", used instead");
			}
			try{
				C = Integer.parseInt(CString);
			}
			catch(NumberFormatException e){
				resp.getWriter().println("value for C is not an Integer. Please enter values into the url in the following format:"
						+ " <someurl>/differencesproduct?A=someIntegerValue&B=someIntegerValue&C=someIntegerValue&D=someIntegerValue");
				CString = getServletConfig().getInitParameter("C");
				C = Integer.parseInt(CString);
				resp.getWriter().println("\n\nDefault Paramater for C, " +CString+ ", used instead");
			}
			
			try{
				D = Integer.parseInt(DString);
			}
			catch(NumberFormatException e){
				resp.getWriter().println("value for D is not an Integer. Please enter values into the url in the following format:"
						+ "<someurl>/differencesproduct?A=someIntegerValue&B=someIntegerValue&C=someIntegerValue&D=someIntegerValue");
				DString = getServletConfig().getInitParameter("D");
				D = Integer.parseInt(DString);
				resp.getWriter().println("\n\nDefault Paramater for D, " +DString+ ", used instead");
			}
			
		}//End if else for checking null and non integer inputs
		

		//Finally multiply the two integers read from the URL. Store and print the result 
		result = (A-B) * (C-D);
		resp.getWriter().println(result);
	
		
	}
}