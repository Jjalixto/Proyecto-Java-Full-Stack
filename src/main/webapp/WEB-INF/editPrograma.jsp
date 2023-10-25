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
                ${programa.title}
            </h1>
            <form:form action="/programas/${programa.id}/edit" method="post" modelAttribute="editarPage">
                <p>
                    <form:label path="title" class="form-label">Tittle</form:label>
                    <form:input path="title" class="form-control" value="${programa.title}"/>
                    <form:errors class="text-danger" path="title" />
                </p>
                <p>
                    <form:label path="red" class="form-label">Network</form:label>
                    <form:input path="red" name="red" class="form-control" value="${programa.red}" />
                    <form:errors path="red" class="text-danger" />
                </p>
                <p>
                    <form:label path="descripcion" class="form-label">Descripcion</form:label>
                    <form:input path="descripcion" class="form-control" type="text" value="${programa.descripcion}" />
                    <form:errors class="text-danger" path="descripcion" />
                </p>
                <div class="d-flex my-4 gap-3">
                    <button type="button" class="btn btn-danger" onclick="finalizarMesa('${programa.id}')">Eliminar</button>
                    <a href="/programas" class="btn btn-info">Cancel</a>
                    <input type="submit" class="btn btn-info" value="Enviar">
                </div>
            </form:form>
            <script>
                function finalizarMesa(id){
                Swal.fire({
                    title: 'Quieres eliminar el programa?',
                    showDenyButton: true,
                    showCancelButton: true,
                    confirmButtonText: 'eliminar',
                    denyButtonText: `no eliminar`,
                    }).then((result) => {
                    /* Read more about isConfirmed, isDenied below */
                    if (result.isConfirmed) {
                    
                        window.location.href="/programas/" + id +"/delete" 
                        Swal.fire('Saved!', '', 'success')
                    } else if (result.isDenied) {
                        Swal.fire('no se an guardado los cambios', '', 'info')
                    }
                })
            }
            </script>
            <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        </body>

        </html>