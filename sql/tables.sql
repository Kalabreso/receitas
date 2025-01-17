create table usuario (
    id int not null auto_increment,
    nome varchar(255) not null,
    email varchar(255) not null unique,
    senha varchar(100) not null,
    ativo boolean not null default 1,
    
    primary key(id)
);

create table receita (
    id int not null auto_increment,
    nome varchar(255) not null,
    ingredientes text not null,
    descricao text not null,
    ativo boolean not null default 1,
    usuario_id int not null,
    
    primary key(id),
    foreign key (usuario_id) references usuario(id)
);