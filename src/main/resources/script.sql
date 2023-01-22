
--lo viejo

CREATE TABLE facturas (
	id bigserial NOT null unique primary key,
	nombre varchar(255) not null unique,
	url varchar(255) NULL
);


CREATE TABLE pagos (
	id bigserial NOT null unique primary key,
	fecha_de_pago date not null,
	pago float8 not null,
	factura_id bigserial not null,
	comentario varchar(255) NULL,
	CONSTRAINT pagos_facturas_fk FOREIGN KEY (factura_id) REFERENCES facturas(id)
);


--lo nuevo
create table usuarios(
	id bigserial primary key,
	usuario varchar(50) not null unique
);
--drop table porcentaje_usuarios_facturas
create table porcentaje_usuarios_facturas(
	id bigserial primary key,
	usuario_id bigserial not null,
	factura_id bigserial not null,
	porcentaje int not null check (porcentaje <= 100),
	constraint renglon_unico_porcentaje_usuarios_facturas unique (usuario_id, factura_id),
	constraint porcentaje_usuarios_pagos_usuarios_fk foreign key (usuario_id) references usuarios(id)
		on update cascade
		on delete cascade,
	constraint porcentaje_usuarios_pagos_usuarios_facturas_fk foreign key (factura_id) references facturas(id)
		on update cascade
		on delete cascade
);
drop table pagos_usuarios;
create table pagos_usuarios(
	id bigserial primary key,
	usuario_id bigserial not null,
	pago_id bigserial not null,
	pago_fraccionado float not null,
	constraint renglon_unico_pagos_usuarios unique (usuario_id, pago_id),
	constraint pagos_usuarios_usuarios_fk foreign key (usuario_id) references usuarios(id)
		on update cascade
		on delete cascade,
	constraint pagos_usuarios_pagos_fk foreign key (pago_id) references pagos(id)
		on update cascade
		on delete cascade
);
-- comienzo a agregar nuevas funcionalidades a la base de datos
--triggers
--cuando creo un nuevo pago funcion
create or replace function crear_actualizar_pago_por_usuario() returns trigger
as
$$
begin
	insert into pagos_usuarios (usuario_id, pago_id, pago_fraccionado)
	select u.id, p.id , p.pago * puf.porcentaje / 100 as pago_usuario from pagos p
				inner join porcentaje_usuarios_facturas puf on puf.factura_id = p.factura_id
				inner join facturas f on f.id = p.factura_id
				inner join usuarios u on u.id = puf.usuario_id
			where p.id = new.id
		on conflict (usuario_id, pago_id)
		do update
			set
				usuario_id = excluded.usuario_id,
				pago_id  = excluded.pago_id,
				pago_fraccionado  = excluded.pago_fraccionado;
	return new;
end
$$
language plpgsql;
--cuando creo un pago
create trigger crear_pago_por_usuario_tr
	after insert
	on pagos
	for each row
	execute procedure crear_actualizar_pago_por_usuario();
--cuando actualizo un pago
create trigger actualizar_pago_por_usuario_tr
	after update
	on pagos
	for each row
	execute procedure crear_actualizar_pago_por_usuario();


