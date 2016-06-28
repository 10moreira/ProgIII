/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  mateus
 * Created: 14/06/2016
 */

create table carros(
codigo serial not null primary key,
nomeCarro varchar(30),
chassi varchar(20),
marca varchar(20),
cor varchar(15),
placa varchar(10));


create table clientes(
codigo serial not null, 
nome varchar(40),
sobreNome varchar(40),
email varchar(40),
cpf varchar(20),
rg varchar(20),
cep varchar(20),
rua varchar(40),
nro integer,
bairro varchar(40),
fone varchar(20),
celular varchar(20),
carro integer,
primary key(carro),
FOREIGN KEY (carro) REFERENCES carros(codigo));


create table catalago(
id_foto serial not null primary key,
imagem bytea);



select * from catalago;
select * from carros;
select * from bas_paises;
select * from bas_estados;
select * from bas_cidades;

drop table carros;
drop table clientes;

insert into carros (nomecarro, chassi, marca, cor, placa) values 
                    ('Enzo', '897er4tr', 'Ferrari', 'Vermelha', 'IVR-8050'), 
                    ('Cayman S', '898w7errtr', 'Porsche', 'Preto', 'IVT-1050');


DELETE FROM carros where codigo = 40;
select * from carros;

insert into clientes (nome, sobrenome, email, cpf, rg, cep, rua, nro, bairro, fone, celular, carro) values
    ('Joao','Da Silva','joao@gmail.com', '03398325062','221245656', '96418325', 'Ben-te-vi', 354, 'Pedras Brancas', '32471058', 99365214, 1),
    ('Pedro','Pereira','pedro@hotmail.com', '0335214789','884579635', '9614752', 'Pr Vargas', 558, 'São Judas', '32475296', 99365214, 2);


select * from  bas_estados where ref_pais  = 10;

select * from bas_estados where id = 'RS';

