Insert Into fazendabd.animaldoente (id, dataNascimento, identificacaoNominal, diaFinalDoTratamento,
 diaInicioTratamento, especie, tratamentoUsado)
Values (01, "10-01-2010", "Totó", "12-05-2020", "01-05-2020", "Cachorro", "Medicação misturada na água"),
(02, "05-03-2013", "Pangaré", "01-04-2020", "30-03-2020", "Cavalo", "Duas injeções em dias alternados"),
(03, "18-01-2015", "Soberano", "04-08-2020", "04-08-2020", "Boi", "Soro na veia");

Insert Into fazendabd.equipamentoprotecao (id, dataAquisicao, durabilidadeEstimada, nome,
 observacoes, ultimoSetorUsar, valorCompra)
Values (01, "01-02-2020", "2 anos", "Luvas de couro", "Em perfeito estado", "Vaqueiros", 35.59),
(02, "01-02-2020", "Descartavel", "Pacote de luvas com 100 luvas descartaveis", "Já usado 50 luvas", "Tratadores", 148.90),
(03, "05-01-2019", "5 anos", "Um par de botas", "Desgaste padrão", "Vaqueiros", 50.00);

Insert Into fazendabd.fazenda (id, areaReserva, areaTotal, localizacao,
 nome, observacoes)
Values (01, 13.0, 78.3, "Proximo a nascente do Rio Cipó", "Fazenda Cipó Amarelo", "Filial do Seu José"),
(02, 24.0, 189.3, "A 500m da ponte de Jequitibá", "Fazenda Jequitibá amarelo", "Matriz do Seu José");

Insert Into fazendabd.ferramenta (id, dataAquisicao, durabilidadeEstimada, nome,
 observacoes, ultimoSetorUsar, valorCompra)
Values (01, "01-02-2020", "10 anos", "Martelo", "Em perfeito estado", "Manutenção", 35.79),
(02, "01-02-2020", "5 anos", "Alicate", "Necessário passar graxa", "Vaqueiros", 15.99),
(03, "01-02-2020", "5 anos", "Carrinho de mão", "Trocou Pneu em Agosto", "Tratadores", 119.09);

Insert Into fazendabd.funcionario (id, cpf, dataNascimento, nome,
 dataAdmissao, senha, ultimaFerias, usuario)
Values (01, "000.000.000-00", "13-01-1986", "Joaquim Divino", "05-11-2017", "12345", "Janeiro de 2020", "divino"),
(02, "000.000.000-00", "23-12-1997", "Leandro Costa", "09-03-2020", "12345", "Sem nenhuma", "costa"),
(03, "000.000.000-00", "27-09-1990", "Vinicius Gomes", "12-09-2019", "12345", "Irá tirar em Dezembro de 2020", "gomes");

Insert Into fazendabd.maquina (id, dataAquisicao, durabilidadeEstimada, nome,
 observacoes, ultimoSetorUsar, valorCompra, teveManutencao, ultimaRevisao)
Values (01, "02-01-2015", "10 a 15 anos", "Ordenhadeira Móvel", "Trocou a Válvula de drenagem em Março de 2020", "Vaqueiros", 5999.49, 1, "01-07-2020"),
(02, "28-06-2016", "20 a 25 anos", "Ensiladeira En 6400 Nogueira", "Peças originais", "Tratadores", 7000.00, 0, "25-07-2020"),
(03, "01-12-2016", "20 a 25 anos", "Resfriador do leite 3070 lt", "Praticamente novo", "Vaqueiros", 30900.90, 0, "25-07-2020");

Insert Into fazendabd.muda (id, dataSemeadura, dataUltimaDesbrota, especie,
 formasDeIrrigacao, gema, identificacaoNominal, portaEnxerto, quantidadeMudas)
Values (01, "16-10-2016", "05-05-2017", "goiaba", "Pivot central", "Goiaba roxa", "Goiaba roxa", "Goiaba vermelha", 50),
(02, "16-10-2016", "05-05-2017", "goiaba", "Pivot central", "Goiaba branca", "Goiaba branca nacional", "Goiaba vermelha", 50),
(03, "05-01-2020", "12-02-2020", "abobora", "gotejamento", "Abobora Moranga", "Abobora Moranga  n3", "Abobora japonesa", 100);

Insert Into fazendabd.ordenha (id, dataOrdenha, horarioFinal, horarioIniciado,
 quantidadeLitros)
Values (01, "25-09-2020", "as 08:24", "as 08:00", 48.2),
(02, "25-09-2020", "as 08:41", "as 08:26", 30.0),
(03, "25-09-2020", "as 09:09", "as 08:41", 52.9),
(04, "26-09-2020", "as 08:29", "as 07:59", 60.1),
(05, "26-09-2020", "as 08:58", "as 08:30", 55.9),
(06, "26-09-2020", "as 09:15", "as 08:59", 33.0);

Insert Into fazendabd.plantio (id, caracteristicasPolinizacao, controlesDePragasUsado, dataAdubacao,
 dataColheita, dataPlantio, dataUltimoControlesDePragasUsado, detalhesAdubacao, estadoDaRotacao,
 quantidadeProduzida)
Values (01, "Natural com abelhas", "Apenas controle organico", "14-10-2017", "Todos os anos no mês de Setembro", "08-08-2017",
		"05-10-2019", "Uso de esterco e adubo quimico npk", "Inicial", 20000), -- goiaba roxa
(02, "Natural com abelhas", "Apenas controle organico", "21-10-2017", "Todos os anos no mês de Setembro", "15-08-2017",
		"08-10-2019", "Uso de esterco e adubo quimico npk", "Inicial", 15000), -- goiaba branca
(03, "Polinização quimica", "Eliminar fontes de inóculo como maxixe", "10-04-2020", "05-06-2020", "05-03-2020",
		"08-05-2020", "Uso de esterco e adubo quimico npk", "A terceira rotação, necessário girar cultura", 2500);

Insert Into fazendabd.produto (id, analiseQualidade, custo, dataFabricacao,
dataValidade, nome, preco, quantidadeEstoque, tipoDoProduto, origemAnimal)
Values (01, "Padrão A", 1.01, "05-06-2020", "05-09-2020", "Abobora Moranga  n3", 7.98, 2500, "Semi organico", 0),
(02, "Padrão A", 3.2, "10-09-2020", "10-11-2020", "Goiaba branca nacional", 7.50, 5000, "Semi organico", 0),
(03, "Padrão A", 3.8, "05-09-2020", "05-11-2020", "Goiaba roxa", 8.39, 7000, "Semi organico", 0);

Insert Into fazendabd.solo (id, analiseDoSolo, areaManejada, correcoesUsadas,
 identificacaoNominal, niveisDeCarbono, niveisDeNitrogenio, riscoErosoes, tipoDeSolo)
Values (01, "Solo em bom estado", 5.05,"Método da solução tampão SMP ", "Terrreno ao norte da sede", "Média radicular em 30 %",
"Média radicular em 20 %", "Sem riscos de erosões", "Solo em arido"),
(02, "Solo em correção", 3.04, "Método da saturação por bases", "Terreno do lago", "Média radicular em 5%",
"Média radicular em 2%", "Com riscos de erosões", "Solo seco"),
(03, "Solo estavel", 6.05, "Nenhuma", "Terreno abaixo do corrego", "Média radicular em 30 %",
"Média radicular em 40 %", "Sem riscos de erosões", "Solo umido");

Insert Into fazendabd.vacaleiteira (id, dataNascimento, identificacaoNominal, dataUltimaOrdenha,
 descricaoDeSaudeAnimal, estaInseminada, estimativaDeParto, numeroDePartos, origem, producaoTotal,
 raca, secagemEsperada, temperaturaDoLeite, tempoDeRuminacaoDia)
Values (01, "04-03-2014", "Mimosa", "25-09-2020", "Sem problema de saúde", 0, "Sem previsao", 3, "Filha da vaca rosinha", 2000,
"GirOlanda", "Janeiro de 2021", "35 graus celsius", "2 horas"),
(02, "03-05-2012", "Estrela", "25-09-2020", "Sem problema de saúde", 1, "Janeiro de 2021", 4, "Filha do boi meteoro", 3500,
"Gir", "Final de Outubro de 2020", "37 graus celsius", "2 horas e meia"),
(03, "09-10-2010", "Lua", "25-09-2020", "Perdeu um bezerro, e deu leite sem bezerro", 0, "Sem previsao", 6, "Filha da madona", 5000,
"Santa rosália", "Março de 2021", "38,5 graus celsius", "2 horas");

Insert Into fazendabd.varejista (id, dataUtimaCompra, detalhesCompra, endereco, nome)
Values (01, "10-06-2020", "Comprou as 2500 aboboras moranga n3", "Rua C, n32, Centro, BH", "Mercado organico"),
(02, "08-09-2020", "Comprou 4 mil Goiabas roxa", "Rua Joao Batista, n 57, Centro, Sete Lagoas", "Sacolão ABC"),
(03, "15-09-2020", "Comprou 2 mil Goiabas roxa e 3 mil Goiabas branca nacional", "Rua Teofilo Otoni, n130, Centro, Sete lagoas", "Super tudo");

Insert Into fazendabd.fazenda_solo (fazenda_id, solo_id)
Values (02, 02),
(01, 03),
(02, 01);

Insert Into fazendabd.funcionario_animaldoente (funcionario_id, animalDoente_id)
Values (01, 02),
(01, 03),
(01, 01);

Insert Into fazendabd.funcionario_equipamentoprotecao (funcionario_id, equipamentoProtecao_id)
Values (01, 02),
(02, 03),
(02, 01);

Insert Into fazendabd.funcionario_ferramenta (funcionario_id, ferramenta_id)
Values (02, 02),
(01, 03);

Insert Into fazendabd.funcionario_maquina (funcionario_id, maquina_id)
Values (01, 02),
(02, 03),
(02, 01);

Insert Into fazendabd.muda_funcionario (funcionario_id, muda_id)
Values (03, 02),
(03, 01),
(03, 03);

Insert Into fazendabd.ordenha_funcionario (funcionario_id, ordenha_id)
Values (02, 02),
(02, 03),
(02, 01);

Insert Into fazendabd.ordenha_maquina (maquina_id, ordenha_id)
Values (01, 02),
(01, 03),
(01, 01);

Insert Into fazendabd.ordenha_vacaleiteira (vacaLeiteira_id, ordenha_id)
Values (01, 02),
(02, 03),
(03, 01),
(01, 04),
(02, 05),
(03, 06);

Insert Into fazendabd.plantio_funcionario (funcionario_id, plantio_id)
Values (03, 02),
(03, 03),
(03, 01);

Insert Into fazendabd.plantio_muda (plantio_id, muda_id)
Values (01, 01),
(02, 02),
(03, 03);

Insert Into fazendabd.plantio_solo (solo_id, plantio_id)
Values (01, 02),
(02, 03);

-- precisa melhorar, tem erro na DDL
Insert Into fazendabd.varejista_fazenda (varejista_id, fazenda_id)
Values (01, 02),
(02, 01);

Insert Into fazendabd.varejista_produto (varejista_id, produto_id)
Values (01, 02),
(02, 03),
(03, 01);