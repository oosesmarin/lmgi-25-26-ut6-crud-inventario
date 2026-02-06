<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title><#if agregar>Crear Item<#else>Editar Item</#if></title>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
</head>
<body>
    <h1><#if agregar>Crear<#else>Editar</#if> Item</h1>
    <a href="/lista-items">Regresar al listado</a>
    <br/><br/>

    <form action="<#if agregar>/crea-item<#else>/edita-item/${item.id}</#if>" method="POST">
        <div class="container">
            <div class="w60">
                <label for="nombre">Nombre</label>
                <input type="text" name="nombre" value="${item.nombre}">
            </div>
            <div class="w25 center">
                <label for="cantidad">Cantidad</label>
                <input type="text" name="cantidad" value="${item.cantidad}">
            </div>
            <div class="w15 center">
                <label for="id">ID</label>
                <input type="text" name="id" value="${item.id}" disabled="disabled">
            </div>
        </div>

        <input type="submit" value="Guardar">
    </form>
    <br/>

</body>
</html>