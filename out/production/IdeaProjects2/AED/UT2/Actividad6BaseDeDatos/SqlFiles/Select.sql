SELECT nombre_prod, nombre_prov, precio_prod FROM productos INNER JOIN proveedores ON cod_prov = cod_prov_prod WHERE precio_prod > 2000 ORDER BY precio_prod DESC;