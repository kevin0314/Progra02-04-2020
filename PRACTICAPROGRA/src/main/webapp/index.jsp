<html>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<body>
<h2>Agregar Datos</h2>
<table align="center">
	
   <thead>
   	<tbody>
   		<tr>
   		<td>
   			<form action="ServeleteControler" method="post">
   				<p>Id</p><input type="text" name="Id">
   				<p>Nombre producto</p><input type="text" name="Nproductos">
   				<p>Precio producto</p><input type="text" name="Pproductos">
   				<p>Cantidad de producto</p><input type="text" name="Cproductos">
   				<p>Total de producto</p><input type="text" name="Tproductos">
   				<br>
   				<br>
   				  <input type="submit" name="btn" value="Agregar" class="btn btn-info">
   				   <input type="submit" name="btn" value="Editar" class="btn btn-Warning">
               <input type="submit" name="btn" value="Eliminar" class="btn btn-danger">
   				
   				
   			</form>
           </td>
   		</tr>

   	</tbody>

   </thead>

</table>


</body>
</html>
