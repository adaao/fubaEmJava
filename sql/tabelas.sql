CREATE TABLE fuba.amostras (
   id_amostra SERIAL NOT NULL,
   ds_quantidade INT,
   id_tipoDeAmostra INT,
   id_produto INT,
   id_armazem INT,
   dt_dataDaColeta TIMESTAMP,
   ds_nomeDoInspetor VARCHAR(255),
   id_tipoDeOperacao INT
);

CREATE TABLE fuba.tipoDeAmostra(
   id_tipoDeAmostra SERIAL NOT NULL,
   ds_tipoDeAmostra VARCHAR(50)
);

CREATE TABLE fuba.produtos(
   id_produto SERIAL NOT NULL,
   ds_produto VARCHAR(50)
);

CREATE TABLE fuba.armazens(
   id_armazem SERIAL NOT NULL,
   ds_armazem VARCHAR(50)
);

CREATE TABLE fuba.operacoes(
   id_tipoDeOperacao SERIAL NOT NULL,
   ds_operacao VARCHAR(50)
);

CREATE TABLE fuba.lacres(
   ds_lacre VARCHAR(50) NOT NULL,
   id_amostra INT NOT NULL
);
