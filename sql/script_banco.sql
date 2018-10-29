create table pessoa(
	nome varchar(100),
	telefone varchar(15),
	matricula integer primary key,
	bairro varchar(30),
	rua varchar(30),
	numero integer,
	complemento varchar(50)
);
create table aluno(
	login varchar(50),
	senha varchar(50),
	matricula_aluno integer,
	foreign key(matricula_aluno)
	references pessoa(matricula)
);

create table professor(
	area varchar(50),
	matricula_professor integer,
	foreign key(matricula_professor)
	references pessoa(matricula)
);

create table tag(
	palavra_chave  varchar(50),
	codigo integer primary key
);

create table tarefa(
	codigo integer primary key,
	titulo varchar(150),
	descricao varchar(500),
	dt_entrega date,
	dt_criacao date
);

create table disciplina(
	codigo integer primary key,
	tipo varchar(30),
	nome varchar(30)
);

create table professor_disciplina(
	matricula_professor integer,
	codigo_disciplina integer,
	foreign key(matricula_professor)
	references pessoa(matricula),
	foreign key(codigo_disciplina)
	references disciplina(codigo)
);

create table tarefa_tag(
	codigo_tag integer,
	codigo_tarefa integer,
	foreign key(codigo_tag)
	references tag(codigo),
	foreign key(codigo_tarefa)
	references tarefa(codigo)
);

create table aluno_tarefa(
	matricula_aluno integer,
	codigo_tarefa integer,
	foreign key(matricula_aluno)
	references pessoa(matricula),
	foreign key(codigo_tarefa)
	references tarefa(codigo)
);

create table aluno_professor(
	matricula_aluno integer,
	matricula_professor integer,
	foreign key(matricula_aluno)
	references pessoa(matricula),
	foreign key(matricula_professor)
	references pessoa(matricula)
);
