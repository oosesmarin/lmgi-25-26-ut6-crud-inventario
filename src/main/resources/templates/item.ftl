<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Item</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
</head>
<body>
    <#if eliminar>
        <h1>Eliminar el Item</h1>
    <#else>
        <h1>Vista del Item</h1>
    </#if>
    <a href="/lista-items">Volver a la lista</a>
    <br/><br/>
        
    <#if !mensajeError??>
        <table id="notas">
            <tbody>
            <tr>
                <th>ID</th>
                <td>${item.id}</td>
            </tr>
            <tr>
                <th>Item</th>
                <td>${item.nombre}</td>
            </tr>
            <tr>
                <th>Cantidad</th>
                <td>${item.cantidad}</td>
            </tr>
            </tbody>
        </table>
        <br/><br/>
    </#if>

    <#if eliminar>
        <form action="/elimina-item/${item.id}" method="POST">
            ¿Seguro que desea eliminar el item? <input type="submit" value="Confirmar" />
        </form>
    <#else>
        <div>
            <a href="/elimina-item/${item.id}">Eliminar</a>
            <a href="/edita-item/${item.id}">Editar</a>
        </div>
    </#if>

</body>
</html>