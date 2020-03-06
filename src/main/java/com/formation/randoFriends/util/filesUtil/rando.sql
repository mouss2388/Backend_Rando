-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  ven. 06 mars 2020 à 17:12
-- Version du serveur :  10.3.16-MariaDB
-- Version de PHP :  7.3.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `rando`
--

-- --------------------------------------------------------

--
-- Structure de la table `image`
--

CREATE TABLE `image` (
  `id` int(11) NOT NULL,
  `content_type` varchar(255) DEFAULT NULL,
  `file_name` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `storage_id` varchar(255) DEFAULT NULL,
  `thumb_storage_id` varchar(255) DEFAULT NULL,
  `trek_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `image`
--

INSERT INTO `image` (`id`, `content_type`, `file_name`, `nom`, `storage_id`, `thumb_storage_id`, `trek_id`) VALUES
(1, 'image/jpeg', 'Tour-Eiffel-Trocadero-630x405-C-Thinkstock.jpg', 'Tour-Eiffel-Trocadero-630x405-C-Thinkstock.jpg', 'ec9060c4b0aaca251e4da162e838bf1e73504f67', '8d56c43ae023d1f119dde33c617de966f0632ccf', 1);

-- --------------------------------------------------------

--
-- Structure de la table `locations`
--

CREATE TABLE `locations` (
  `id` int(11) NOT NULL,
  `centre_geo` geometry DEFAULT NULL,
  `locations_order` int(11) NOT NULL,
  `route_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `locations`
--

INSERT INTO `locations` (`id`, `centre_geo`, `locations_order`, `route_id`) VALUES
(1, 0x000000000102000000020000000000000000000040000000000000f03f00000000000018400000000000001840, 0, 1);

-- --------------------------------------------------------

--
-- Structure de la table `route`
--

CREATE TABLE `route` (
  `id` int(11) NOT NULL,
  `date_de_creation` datetime DEFAULT NULL,
  `date_modification` datetime DEFAULT NULL,
  `nom_createur` varchar(255) DEFAULT NULL,
  `image_id` int(11) DEFAULT NULL,
  `trek_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `route`
--

INSERT INTO `route` (`id`, `date_de_creation`, `date_modification`, `nom_createur`, `image_id`, `trek_id`) VALUES
(1, '2020-03-06 00:00:00', '2020-04-11 00:00:00', 'JP', 1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `treks`
--

CREATE TABLE `treks` (
  `id` int(11) NOT NULL,
  `date_de_creation` datetime DEFAULT NULL,
  `date_deroulement` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `organisateur` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `treks`
--

INSERT INTO `treks` (`id`, `date_de_creation`, `date_deroulement`, `description`, `nom`, `organisateur`) VALUES
(1, '2020-03-06 00:00:00', '2020-03-27 00:00:00', 'rando to paris', 'easy paris', 'mouss');

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `birthday` datetime DEFAULT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `image`
--
ALTER TABLE `image`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKmjx63hjii4yokodsgxkse9krt` (`trek_id`);

--
-- Index pour la table `locations`
--
ALTER TABLE `locations`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKjknefc3krohl91imy7yed71m4` (`route_id`);

--
-- Index pour la table `route`
--
ALTER TABLE `route`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKncsy7tp1fdqklw22jd8drkx9u` (`image_id`),
  ADD KEY `FKr2udhcxi1gbw4a1eumxk8haum` (`trek_id`);

--
-- Index pour la table `treks`
--
ALTER TABLE `treks`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `image`
--
ALTER TABLE `image`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `locations`
--
ALTER TABLE `locations`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `route`
--
ALTER TABLE `route`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `treks`
--
ALTER TABLE `treks`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `image`
--
ALTER TABLE `image`
  ADD CONSTRAINT `FKmjx63hjii4yokodsgxkse9krt` FOREIGN KEY (`trek_id`) REFERENCES `treks` (`id`);

--
-- Contraintes pour la table `locations`
--
ALTER TABLE `locations`
  ADD CONSTRAINT `FKjknefc3krohl91imy7yed71m4` FOREIGN KEY (`route_id`) REFERENCES `route` (`id`);

--
-- Contraintes pour la table `route`
--
ALTER TABLE `route`
  ADD CONSTRAINT `FKncsy7tp1fdqklw22jd8drkx9u` FOREIGN KEY (`image_id`) REFERENCES `image` (`id`),
  ADD CONSTRAINT `FKr2udhcxi1gbw4a1eumxk8haum` FOREIGN KEY (`trek_id`) REFERENCES `treks` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
