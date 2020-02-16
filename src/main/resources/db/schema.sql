CREATE TABLE `category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(100) NOT NULL,
  `version` bigint(20) NOT NULL,
  `created_by` varchar(70) NOT NULL,
  `created_date` datetime NOT NULL,
  `modified_by` varchar(70) DEFAULT NULL,
  `last_modified_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
)


CREATE TABLE `language` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(100) NOT NULL,
  `version` bigint(20) NOT NULL,
  `created_by` varchar(70) NOT NULL,
  `created_date` datetime NOT NULL,
  `modified_by` varchar(70) DEFAULT NULL,
  `last_modified_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
)

CREATE TABLE `profile` (
  `id` varchar(100) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `premium` bit(1) NOT NULL,
  `version` bigint(20) NOT NULL,
  `created_by` varchar(70) NOT NULL,
  `created_date` datetime NOT NULL,
  `modified_by` varchar(70) DEFAULT NULL,
  `last_modified_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
)

CREATE TABLE `profile_category` (
  `profile_id` varchar(100) NOT NULL,
  `category_id` bigint(20) NOT NULL,
  PRIMARY KEY (`profile_id`,`category_id`),
  KEY `FKp505r77qrj3ys18x8l07xdfiq` (`category_id`),
  CONSTRAINT `FKp505r77qrj3ys18x8l07xdfiq` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `FKpmkun2dpjjicch3j12npnro1r` FOREIGN KEY (`profile_id`) REFERENCES `profile` (`id`)
)

CREATE TABLE `profile_language` (
  `profile_id` varchar(100) NOT NULL,
  `language_id` bigint(20) NOT NULL,
  PRIMARY KEY (`profile_id`,`language_id`),
  KEY `FK7gbcllyqhfnxxe5je35d8m5ds` (`language_id`),
  CONSTRAINT `FK7gbcllyqhfnxxe5je35d8m5ds` FOREIGN KEY (`language_id`) REFERENCES `language` (`id`),
  CONSTRAINT `FKnrnmoxy65kjfb03o7yq2u4875` FOREIGN KEY (`profile_id`) REFERENCES `profile` (`id`)
)

CREATE TABLE `meme` (
  `id` varchar(100) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  `image_url` longtext NOT NULL,
  `likes` int(11) DEFAULT 0,
  `dislikes` int(11) DEFAULT 0,
  `score` int(11) DEFAULT 0,
  `total_votes` int(11) DEFAULT 0,
  `language_id` bigint(20) NOT NULL,
  `profile_id` varchar(100) NOT NULL,
  `version` bigint(20) NOT NULL,
  `created_by` varchar(70) NOT NULL,
  `created_date` datetime NOT NULL,
  `modified_by` varchar(70) DEFAULT NULL,
  `last_modified_date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKc2iuvosq93ctmjhh003eqown7` (`language_id`),
  KEY `FKcvlemucsn11m72gpjs5kdqwpk` (`profile_id`),
  CONSTRAINT `FKc2iuvosq93ctmjhh003eqown7` FOREIGN KEY (`language_id`) REFERENCES `language` (`id`),
  CONSTRAINT `FKcvlemucsn11m72gpjs5kdqwpk` FOREIGN KEY (`profile_id`) REFERENCES `profile` (`id`)
)

CREATE TABLE `profile_view` (
  `id` varchar(100) NOT NULL,
  `like` bit(1) NOT NULL,
  `meme_fk` varchar(100) NOT NULL,
  `profile_fk` varchar(100) NOT NULL,
  `version` bigint(20) NOT NULL,
  `created_by` varchar(70) NOT NULL,
  `created_date` datetime NOT NULL,
  `modified_by` varchar(70) DEFAULT NULL,
  `last_modified_date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKj82gnl32sfee6v5079gciwhds` (`meme_fk`),
  KEY `FKr55rhy6vnslhwanwkdbku121c` (`profile_fk`),
  CONSTRAINT `FKj82gnl32sfee6v5079gciwhds` FOREIGN KEY (`meme_fk`) REFERENCES `meme` (`id`),
  CONSTRAINT `FKr55rhy6vnslhwanwkdbku121c` FOREIGN KEY (`profile_fk`) REFERENCES `profile` (`id`)
)


CREATE TABLE `meme_category` (
  `meme_id` varchar(100) NOT NULL,
  `category_id` bigint(20) NOT NULL,
  PRIMARY KEY (`meme_id`,`category_id`),
  KEY `FK1l0g92s907e810fjmcs9hckk7` (`category_id`),
  CONSTRAINT `FK1l0g92s907e810fjmcs9hckk7` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `FK32f093f9h8d2g7ertku7g29gn` FOREIGN KEY (`meme_id`) REFERENCES `meme` (`id`)
)


CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) NOT NULL,
  `image_url` longtext DEFAULT NULL,
  `name` varchar(100) NOT NULL,
  `provider` varchar(100) NOT NULL,
  `provider_id` varchar(100) DEFAULT NULL,
  `token` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK6dotkott2kjsp8vw4d0m25fb7` (`email`)
)
