 select count(1) AS horas
 from programacion
 where clase = 1 and asistencia = 'No' and aprendiz = :aprendiz;