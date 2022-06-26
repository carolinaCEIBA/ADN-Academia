select count(1)
from programacion
where instructor =:instructor and DATE_FORMAT(fecha,'%Y-%m-%d') =:fecha and hora =:hora;