<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Inventario</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
</head>
<body>
<h1>Inventario</h1>
<div>
    <a class="btn" href="/">Volver al inicio</a>
    <a class="btn" href="/crea-item">Añadir item</a>
</div>
<br/><br/>
<div>
    <table id="notas">
        <tbody><tr>
            <th>ID</th>
            <th>Item</th>
            <th>Cantidad</th>
        </tr>
        <#list items as item>
            <tr>
                <td><a href="/item/${item.id}">${item.id}</a></td>
                <td>${item.nombre}</td>
                <td>${item.cantidad}</td>
                <td><a href="/edita-item/${item.id}">Editar</a></td>
                <td><a href="/elimina-item/${item.id}">Borrar</a></td>
            </tr>
        </#list>
        </tbody>
    </table>
</div>
</body>
</html>