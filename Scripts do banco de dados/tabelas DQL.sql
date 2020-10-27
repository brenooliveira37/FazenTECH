-- Consulta ao Banco de dados todos os animais doentes, que foram tratados, buscando assim informações do tratamento usado,
-- Especie do animal, início e fim do tratamento, além do responsável pelo tratamento.
SELECT adt.identificacaoNominal AS "Nome", adt.especie AS "Espécie", adt.diaInicioTratamento AS "Início do tratamento",
 adt.diaFinalDoTratamento AS "Final do tratamento", adt.tratamentoUsado AS "Tratamento usado", fun.nome AS "Responsável"
FROM fazendabd.animaldoente AS adt
INNER JOIN fazendabd.funcionario_animaldoente AS fadt ON adt.id = fadt.animalDoente_id
INNER JOIN fazendabd.funcionario AS fun ON fun.id = fadt.funcionario_id;

-- Informações do produto como nome, custo e preço de venda do mesmo, no-me dos varejistas que compraram esses produtos.
SELECT pro.nome AS "Produto", pro.custo AS "Custo unitário", pro.preco AS "Preço unitário", var.nome AS "Varejista",
var.dataUtimaCompra AS "Data da última compra", var.detalhesCompra "Detalhes da compra"
FROM fazendabd.produto AS pro
INNER JOIN fazendabd.varejista_produto AS vp ON vp.produto_id = pro.id
INNER JOIN fazendabd.varejista AS var ON var.id = vp.varejista_id;

-- Consulta ao banco informações das ordenhas e das vacas ordenhadas, além da máquina usada e funcionário que executou a ação
SELECT val.identificacaoNominal AS "Nome da Vaca", val.producaoTotal AS "Produção total de leite",
val.secagemEsperada AS "Secagem esperada", ord.dataOrdenha AS "Data", ord.horarioIniciado AS "Início da ordenha",
ord.horarioFinal AS "Término da ordenha", ord.quantidadeLitros AS "Quantidade de leite tirado", 
fun.nome AS "Funcionário ", maq.nome AS "Máquina Usada"
FROM fazendabd.vacaleiteira AS val
INNER JOIN fazendabd.ordenha_vacaleiteira AS ov ON ov.vacaLeiteira_id = val.id
INNER JOIN fazendabd.ordenha AS ord ON ord.id = ov.ordenha_id
INNER JOIN fazendabd.ordenha_maquina AS om ON om.ordenha_id = ord.id
INNER JOIN fazendabd.maquina AS maq ON maq.id = om.maquina_id
INNER JOIN fazendabd.ordenha_funcionario AS orf ON orf.ordenha_id = ord.id
INNER JOIN fazendabd.funcionario AS fun ON fun.id = orf.funcionario_id;

-- Consulta detalhes e datas do que foi feito e o quando foi feito nas plantações
SELECT faz.nome AS "Identificação da Fazenda", mud.identificacaoNominal AS "Plantação",
mud.quantidadeMudas AS "Quantidade de mudas plantadas", mud.formasDeIrrigacao AS "Formas de irrigação",
mud.dataSemeadura AS "Data da semeadura", mud.dataUltimaDesbrota AS "Data da última desbrota",
pla.dataPlantio AS "Data que plantou as mudas", pla.dataAdubacao AS "Data da adubação", 
pla.detalhesAdubacao AS "Detalhes da adubação", pla.dataColheita AS "Data da colheita",
pla.quantidadeProduzida AS "Quantidade da produção total"
FROM fazendabd.fazenda AS faz
INNER JOIN fazendabd.fazenda_solo AS fs ON fs.fazenda_id = faz.id
INNER JOIN fazendabd.solo AS sol ON sol.id = fs.solo_id
INNER JOIN fazendabd.plantio_solo AS ps ON ps.solo_id = sol.id
INNER JOIN fazendabd.plantio AS pla ON pla.id = ps.plantio_id
INNER JOIN fazendabd.plantio_muda AS pm ON pm.plantio_id = pla.id
INNER JOIN fazendabd.muda AS mud ON mud.id = pm.muda_id;

-- Consulta as plantações e traz os controles de pragas e sua data de uso
SELECT mud.identificacaoNominal AS "Plantação", pla.controlesDePragasUsado AS "Controles de pragas usado",
pla.dataUltimoControlesDePragasUsado AS "Data do último controle de praga"
FROM fazendabd.muda AS mud
INNER JOIN fazendabd.plantio_muda AS pl ON pl.muda_id = mud.id
INNER JOIN fazendabd.plantio AS pla ON pla.id = pl.plantio_id;