<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%@ page
language="java" contentType="text/html; charset=UTF-8" %> 
<%@ page import="java.util.ArrayList" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Document</title>
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
                crossorigin="anonymous">
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
                crossorigin="anonymous"></script>
        </head>

        <body class="container">
            <div class="container">

                <div class="d-flex align-items-center justify-content-between mt-6">
                    <p class="fs-1 text-dark my-4">
                        ${programa.title}
                    </p>
                    <a href="/programas" class="btn btn-secondary h-25">volver al panel</a>
                </div>

                <div class="mb-4">
                    <div class="d-flex my-2">                
                        <form:label path="title">Agregada por: </form:label>
                        <form:label path="title">${programa.usuario.name}</form:label>
                    </div>
                    <div class="d-flex my-2">
                        <form:label path="title">Red de televisión: </form:label>
                        <form:label path="title">${programa.red}</form:label>
                    </div>
                    <div class="d-flex my-2">
                        <form:label path="title">Descripción: </form:label>
                        <form:label path="title">${programa.descripcion}</form:label>
                    </div>

                </div>
                <a  class="btn btn-info mb-4" href="/programas/${programa.id}/edit">Editar</a>
    
                <!-- <table class="table table-striped border border-5">
                    <thead>
    
                        <tr>
                            <th scope="col" class="border border-1">Name</th>
                            <th scope="col" class="border border-1">Rating</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="calificaciones" items="${programa.calificaciones}">
                            <tr>
                                <td>${calificaciones.usuario.name}</td>
                                <td>${calificaciones.rating}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table> -->
                <!-- <div class="d-flex align-items-center">
                    <div>
                        <span class="p-1">Deja una calificación</span>
    
                    </div>
                    <form method="post" action="/programas/${programa.id}/rating" >
                        <input type="number" name="rating" min="0.5" max="5.0" step="0.1" class="form-control m-1" style="width: 200px;"/>
                        <input type="submit" class="btn btn-info m-1" value="Califica!">
                    </form>    
                </div> -->
            </div>
            
        </body>

        </html>