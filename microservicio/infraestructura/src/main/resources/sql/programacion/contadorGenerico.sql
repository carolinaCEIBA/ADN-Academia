 select count(1) AS horas
 from programacion
 where clase = :clase and aprendiz = :aprendiz;