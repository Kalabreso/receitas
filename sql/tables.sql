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
    descricao text not null,
    ativo boolean not null default 1,
    usuario_id int not null,
    
    primary key(id),
    foreign key (usuario_id) references usuario(id)
);

create table ingrediente (
    id int not null auto_increment,
    nome varchar(255) not null,
    
    primary key(id),
);

create table receita_ingrediente (
    receita_id int not null,
    ingrediente_id int not null,
    medida varchar(100) not null,
    quantidade int not null,
    ativo boolean not null default 1,
    
    primary key(receita_id, ingrediente_id),
    foreign key (receita_id) references receita(id),
    foreign key (ingrediente_id) references ingrediente(id)
);