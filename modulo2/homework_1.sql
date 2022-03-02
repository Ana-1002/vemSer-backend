/* Criar uma tabela ESTUDANTE com os campos:
 id: numérico e chave primária
 nome: texto até 200 caracteres não nulo
 data_nascimento: Data não nulo
 nr_matricula: numérico de 10 não nulo
 ativo: caracter (‘S’ = ativo, ‘N’ = não ativo)
• Criar uma sequence para essa tabela (seq_estudante)
• Inserir 10 registros para essa tabela
• Selecionar os registros*/

CREATE TABLE VEM_SER.ESTUDANTE (
id_estudante  NUMBER NOT NULL,
nome VARCHAR2(200) NOT NULL,
data_nascimento DATE NOT NULL,
nr_matricula NUMBER (10) UNIQUE NOT NULL,
ativo CHAR(1) NOT NULL,
PRIMARY KEY(id_estudante)
);
CREATE SEQUENCE VEM_SER.seq_estudante
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;

INSERT INTO VEM_SER.ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES(VEM_SER.seq_estudante.nextval, 'Ana Vitória', TO_DATE('08-09-1991', 'dd-mm-yyyy'), 1234567890, 'S');

INSERT INTO VEM_SER.ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES(VEM_SER.seq_estudante.nextval, 'Maicon Machado Gerardi', TO_DATE('08-09-1991', 'dd-mm-yyyy'), 1234567892, 'S');

INSERT INTO VEM_SER.ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES
(VEM_SER.seq_estudante.nextval, 'Lucas', TO_DATE('08-09-1991', 'dd-mm-yyyy'), 1234567891, 'S');

INSERT INTO VEM_SER.ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES
(VEM_SER.seq_estudante.nextval, 'Joao', TO_DATE('08-09-1991', 'dd-mm-yyyy'), 1234678903, 'S');

INSERT INTO VEM_SER.ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES(VEM_SER.seq_estudante.nextval, 'Luciano', TO_DATE('08-09-1991', 'dd-mm-yyyy'), 1234578904, 'S');

INSERT INTO VEM_SER.ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES(VEM_SER.seq_estudante.nextval, 'Augusto', TO_DATE('08-09-1991', 'dd-mm-yyyy'), 1234568905, 'N');

INSERT INTO VEM_SER.ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES(VEM_SER.seq_estudante.nextval, 'Fabio', TO_DATE('08-09-1991', 'dd-mm-yyyy'), 1234567897, 'S');

INSERT INTO VEM_SER.ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES(VEM_SER.seq_estudante.nextval, 'Bruna', TO_DATE('08-09-1991', 'dd-mm-yyyy'), 1234567908, 'N');

INSERT INTO VEM_SER.ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES(VEM_SER.seq_estudante.nextval, 'Nicole', TO_DATE('08-09-1991', 'dd-mm-yyyy'), 1234567909, 'S');

INSERT INTO VEM_SER.ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES(VEM_SER.seq_estudante.nextval, 'Liane', TO_DATE('08-09-1991', 'dd-mm-yyyy'), 123456780, 'N');

SELECT * FROM VEM_SER.ESTUDANTE;