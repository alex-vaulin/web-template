Передзапуском нужно:
1. В файле application.yml поменять переменные для подключения к локальной базе: <br>
   a). spring.datasource.url <br>
   б). spring.datasource.user <br>
   в). spring.datasource.password <br>
2. Выполнить запрос в БД:
``` sql
CREATE TABLE student(
id UUDI,
name varchar(32),
birthDate DATE,
number varchar(32),
primary key (id)
);

# Добавление ролей
INSERT INTO public.t_role(id, name)
  VALUES (1, 'ROLE_USER'), (2, 'ROLE_ADMIN');
```
 
Ссылки :
1. URL : `http://localhost:8081`


