 select count(1) AS horas
 from programacion
 where clase = 3 and aprendiz = :aprendiz;