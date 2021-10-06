-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 06-Out-2021 às 02:24
-- Versão do servidor: 10.4.18-MariaDB
-- versão do PHP: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `estoquemercadinho`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `cor`
--

CREATE TABLE `cor` (
  `idCor` int(11) NOT NULL,
  `corProduto` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `cor`
--

INSERT INTO `cor` (`idCor`, `corProduto`) VALUES
(1, 'Vermelho'),
(2, 'Azul');

-- --------------------------------------------------------

--
-- Estrutura da tabela `historico`
--

CREATE TABLE `historico` (
  `idHistorico` int(11) NOT NULL,
  `idProduto` int(11) NOT NULL,
  `idOperacao` int(11) NOT NULL,
  `quantidade` int(11) NOT NULL,
  `Data` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `historico`
--

INSERT INTO `historico` (`idHistorico`, `idProduto`, `idOperacao`, `quantidade`, `Data`) VALUES
(14, 43, 1, 5, '2021-09-09'),
(15, 48, 1, 5, '2021-09-09'),
(16, 43, 2, 3, '2021-09-09'),
(17, 46, 1, 10, '2021-09-09'),
(18, 53, 1, 10, '2021-09-09'),
(19, 53, 2, 5, '2021-09-09'),
(20, 46, 2, 6, '2021-09-09'),
(21, 48, 2, 1, '2021-09-09'),
(22, 47, 1, 15, '2021-09-09'),
(23, 47, 2, 9, '2021-09-09'),
(24, 51, 1, 25, '2021-09-09'),
(25, 51, 2, 10, '2021-09-09'),
(26, 53, 1, 10, '2021-09-09'),
(27, 49, 2, 2, '2021-09-09'),
(28, 49, 1, 3, '2021-09-09'),
(29, 54, 1, 5, '2021-09-27'),
(30, 54, 2, 10, '2021-10-05'),
(31, 54, 1, 10, '2021-10-05');

-- --------------------------------------------------------

--
-- Estrutura da tabela `marca`
--

CREATE TABLE `marca` (
  `idMarca` int(11) NOT NULL,
  `marcaProduto` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `marca`
--

INSERT INTO `marca` (`idMarca`, `marcaProduto`) VALUES
(1, 'Nestle'),
(2, 'P&G');

-- --------------------------------------------------------

--
-- Estrutura da tabela `operacao`
--

CREATE TABLE `operacao` (
  `idOperacao` int(11) NOT NULL,
  `descricaoOperacao` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `operacao`
--

INSERT INTO `operacao` (`idOperacao`, `descricaoOperacao`) VALUES
(1, 'Entrada'),
(2, 'Saida');

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE `produto` (
  `idProduto` int(11) NOT NULL,
  `codigoProduto` int(50) NOT NULL,
  `descricaoProduto` varchar(100) NOT NULL,
  `idMarca` int(11) NOT NULL,
  `idCor` int(11) NOT NULL,
  `precoUnitProduto` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `produto`
--

INSERT INTO `produto` (`idProduto`, `codigoProduto`, `descricaoProduto`, `idMarca`, `idCor`, `precoUnitProduto`) VALUES
(43, 568754432, 'Bolacha', 1, 1, 3),
(46, 123456789, 'Tipe', 2, 2, 5),
(47, 1122334455, 'KitKat', 1, 1, 3),
(48, 123456789, 'Biscoito', 1, 1, 5),
(49, 332255667, 'Bounty', 2, 2, 10),
(51, 987654321, 'Ninho', 1, 1, 4),
(53, 123456789, 'Classic', 1, 1, 3),
(54, 123456789, 'Test', 1, 2, 12);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `cor`
--
ALTER TABLE `cor`
  ADD PRIMARY KEY (`idCor`);

--
-- Índices para tabela `historico`
--
ALTER TABLE `historico`
  ADD PRIMARY KEY (`idHistorico`),
  ADD KEY `fk_historico_operacao` (`idOperacao`);

--
-- Índices para tabela `marca`
--
ALTER TABLE `marca`
  ADD PRIMARY KEY (`idMarca`);

--
-- Índices para tabela `operacao`
--
ALTER TABLE `operacao`
  ADD PRIMARY KEY (`idOperacao`);

--
-- Índices para tabela `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`idProduto`),
  ADD KEY `fk_produto_cor` (`idCor`),
  ADD KEY `fk_produto_marca` (`idMarca`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `cor`
--
ALTER TABLE `cor`
  MODIFY `idCor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `historico`
--
ALTER TABLE `historico`
  MODIFY `idHistorico` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT de tabela `marca`
--
ALTER TABLE `marca`
  MODIFY `idMarca` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `operacao`
--
ALTER TABLE `operacao`
  MODIFY `idOperacao` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `produto`
--
ALTER TABLE `produto`
  MODIFY `idProduto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=55;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `historico`
--
ALTER TABLE `historico`
  ADD CONSTRAINT `fk_historico_operacao` FOREIGN KEY (`idOperacao`) REFERENCES `operacao` (`idOperacao`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `produto`
--
ALTER TABLE `produto`
  ADD CONSTRAINT `fk_produto_cor` FOREIGN KEY (`idCor`) REFERENCES `cor` (`idCor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_produto_marca` FOREIGN KEY (`idMarca`) REFERENCES `marca` (`idMarca`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
