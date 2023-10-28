INSERT INTO tb_user (name, email, password, created_At) VALUES ('Bob','bob@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', TIMESTAMP WITH TIME ZONE '2023-10-23T18:23:07.12345Z');
INSERT INTO tb_user (name, email, password, created_At) VALUES ('Ana','ana@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', TIMESTAMP WITH TIME ZONE '2023-10-23T18:23:07.12345Z');

INSERT INTO tb_role (authority, created_At) VALUES ('ROLE_VISITOR', TIMESTAMP WITH TIME ZONE '2023-10-23T18:23:07.12345Z');
INSERT INTO tb_role (authority, created_At) VALUES ('ROLE_MEMBER', TIMESTAMP WITH TIME ZONE '2023-10-23T18:23:07.12345Z');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);

INSERT INTO tb_genre (name) VALUES ('Drama');
INSERT INTO tb_genre (name) VALUES ('Ação');

INSERT INTO tb_movie (title, sub_title, year, img_url, synopsis, genre_id) VALUES ('À Procura da Felicidade', 'Motivação, Determinação, Foco, Persistência e Realização', 2007, 'https://play-lh.googleusercontent.com/CBc1nvztC6rnnaxqPzUEeqm8yIsEzxW3uvmtung0DktA4dTv3XzP_eb2SdcQIXSPj0A=w240-h480-rw','Chris enfrenta sérios problemas financeiros e sua esposa, Linda, decide partir. Agora solteiro, ele precisa cuidar de Christopher, seu filho de cinco anos. Chris tenta usar sua habilidade como vendedor para conseguir um emprego melhor, mas só consegue um estágio não-remunerado. Seus problemas financeiros não podem esperar uma promoção e eles acabam despejados. Chris e Christopher passam a dormir em abrigos ou onde quer que consigam um refúgio, mantendo a esperança de que dias melhores virão.', 1);
INSERT INTO tb_movie (title, sub_title, year, img_url, synopsis, genre_id) VALUES ('Triplo X', 'xXx Totalmente Explosivo', 2002, 'https://br.web.img2.acsta.net/c_310_420/medias/nmedia/18/92/15/34/20183462.jpg','O ex-atleta de esportes extremos Xander "XXX" Cage, famoso por suas acrobacias que desafiam a morte, é convencido de que pode ter sucesso em ações que espiões convencionais falharam. Xander é recrutado pelo agente Gibbons para se tornar um tipo diferente de agente secreto. Agora, em uma perigosa missão, ele precisa usar todas as suas habilidades para combater um inimigo mortal.', 2);

INSERT INTO tb_review (text, user_id, movie_id) VALUES ('É um filme que traduz á importância da persistência e resiliência, diante de situações e circunstâncias extremas. Dai a minha preferência pelo filme.', 2, 1);
INSERT INTO tb_review (text, user_id, movie_id) VALUES ('Um ótimo filme!! Para quem gosta de filme de ação, esse não vai faltar... é pura adrenalina. Vin Diesel se encaixou muito bem no personagem.', 2, 2);
