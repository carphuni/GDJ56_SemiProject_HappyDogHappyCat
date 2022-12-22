package hos;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.google.gson.Gson;

/**
 * Servlet implementation class mainClass2
 */
@WebServlet("/mainClass2")
public class mainClass2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mainClass2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		List<Hospital> hosmap=new ArrayList();
		List<Map<String,String>> mapList=new ArrayList();
		String SIGUN_NM=request.getParameter("SIGUN_NM");
		System.out.println(SIGUN_NM);
		Document xml = null;
	    try {
			/*
			 * https://openapi.gg.go.kr/Animalhosptl?SIGUN_NM=%EA%B4%91%EB%AA%85%EC%8B%9C
			 */	      
	      URL url = new URL("https://openapi.gg.go.kr/Animalhosptl?SIGUN_NM="+URLEncoder.encode(SIGUN_NM, "utf-8"));
	      URLConnection urlConnect = url.openConnection();
	      urlConnect.connect();

	      InputSource is = new InputSource(urlConnect.getInputStream());
	      
	      xml = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(is);

	      // root element 취득
	      Element element = xml.getDocumentElement();
	      
	      // child node 취득
	      NodeList list = element.getElementsByTagName("row");
//	      System.out.println(list);
	      // child node 가 1개 이상인 경우
	      if(list.getLength() > 0) {
	        for(int i=0; i<list.getLength(); i++) {

	          NodeList childList = list.item(i).getChildNodes();
	          
	          if(childList.getLength() > 0) {
	        	 
	        	  Map<String, String> map=new HashMap();
	            for (int j = 0; j < childList.getLength(); j++) {
	            	String hosName="",hosAddr="",hosPhone="",hosoff="";
	            	double hosXx=0,hosYy=0;
//	            	System.out.println(childList);
	            	if(!childList.item(j).getNodeName().equals("#text")) {
	            		String name=childList.item(j).getNodeName();
	            		String data=childList.item(j).getTextContent();
//	            		System.out.println(childList.item(j).getTextContent());
	            		if(data.length()>0)
	            			map.put(name,childList.item(j).getTextContent());
	            	}
	              }
	            mapList.add(map);
	            }
	          }
	        response.setContentType("application/json;charset=utf-8");
	        new Gson().toJson(mapList,response.getWriter());	
	    }
	    } catch (FileNotFoundException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    } catch (SAXException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    } catch (IOException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    } catch (ParserConfigurationException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	    //System.out.println(hosmap);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	}
		
		    
		

