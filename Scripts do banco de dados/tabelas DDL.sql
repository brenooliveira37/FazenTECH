create database `fazendabd`;
-- drop database fazendabd;

CREATE TABLE `fazendabd`.`animaldoente` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `dataNascimento` varchar(255) DEFAULT NULL,
  `identificacaoNominal` varchar(255) DEFAULT NULL,
  `diaFinalDoTratamento` varchar(255) DEFAULT NULL,
  `diaInicioTratamento` varchar(255) DEFAULT NULL,
  `especie` varchar(255) DEFAULT NULL,
  `tratamentoUsado` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
CREATE TABLE `fazendabd`.`equipamentoprotecao` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `dataAquisicao` varchar(255) DEFAULT NULL,
  `durabilidadeEstimada` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `observacoes` varchar(255) DEFAULT NULL,
  `ultimoSetorUsar` varchar(255) DEFAULT NULL,
  `valorCompra` double NOT NULL,
  PRIMARY KEY (`id`)
);
CREATE TABLE `fazendabd`.`fazenda` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `areaReserva` double NOT NULL,
  `areaTotal` double NOT NULL,
  `localizacao` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `observacoes` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
CREATE TABLE `fazendabd`.`fazenda_solo` (
  `fazenda_id` bigint DEFAULT NULL,
  `solo_id` bigint NOT NULL,
  PRIMARY KEY (`solo_id`),
  KEY `FK_t2cya7ubad62u79oy1yrd7bm5` (`fazenda_id`),
  CONSTRAINT `FK_abvjdrv65b35sgmheelylkpjl` FOREIGN KEY (`solo_id`) REFERENCES `solo` (`id`),
  CONSTRAINT `FK_t2cya7ubad62u79oy1yrd7bm5` FOREIGN KEY (`fazenda_id`) REFERENCES `fazenda` (`id`)
);
CREATE TABLE `fazendabd`.`ferramenta` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `dataAquisicao` varchar(255) DEFAULT NULL,
  `durabilidadeEstimada` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `observacoes` varchar(255) DEFAULT NULL,
  `ultimoSetorUsar` varchar(255) DEFAULT NULL,
  `valorCompra` double NOT NULL,
  PRIMARY KEY (`id`)
);
CREATE TABLE `fazendabd`.`funcionario` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cpf` varchar(255) DEFAULT NULL,
  `dataNascimento` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `dataAdmissao` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  `ultimaFerias` varchar(255) DEFAULT NULL,
  `usuario` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
CREATE TABLE `fazendabd`.`funcionario_animaldoente` (
  `funcionario_id` bigint DEFAULT NULL,
  `animalDoente_id` bigint NOT NULL,
  PRIMARY KEY (`animalDoente_id`),
  KEY `FK_apobcxlabfr5kmpj2nt6fu8g5` (`funcionario_id`),
  CONSTRAINT `FK_551uohiwutw2tmqq8lrq6p1tp` FOREIGN KEY (`animalDoente_id`) REFERENCES `animaldoente` (`id`),
  CONSTRAINT `FK_apobcxlabfr5kmpj2nt6fu8g5` FOREIGN KEY (`funcionario_id`) REFERENCES `funcionario` (`id`)
);
CREATE TABLE `fazendabd`.`funcionario_equipamentoprotecao` (
  `funcionario_id` bigint DEFAULT NULL,
  `equipamentoProtecao_id` bigint NOT NULL,
  PRIMARY KEY (`equipamentoProtecao_id`),
  KEY `FK_6big94crjgou3uuvd1mmvpw7u` (`funcionario_id`),
  CONSTRAINT `FK_5w5qwm4x3vrcuv6ir4vcbcfrk` FOREIGN KEY (`equipamentoProtecao_id`) REFERENCES `equipamentoprotecao` (`id`),
  CONSTRAINT `FK_6big94crjgou3uuvd1mmvpw7u` FOREIGN KEY (`funcionario_id`) REFERENCES `funcionario` (`id`)
);
CREATE TABLE `fazendabd`.`funcionario_ferramenta` (
  `funcionario_id` bigint DEFAULT NULL,
  `ferramenta_id` bigint NOT NULL,
  PRIMARY KEY (`ferramenta_id`),
  KEY `FK_bgpvd22kviyvkxocyyjatydpw` (`funcionario_id`),
  CONSTRAINT `FK_bgpvd22kviyvkxocyyjatydpw` FOREIGN KEY (`funcionario_id`) REFERENCES `funcionario` (`id`),
  CONSTRAINT `FK_g25fmxlqginfl9giqb02wwmo6` FOREIGN KEY (`ferramenta_id`) REFERENCES `ferramenta` (`id`)
);
CREATE TABLE `fazendabd`.`funcionario_maquina` (
  `funcionario_id` bigint DEFAULT NULL,
  `maquina_id` bigint NOT NULL,
  PRIMARY KEY (`maquina_id`),
  KEY `FK_g4nynq7l0464m9sf0br88xahj` (`funcionario_id`),
  CONSTRAINT `FK_a6wfbncv3fcmxkjgm2p9w840v` FOREIGN KEY (`maquina_id`) REFERENCES `maquina` (`id`),
  CONSTRAINT `FK_g4nynq7l0464m9sf0br88xahj` FOREIGN KEY (`funcionario_id`) REFERENCES `funcionario` (`id`)
);
CREATE TABLE `fazendabd`.`maquina` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `dataAquisicao` varchar(255) DEFAULT NULL,
  `durabilidadeEstimada` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `observacoes` varchar(255) DEFAULT NULL,
  `ultimoSetorUsar` varchar(255) DEFAULT NULL,
  `valorCompra` double NOT NULL,
  `teveManutencao` bit(1) NOT NULL,
  `ultimaRevisao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
CREATE TABLE `fazendabd`.`muda` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `dataSemeadura` varchar(255) DEFAULT NULL,
  `dataUltimaDesbrota` varchar(255) DEFAULT NULL,
  `especie` varchar(255) DEFAULT NULL,
  `formasDeIrrigacao` varchar(255) DEFAULT NULL,
  `gema` varchar(255) DEFAULT NULL,
  `identificacaoNominal` varchar(255) DEFAULT NULL,
  `portaEnxerto` varchar(255) DEFAULT NULL,
  `quantidadeMudas` int NOT NULL,
  PRIMARY KEY (`id`)
);
CREATE TABLE `fazendabd`.`muda_funcionario` (
  `funcionario_id` bigint DEFAULT NULL,
  `muda_id` bigint NOT NULL,
  PRIMARY KEY (`muda_id`),
  KEY `FK_9dh4gtt6axxqvq1iau331sg83` (`funcionario_id`),
  CONSTRAINT `FK_9dh4gtt6axxqvq1iau331sg83` FOREIGN KEY (`funcionario_id`) REFERENCES `funcionario` (`id`),
  CONSTRAINT `FK_efr95mqb4ugddc5mykdh2uuy3` FOREIGN KEY (`muda_id`) REFERENCES `muda` (`id`)
);
CREATE TABLE `fazendabd`.`ordenha` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `dataOrdenha` varchar(255) DEFAULT NULL,
  `horarioFinal` varchar(255) DEFAULT NULL,
  `horarioIniciado` varchar(255) DEFAULT NULL,
  `quantidadeLitros` double NOT NULL,
  PRIMARY KEY (`id`)
);
CREATE TABLE `fazendabd`.`ordenha_funcionario` (
  `funcionario_id` bigint DEFAULT NULL,
  `ordenha_id` bigint NOT NULL,
  PRIMARY KEY (`ordenha_id`),
  KEY `FK_13glo75k3gf297o193kbqsbdv` (`funcionario_id`),
  CONSTRAINT `FK_13glo75k3gf297o193kbqsbdv` FOREIGN KEY (`funcionario_id`) REFERENCES `funcionario` (`id`),
  CONSTRAINT `FK_k1pqsrartnc85t5l64eiibrp` FOREIGN KEY (`ordenha_id`) REFERENCES `ordenha` (`id`)
);
CREATE TABLE `fazendabd`.`ordenha_maquina` (
  `maquina_id` bigint DEFAULT NULL,
  `ordenha_id` bigint NOT NULL,
  PRIMARY KEY (`ordenha_id`),
  KEY `FK_iw9kyimg7fd6vtgcg22t5cxoy` (`maquina_id`),
  CONSTRAINT `FK_iephexny6wpa5sjn2qtk25ea4` FOREIGN KEY (`ordenha_id`) REFERENCES `ordenha` (`id`),
  CONSTRAINT `FK_iw9kyimg7fd6vtgcg22t5cxoy` FOREIGN KEY (`maquina_id`) REFERENCES `maquina` (`id`)
);
CREATE TABLE `fazendabd`.`ordenha_vacaleiteira` (
  `vacaLeiteira_id` bigint DEFAULT NULL,
  `ordenha_id` bigint NOT NULL,
  PRIMARY KEY (`ordenha_id`),
  KEY `FK_827hr0167l8p3qdsho68ekveg` (`vacaLeiteira_id`),
  CONSTRAINT `FK_827hr0167l8p3qdsho68ekveg` FOREIGN KEY (`vacaLeiteira_id`) REFERENCES `vacaleiteira` (`id`),
  CONSTRAINT `FK_fk7f39i351i5aurl65y00yli4` FOREIGN KEY (`ordenha_id`) REFERENCES `ordenha` (`id`)
);
CREATE TABLE `fazendabd`.`plantio` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `caracteristicasPolinizacao` varchar(255) DEFAULT NULL,
  `controlesDePragasUsado` varchar(255) DEFAULT NULL,
  `dataAdubacao` varchar(255) DEFAULT NULL,
  `dataColheita` varchar(255) DEFAULT NULL,
  `dataPlantio` varchar(255) DEFAULT NULL,
  `dataUltimoControlesDePragasUsado` varchar(255) DEFAULT NULL,
  `detalhesAdubacao` varchar(255) DEFAULT NULL,
  `estadoDaRotacao` varchar(255) DEFAULT NULL,
  `quantidadeProduzida` double NOT NULL,
  PRIMARY KEY (`id`)
);
CREATE TABLE `fazendabd`.`plantio_funcionario` (
  `funcionario_id` bigint DEFAULT NULL,
  `plantio_id` bigint NOT NULL,
  PRIMARY KEY (`plantio_id`),
  KEY `FK_ebjc305d7wejoo8nlkdia9xey` (`funcionario_id`),
  CONSTRAINT `FK_ebjc305d7wejoo8nlkdia9xey` FOREIGN KEY (`funcionario_id`) REFERENCES `funcionario` (`id`),
  CONSTRAINT `FK_t0vf1xlt6aomyl3dbag43s5y4` FOREIGN KEY (`plantio_id`) REFERENCES `plantio` (`id`)
);
CREATE TABLE `fazendabd`.`plantio_muda` (
  `plantio_id` bigint NOT NULL,
  `muda_id` bigint DEFAULT NULL,
  PRIMARY KEY (`plantio_id`),
  KEY `FK_f3wec2rdenv69hsjhpk8tkswd` (`muda_id`),
  CONSTRAINT `FK_44t4dwmt8jdkjnhuyl52kh2o8` FOREIGN KEY (`plantio_id`) REFERENCES `plantio` (`id`),
  CONSTRAINT `FK_f3wec2rdenv69hsjhpk8tkswd` FOREIGN KEY (`muda_id`) REFERENCES `muda` (`id`)
);
CREATE TABLE `fazendabd`.`plantio_solo` (
  `solo_id` bigint NOT NULL,
  `plantio_id` bigint NOT NULL,
  UNIQUE KEY `UK_6jnc3m46685mpchgjc12j5foj` (`plantio_id`),
  UNIQUE KEY `UK_huuqv136ph59oamcod21uwnli` (`solo_id`),
  CONSTRAINT `FK_6jnc3m46685mpchgjc12j5foj` FOREIGN KEY (`plantio_id`) REFERENCES `plantio` (`id`),
  CONSTRAINT `FK_huuqv136ph59oamcod21uwnli` FOREIGN KEY (`solo_id`) REFERENCES `solo` (`id`)
);
CREATE TABLE `fazendabd`.`produto` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `analiseQualidade` varchar(255) DEFAULT NULL,
  `custo` double NOT NULL,
  `dataFabricacao` varchar(255) DEFAULT NULL,
  `dataValidade` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `preco` double NOT NULL,
  `quantidadeEstoque` double NOT NULL,
  `tipoDoProduto` varchar(255) DEFAULT NULL,
  `origemAnimal` bit(1) NOT NULL,
  PRIMARY KEY (`id`)
);
CREATE TABLE `fazendabd`.`solo` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `analiseDoSolo` varchar(255) DEFAULT NULL,
  `areaManejada` double NOT NULL,
  `correcoesUsadas` varchar(255) DEFAULT NULL,
  `identificacaoNominal` varchar(255) DEFAULT NULL,
  `niveisDeCarbono` varchar(255) DEFAULT NULL,
  `niveisDeNitrogenio` varchar(255) DEFAULT NULL,
  `riscoErosoes` varchar(255) DEFAULT NULL,
  `tipoDeSolo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
CREATE TABLE `fazendabd`.`vacaleiteira` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `dataNascimento` varchar(255) DEFAULT NULL,
  `identificacaoNominal` varchar(255) DEFAULT NULL,
  `dataUltimaOrdenha` varchar(255) DEFAULT NULL,
  `descricaoDeSaudeAnimal` varchar(255) DEFAULT NULL,
  `estaInseminada` bit(1) NOT NULL,
  `estimativaDeParto` varchar(255) DEFAULT NULL,
  `numeroDePartos` int NOT NULL,
  `origem` varchar(255) DEFAULT NULL,
  `producaoTotal` double NOT NULL,
  `raca` varchar(255) DEFAULT NULL,
  `secagemEsperada` varchar(255) DEFAULT NULL,
  `temperaturaDoLeite` varchar(255) DEFAULT NULL,
  `tempoDeRuminacaoDia` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
CREATE TABLE `fazendabd`.`varejista` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `dataUtimaCompra` varchar(255) DEFAULT NULL,
  `detalhesCompra` varchar(255) DEFAULT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
CREATE TABLE `fazendabd`.`varejista_fazenda` (
  `varejista_id` bigint NOT NULL,
  `fazenda_id` bigint NOT NULL,
  UNIQUE KEY `UK_j7ysxsgp2mgt6efb9qty44wbt` (`fazenda_id`),
  UNIQUE KEY `UK_cv5jjiou2rrq7qxvs5wc9akx4` (`varejista_id`),
  CONSTRAINT `FK_cv5jjiou2rrq7qxvs5wc9akx4` FOREIGN KEY (`varejista_id`) REFERENCES `varejista` (`id`),
  CONSTRAINT `FK_j7ysxsgp2mgt6efb9qty44wbt` FOREIGN KEY (`fazenda_id`) REFERENCES `fazenda` (`id`)
);
CREATE TABLE `fazendabd`.`varejista_produto` (
  `produto_id` bigint NOT NULL,
  `varejista_id` bigint NOT NULL,
  UNIQUE KEY `UK_7eskx1kc2ot60sdqrxcmggtq2` (`varejista_id`),
  UNIQUE KEY `UK_7mh4e2qatco3woufv5sjh1d4e` (`produto_id`),
  CONSTRAINT `FK_7eskx1kc2ot60sdqrxcmggtq2` FOREIGN KEY (`varejista_id`) REFERENCES `varejista` (`id`),
  CONSTRAINT `FK_7mh4e2qatco3woufv5sjh1d4e` FOREIGN KEY (`produto_id`) REFERENCES `produto` (`id`)
);