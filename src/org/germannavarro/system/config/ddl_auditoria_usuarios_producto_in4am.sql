DROP DATABASE IF EXISTS auditoria_usuarios_producto_in4am;
create database auditoria_usuarios_producto_in4am;
use auditoria_usuarios_producto_in4am;

create table Users(
	name varchar(50) not null check( length(name)<=50 ),
    lastname varchar(50) not null check( length(lastname)<=50 ),
    email varchar(50) not null check( length(email)<=50 ),
    user varchar(25)not null check( length(user)<=25 ),
    password varchar(35)not null check( length(password)<=35 ),
    id_user varchar(40) not null,
    constraint pk_users primary key (id_user)
    );
    
    -- Uso del constraint para la validacion y estructura e informacion
    
    Delimiter $$
		CREATE PROCEDURE sp_create_users(in name_p varchar (50),
										in lastname_p varchar(50),
                                        in email_p varchar(50),
                                        in user_p varchar(25),
                                        in password_p varchar(35))
		BEGIN
			insert into Users(name, lastname, email, user, password, id_user )
				VALUES(name_p, lastname_p, email_p, user_p, password_p, uuid());
		END$$
    Delimiter  ;
    
    CALL sp_create_users('Carlos', 'Mendoza', 'carlos@example.com', 'cmendoza', 'pass123');
	CALL sp_create_users('Ana', 'Gomez', 'ana.g@example.com', 'anag', 'secure456');
	CALL sp_create_users('Luis', 'Torres', 'ltorres@example.com', 'ltorres', 'myPass789');
	CALL sp_create_users('Maria', 'Lopez', 'm.lopez@example.com', 'mlopez', 'p@ssword1');
	CALL sp_create_users('Diego', 'Ramirez', 'diego.r@example.com', 'dramirez', 'passWord99');
    
	DELIMITER $$
	CREATE PROCEDURE sp_read_user()
	BEGIN
		SELECT id_user, name, lastname, email, `user` 
		FROM Users;
	END$$
	DELIMITER ;
    
    
    Delimiter $$
		CREATE PROCEDURE sp_search_user(IN user_p varchar(25))
        BEGIN
			SELECT id_user, `user`, password
            FROM Users
            WHERE `user` = user_p;
        END $$
    Delimiter  ;
    
    CALL sp_search_user('cmendoza');