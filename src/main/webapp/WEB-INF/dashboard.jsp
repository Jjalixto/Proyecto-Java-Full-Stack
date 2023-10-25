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
            <div class="d-flex align-items-center justify-content-between p-5">
                <p class="text-center fs-2 text-dark m-4">
                    Hello,
                    ${usuarioActual.name}
                </p>
                <a href="user/logout" class="btn btn-secondary h-25">log out</a>
            </div>

            <h1>
                Programas
            </h1>
            <table class="table table-striped border border-5">
                <thead>

                    <tr>
                        <th scope="col">Programa</th>
                        <th scope="col">Red</th>
                        <th scope="col">Promedio de Calificaciones</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="programa" items="${programas}">
                    <tr>
                        <td>${programa.id}</td>
                        <td><a href="/programas/${programa.id}">${programa.title}</a></td>
                        <td>${programa.red}</td>
                        <!-- <td>${programa.getPromedioCal(programa.getCalificaciones())}</td> -->
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
            <div class="d-flex justify-content-md-start m-2">
                <a href="/programas/new" class="btn btn-success">Agregar un programa</a>
            </div>

        </body>

        </html>