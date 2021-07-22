CREATE TABLE tb_usuario (
	id bigint(20) NOT NULL AUTO_INCREMENT,
	nome varchar(255) NOT NULL,
	email varchar(255) NOT NULL,
	senha varchar(25) NOT NULL,
	tipo varchar(255) NOT NULL,
	registro varchar(255) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE tb_tema (
	id bigint(20) NOT NULL AUTO_INCREMENT,
	saude varchar(255) NOT NULL,
	alimentacao varchar(255) NOT NULL,
	educacao varchar(255) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE tb_postagem (
	id bigint(20) NOT NULL AUTO_INCREMENT,
	qtd_caracter varchar(255) NOT NULL,
	qtd_likes bigint(20) NOT NULL,
	qtd_comentarios bigint(20) NOT NULL,
	midias varchar(20) NOT NULL,
	tema_id bigint(20) NOT NULL,
	user_id bigint(20) NOT NULL,
	PRIMARY KEY (id),
    
    foreign key(tema_id) references tb_tema(id),
    foreign key(user_id) references tb_usuario(id)
);




