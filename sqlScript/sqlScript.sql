use jsfpfschema;

create table entidade(
	ent_codigo bigint not null,
    ent_inativo boolean not null,
    ent_login varchar(20),
    ent_senha varchar(20),
    
    constraint entidade_pk primary key(ent_codigo),
    constraint entidade_ent_login_key unique(ent_login)
    
)