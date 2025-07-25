CREATE SCHEMA IF NOT EXISTS sch_pessoas;

CREATE SCHEMA IF NOT EXISTS sch_processos;

CREATE SCHEMA IF NOT EXISTS sch_dados;

create table sch_pessoas.responsavel (
	id serial primary key,
	nome character varying(255) not null,
	endereco character varying(255) not null,
	cep character varying(11) not null,
	uf character varying(3) not null,
	cidade character varying(255) not null
);

create table sch_processos.processo (
	id serial primary key,
	nome character varying(255) not null,
	eh_dado_sensivel boolean not null,
	data_criacao date not null,
	data_atualizacao date,
	proc_compra character varying(255),
	controle character varying(255) not null,
	nome_org_transf character varying(255),
	id_responsavel integer,
	obj_proc_compra character varying(255) not null,
	descricao_controle character varying(255) not null,
	pais_org_transf character varying(255),
	dado_org_transf character varying(255),
	
	constraint fk_processo foreign key (id_responsavel)
	references sch_pessoas.responsavel (id)

);

create table sch_pessoas.agente (
	id serial primary key,
	nome character varying(255) not null,
	endereco character varying(255) not null,
	cep character varying(11) not null,
	categoria character varying(255) not null,
	email character varying(255) not null check (email ~* '^[A-Za-z0-9._%-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,4}$'),
	telefone character varying(255),
	id_processo integer,
	
	constraint fk_agente foreign key (id_processo)
	references sch_processos.processo (id)

);


create table sch_processos.ciclo (
	id serial primary key,
	desc_fluxo_tratamento character varying(255) not null,
	tem_eliminacao boolean not null,
	tem_retencao boolean not null,
	tem_coleta boolean not null,
	tem_processamento boolean not null,
	tem_compartilhamento boolean not null,
	id_processo integer,
	
	constraint fk_ciclo foreign key (id_processo)
	references sch_processos.processo (id)
);


create table sch_processos.escopo (
	id serial primary key,
	fonte_dados character varying(255) not null,
	abrang_geografica character varying(255) not null,
	finalidade_trat character varying(255) not null,
	hipotese_trat character varying(255) not null,
	resultado_pretendido character varying(255) not null,
	beneficio_esperado character varying(255) not null,
	previsao_legal character varying(255) not null,
	id_ciclo integer,
	
	constraint fk_escopo foreign key (id_ciclo)
	references sch_processos.ciclo (id)
);


create table sch_dados.dado (
	id serial primary key,
	tipo_dado character varying(255) not null

);


create table sch_dados.trata (
	id_dado integer not null,
	id_agente integer not null,
	frequencia character varying(255) not null,
	quantidade integer not null,
	
	primary key (id_dado, id_agente),
	
	constraint fk_tratamento foreign key (id_dado)
	references sch_dados.dado (id) on delete cascade,
	
	constraint fk_tratamento2 foreign key (id_agente)
	references sch_pessoas.agente (id) on delete cascade
);


create table sch_pessoas.titular (
	id serial primary key,
	tipo_controle character varying(255) not null,
	finalidade_controle character varying(255) not null,
	inst_compart character varying(255) not null,
	descr_dados_inst_compart character varying(255) not null,
	finalide_inst_compart character varying(255) not null,
	id_dado integer,
	
	constraint fk_titular foreign key (id_dado)
	references sch_dados.dado (id)

);


create table sch_dados.dado_pessoal (
	id serial primary key,
	id_dado integer,
	associacao character varying(255) not null,
	proc_judicial character varying(255) not null,
	educacao character varying(255) not null,
	desc_trata_dado_pessoal character varying(255) not null,
	identificacao character varying(255),
	dado_ident_eletr character varying(255),
	fonte_ident_eletr character varying(255),
	tempo_retencao_dado_ident_eletr character varying(255),
	nome_bd_ident_eletr character varying(255),
	localizacao_eletronica character varying(255),
	dados_finac character varying(255),
	fonte_dados_financ character varying(255),
	tempo_retencao_dados_financ character varying(255),
	nome_bd_dados_financ character varying(255),
	caract_pessoal character varying(255),
	tempo_retenc_caract_pessoal character varying(255),
	fonte_caract_pessoal character varying(255),
	nome_bd_caract_pessoal character varying(255),
	habito character varying(255),
	habito_tempo_retenc character varying(255),
	habito_fonte character varying(255),
	habito_nome_bd character varying(255),
	interesse character varying(255),
	descr_psicologica character varying(255),
	tempo_retenc_descr_psicologica character varying(255),
	fonte_descr_psicologica character varying(255),
	nome_bd_descr_psicologica character varying(255),
	comp_familiar character varying(255),
	tempo_retencao_comp_familiar character varying(255),
	fonte_comp_familiar character varying(255),
	nome_bd_comp_familiar character varying(255),
	
	constraint fk_dado_pessoal foreign key (id_dado)
	references sch_dados.dado (id)

);


create table sch_dados.dado_sensivel (
	id serial primary key,
	id_dado integer,
	religiao character varying(255),
	tempo_retenc_religiao character varying(255),
	fonte_religiao character varying(255),
	nome_bd_religiao character varying(255),
	politica character varying(255),
	tempo_retenc_politica character varying(255),
	fonte_politica character varying(255),
	nome_bd_politica character varying(255),
	fil_sindical character varying(255),
	tempo_retenc_fil_sindical character varying(255),
	fonte_fil_sindical character varying(255),
	nome_bd_fil_sindical character varying(255),
	sexualidade character varying(255),
	tempo_retenc_sexualidade character varying(255),
	fonte_sexualidade character varying(255),
	nome_bd_sexualidade character varying(255),
	saude character varying(255),
	tempo_retenc_saude character varying(255),
	fonte_saude character varying(255),
	nome_bd_saude character varying(255),
	genetica character varying(255),
	tempo_retenc_genetica character varying(255),
	fonte_genetica character varying(255),
	nome_bd_genetica character varying(255),
	
	constraint fk_dado_sensivel foreign key (id_dado)
	references sch_dados.dado (id)

);


insert into sch_pessoas.responsavel (nome, endereco, cep, uf, cidade) values
('Fulano de Tal', 'Rua Sem número','20000560','RJ', 'Rio de Janeiro');



insert into sch_processos.processo (
	nome,	
	eh_dado_sensivel, 
	data_criacao , 
	data_atualizacao,
	proc_compra,
	controle , 
	nome_org_transf,
	id_responsavel,
	obj_proc_compra,
	descricao_controle,
	pais_org_transf,
	dado_org_transf 
	) values
('Jose das Couves', true, '2025-07-23','2025-07-23', '1256365/2025-45','Manual', 'Instituto dos Dados',1,'Materal de escritório','planilha excel','Chile','empresa de tratamento');


insert into sch_pessoas.agente (
	nome,
	endereco,
	cep ,
	categoria,
	email ,
	telefone,
	id_processo
) values
('Tia Maria', 'Rua oitenta, 857', '0523652','Pessoa Física','tia-maria@email.com.br', '996589658', 1);


insert into sch_processos.ciclo (
	desc_fluxo_tratamento,
	tem_eliminacao,
	tem_retencao,
	tem_coleta ,
	tem_processamento,
	tem_compartilhamento,
	id_processo
) values
('Tratamento realizado por agente, de forma manual', false, true, false, false, true,1);


insert into sch_processos.escopo (
	fonte_dados,
	abrang_geografica,
	finalidade_trat,
	hipotese_trat,
	resultado_pretendido,
	beneficio_esperado,
	previsao_legal,
	id_ciclo
) values
('planilha excel','Nacional','manter controle','tratamento digital','controle das atividades','redução de custo','Não se aplica',1);


insert into sch_dados.dado (
tipo_dado
) values
('Dado pessoal');



insert into sch_dados.trata (
	id_dado, 
	id_agente,
	frequencia, 
	quantidade 
) values
(1,1,'1 vez por dia',2);


insert into sch_pessoas.titular (
	tipo_controle,
	finalidade_controle,
	inst_compart,
	descr_dados_inst_compart,
	finalide_inst_compart,
	id_dado
) values
('Manual','Identificar e mapear dados', 'Não há','Não há','Não há',1);


insert into sch_dados.dado_pessoal (
	id_dado,
	associacao,
	proc_judicial,
	educacao,
	desc_trata_dado_pessoal,
	identificacao,
	dado_ident_eletr,
	fonte_ident_eletr,
	tempo_retencao_dado_ident_eletr,
	nome_bd_ident_eletr,
	localizacao_eletronica,
	dados_finac,
	fonte_dados_financ, 
	tempo_retencao_dados_financ,
	nome_bd_dados_financ,
	caract_pessoal,
	tempo_retenc_caract_pessoal,
	fonte_caract_pessoal,
	nome_bd_caract_pessoal,
	habito,
	habito_tempo_retenc, 
	habito_fonte,
	habito_nome_bd,
	interesse,
	descr_psicologica,
	tempo_retenc_descr_psicologica,
	fonte_descr_psicologica,
	nome_bd_descr_psicologica,
	comp_familiar,
	tempo_retencao_comp_familiar,
	fonte_comp_familiar,
	nome_bd_comp_familiar
) values
(
1,
'Associação dos funcionário públicos',
'00002125/2025-14',
'Não se aplica',
'dados bancários',
'1112235',
'sistema bancário',
'20 anos',
'bd_finaca',
'Não se aplica',	
'Não se aplica',
'Não se aplica',
'Não se aplica',
'Não se aplica',
'Não se aplica',
'Não se aplica',
'Não se aplica',
'Não se aplica',
'Não se aplica',
'Não se aplica',
'Não se aplica',
'Não se aplica',
'Não se aplica',
'Não se aplica',
'Não se aplica',
'Não se aplica',
'Não se aplica',
'Não se aplica',
'Não se aplica',
'Não se aplica',
'Não se aplica',
'Não se aplica'
);


insert into sch_dados.dado_sensivel (
	id_dado,
	religiao ,
	tempo_retenc_religiao ,
	fonte_religiao,
	nome_bd_religiao ,
	politica ,
	tempo_retenc_politica ,
	fonte_politica ,
	nome_bd_politica ,
	fil_sindical ,
	tempo_retenc_fil_sindical ,
	fonte_fil_sindical ,
	nome_bd_fil_sindical ,
	sexualidade ,
	tempo_retenc_sexualidade ,
	fonte_sexualidade ,
	nome_bd_sexualidade ,
	saude ,
	tempo_retenc_saude ,
	fonte_saude ,
	nome_bd_saude ,
	genetica ,
	tempo_retenc_genetica,
	fonte_genetica,
	nome_bd_genetica
) values
(
1,
'Armazenado em disco',
'10 anos',
'db_pessoas',
'Não se aplica',	
'Não se aplica',
'Não se aplica',
'Não se aplica',
'Não se aplica',
'Não se aplica',
'Não se aplica',
'Não se aplica',
'Não se aplica',
'Não se aplica',
'Não se aplica',
'Não se aplica',
'Não se aplica',
'Não se aplica',
'Não se aplica',
'Não se aplica',
'Não se aplica',
'Não se aplica',
'Não se aplica',
'Não se aplica',
'Não se aplica'
);




