<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
            <h1>
                Agregar un nuevo programa
            </h1>
            <form:form action="/programas/new" method="post" modelAttribute="programa">
                <p>
                    <form:label path="title" class="form-label">Tittle</form:label>
                    <form:input path="title" class="form-control" />
                    <form:errors class="text-danger" path="title" />
                </p>
                <p>
                    <form:label path="red" class="form-label">Red</form:label>
                    <form:input path="red" name="red" class="form-control" />
                    <form:errors path="red"  class="text-danger" />
                </p>
                <p>
                    <form:label path="descripcion" class="form-label">Descripcion</form:label>
                    <form:textarea path="descripcion" class="form-control" />
                    <form:errors class="text-danger" path="descripcion" />
                </p>
                <div class="d-flex justify-content-center m-2 gap-3">
                    <a href="/" class="btn btn-info">Cancel</a>
                    <input type="submit" class="btn btn-info" value="Submit">
                </div>
            </form:form>
        </body>

        </html>