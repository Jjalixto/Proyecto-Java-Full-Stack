<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@ page language="java" contentType="text/html; charset=UTF-8" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Document</title>
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
                    integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
                    crossorigin="anonymous">
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
                    integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
                    crossorigin="anonymous"></script>
            </head>

            <body class="container">
                <h1 class="text-center text-success m-4">
                    Bienvenidos a TVD
                </h1>
                <div class="d-flex g-3 justify-content-around">
                    <div>
                        <h2>
                            Registrate
                        </h2>
                        <form:form action="/user/new" method="post" modelAttribute="usuario">
                            <p>
                                <form:label path="name" class="form-label">Name</form:label>
                                <form:input path="name" class="form-control" />
                                <form:errors class="text-danger" path="name" />
                            </p>
                            <p>
                                <form:label path="email" class="form-label">Email</form:label>
                                <form:input type="email" path="email" class="form-control" />
                                <form:errors class="text-danger" path="email" />
                            </p>
                            <p>
                                <form:label path="password" class="form-label">Password</form:label>
                                <form:input type="password" path="password" class="form-control" />
                                <form:errors class="text-danger" path="password" />
                            </p>
                            <p>
                                <form:label path="confirmPassword" class="form-label">confirmPassword</form:label>
                                <form:input type="password" path="confirmPassword" class="form-control" />
                                <form:errors class="text-danger" path="confirmPassword" />
                            </p>
                            <div class="d-flex justify-content-md-end m-2">
                                <input type="submit" class="btn btn-info" value="Registrate">
                            </div>
                        </form:form>
                    </div>
                    <div>
                        <h2>
                            Iniciar Sesión
                        </h2>
                        <form action="/user/login" method="post">
                            <p>
                                <label class="form-label">Email</label>
                                <input type="email" name="email" class="form-control" />
                            <p class="text-danger">
                                <c:out value="${errorLogin}" />
                            </p>
                            </p>
                            <p>
                                <label path="password" class="form-label">Password</label>
                                <input type="password" name="password" class="form-control" />
                            <p class="text-danger">
                                <c:out value="${passwordErrorIn}" />
                            </p>
                            </p>
                            <div class="d-flex justify-content-md-end m-2">
                                <input type="submit" class="btn btn-info" id="/user/login" value="Iniciar Sesión">
                            </div>
                        </form>
                    </div>
                </div>
            </body>

            </html>