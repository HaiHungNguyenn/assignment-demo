<%-- 
    Document   : view
    Created on : Feb 20, 2023, 11:23:49 PM
    Author     : admin
--%>

<%@page import="Model.AirlineDTO"%>
<%@page import="Model.ModelDAO"%>
<%@page import="Model.AirportDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <ul>
            <li><a href ="view.jsp?cate=airline">airline</a></li><br>
            <li><a href ="view.jsp?cate=airport">airport</a></li>
          
        </ul>
        <%            
            String cate = null;
            cate = request.getParameter("cate");
            out.print(cate);
            out.print("<br>");
            %>
            <table>
           <%
            if(cate!= null){
                    if(cate.equalsIgnoreCase("airport")){
                    out.print("<tr><td>ID</td><td>airportName</td></tr>");
                    List<AirportDTO> list = new ModelDAO<AirportDTO>().list(cate);
                    for (AirportDTO x : list) {
                            out.println(HTMLItem(x.getAirportID(), x.getAirportName()));
                        }
                    }else if(cate.equalsIgnoreCase("airline")){
                    out.print("<tr><td>ID</td><td>airlineName</td></tr>");
                    List<AirlineDTO> list = new ModelDAO<AirlineDTO>().list(cate);
                    for (AirlineDTO x : list) {
                            out.println(HTMLItem(x.getAirlineID(), x.getAirlineName()));
                        }

                    }
            }
        %>
            </table>
    </body>
</html>
<%!
    public String HTMLItem(String id,String name){
        String item
                = "<tr><td>"+id+"</td><td>"+name+"</td></tr>";
        return  item;
    }
%>
