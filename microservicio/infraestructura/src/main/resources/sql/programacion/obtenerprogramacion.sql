SELECT C.descripcion, A.nombre, I.nombreins, P.fecha, P.hora, P.asistencia
FROM clase C, aprendiz A, instructor I, programacion P
WHERE C.id = P.clase and A.id = P.aprendiz and I.id = P.instructor