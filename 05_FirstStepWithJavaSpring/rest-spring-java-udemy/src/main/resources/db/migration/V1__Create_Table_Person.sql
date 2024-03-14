
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(80) NOT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `person` VALUES ('1','Daniel','Martins','R josé constantino dos santos', 'Male');
INSERT INTO `person` VALUES ('2','Daniel','Martins', 'R Pres Café Filho 01', 'Female');
INSERT INTO `person` VALUES ('3','Eva', 'Martins', 'R José Constantino dos Santos 79', 'Female');
