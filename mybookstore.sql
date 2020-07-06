/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : mybookstore

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2020-07-06 08:51:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for books
-- ----------------------------
DROP TABLE IF EXISTS `books`;
CREATE TABLE `books` (
  `bookid` int(11) NOT NULL AUTO_INCREMENT,
  `isbn` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `typeid` int(11) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `description` varchar(2000) DEFAULT NULL,
  `inventory` int(11) DEFAULT NULL,
  `cover` varchar(255) DEFAULT NULL,
  `sale` int(11) DEFAULT '1',
  PRIMARY KEY (`bookid`),
  KEY `FKjvia33970wcmivpellhi3i4l6` (`typeid`),
  CONSTRAINT `FKjvia33970wcmivpellhi3i4l6` FOREIGN KEY (`typeid`) REFERENCES `types` (`typeid`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of books
-- ----------------------------
INSERT INTO `books` VALUES ('1', '1', 'Java核心技术卷', '1', '凯S.霍斯特曼', '95.20', '本书是Java领域有影响力和价值的著作之一，由拥有20多年教学与研究经验的Java技术专家撰写（获Jolt大奖），与《Java编程思想》齐名，10余年全球畅销不衰，广受好评。第10版根据JavaSE8全面更新!', '970', 'http://img3m9.ddimg.cn/12/36/1546133799-1_w_1.jpg', '1');
INSERT INTO `books` VALUES ('2', '2', '深入理解计算机系统', '1', '兰德尔·E·布莱恩特', '136.90', '程序员必读经典著作！理解计算机系统*书目，10万程序员共同选择。第二版销售突破100000册，第三版重磅上市！', '1176', 'http://img3m7.ddimg.cn/48/0/24106647-1_w_6.jpg', '1');
INSERT INTO `books` VALUES ('3', '3', 'Effective C++', '1', '梅耶', '51.30', '大师名著纵横二十载，稳居任一荐书单三甲；称职程序员傍身绝学，通向C++精微奥妙之门。', '995', 'http://img3m6.ddimg.cn/96/25/21000966-1_u_12.jpg', '1');
INSERT INTO `books` VALUES ('4', '4', '小王子', '2', '圣-埃克苏佩里', '8.89', '豆瓣9.7高分推荐！旅法翻译家梅子涵之女梅思繁法文直译，舒朗大开本，央美教授高精度还原原作插画。首次收录全球舞台剧、音乐会、电影、动画片等对《小王子》的精彩诠释，通晓名作的前世今生。', '990', 'http://img3m9.ddimg.cn/75/6/25067469-1_u_2.jpg', '1');
INSERT INTO `books` VALUES ('5', '5', 'Java编程思想', '1', 'Bruce Eckel', '91.20', 'Java学习必读经典,殿堂级著作！赢得了全球程序员的广泛赞誉。', '9958', 'http://img3m0.ddimg.cn/4/24/9317290-1_w_5.jpg', '1');
INSERT INTO `books` VALUES ('6', '6', '魔兽世界编年史套装', '3', '克里斯˙梅森', '449.20', '暴雪官方历时二十年编纂而成的史料！三卷《魔兽世界编年史》将呈现大量从未公布的精美原画和插图，读者在阅读故事之余，更能享受一次视觉上的饕餮盛宴，是魔兽粉丝收藏的优选。', '118', 'http://img3m7.ddimg.cn/43/9/25352557-1_w_3.jpg', '1');
INSERT INTO `books` VALUES ('7', '7', '三体：全三册', '4', '刘慈欣', '50.20', '刘慈欣代表作，亚洲首部“雨果奖”获奖作品！', '14412', 'http://img3m4.ddimg.cn/32/35/23579654-1_u_3.jpg', '1');
INSERT INTO `books` VALUES ('8', '8', '悲惨世界', '5', '雨果', '104.00', '《悲惨世界》是雨果在流亡期间写的长篇小说，是他的代表作，也是世界文学宝库的珍品之一。\r\n    《悲惨世界》通过冉阿让等人的悲惨遭遇以及冉阿让被卞福汝主教感化后一系列令人感动的事迹，深刻揭露和批判了19世纪法国封建专制社会的腐朽本质及其罪恶现象，对穷苦人民在封建重压下所遭受的剥削欺诈和残酷迫害表示了悲悯和同情。', '387', 'http://img3m7.ddimg.cn/13/15/27912667-1_u_1.jpg', '1');
INSERT INTO `books` VALUES ('9', '9', '动物农场', '6', '乔治·奥威尔', '20.40', '也译“动物庄园”，是“一代人的冷峻良知”乔治·奥威尔经典的讽喻之作。虽然这一场荒诞的动物革命走向歧途，但正是因为这样我们才了解“把权力关进制度的笼子”的重要性。', '123', 'http://img3m1.ddimg.cn/82/3/25229341-1_w_2.jpg', '1');
INSERT INTO `books` VALUES ('10', '10', '机器学习', '1', '周志华', '61.60', '击败AlphaGo的武林秘籍，赢得人机大战的必由之路：人工智能大牛周志华教授巨著，全面揭开机器学习的奥秘。', '2525', 'http://img3m0.ddimg.cn/20/24/23898620-1_w_3.jpg', '0');
INSERT INTO `books` VALUES ('11', '11', '纳尼亚传奇', '3', '刘易斯', '86.20', '刘易斯基金会独家授权插图！翻译家吴岩，陈良廷，刘文澜经典译本！', '123', 'http://img3m7.ddimg.cn/1/32/22474387-1_u_2.jpg', '1');
INSERT INTO `books` VALUES ('12', '12', '老人与海', '5', '海明威', '27.80', '收录诺贝尔文学奖获奖作品《老人与海》《乞力马扎罗的雪》，深深影响了马尔克斯、塞林格等文学家的创作理念。', '2414', 'http://img3m6.ddimg.cn/94/11/27891166-1_u_2.jpg', '1');
INSERT INTO `books` VALUES ('13', '13', '魔力的胎动', '7', '东野圭吾', '35.90', '喜欢《解忧杂货店》，就一定要读这本书。珍藏印签。有了想要守护的东西，生命就会变得有力量。悲凉的人生、千疮百孔的命运、一桩桩悲剧的发生与救赎，读来令人喟叹不已。', '1232', 'http://img3m4.ddimg.cn/68/35/28484744-2_u_6.jpg', '1');
INSERT INTO `books` VALUES ('14', '14', '我不怕这漫长黑夜', '8', '苑子豪', '37.50', '七篇寻光故事，七种奇遇人生，送给成长路上孤独前行的你，每个人的生活都有被困在井里一样的绝望时刻，而这本书就想做点亮黑夜的那束光芒。耐心一些，保持相信，我们终会穿越漫长黑夜，抵达属于自己的黎明。', '1142', 'http://img3m0.ddimg.cn/9/18/28486170-1_u_8.jpg', '1');
INSERT INTO `books` VALUES ('15', '15', '永久记录', '9', '爱德华·斯诺登', '56.70', '美国政府不想让全世界读到这本书，欧美上市当日作者便被美国司法部起诉！“棱镜门”主角爱德华·斯诺登首次亲自披露美国政府滥用NSA系统监控世界的真相，袒露从“爱国者”到“叛国者”的心路历程。', '124', 'http://img3m5.ddimg.cn/86/22/28475555-2_u_9.jpg', '1');
INSERT INTO `books` VALUES ('16', '16', '探索月球', '2', '安妮·詹克利奥维奇', '133.20', '嫦娥五号探测器系统副总设计师彭兢诚意推荐！纪念人类登月50周年，五大精妙立体机关直观呈现月球的运行轨迹，全方位揭秘人类探月登月的过程，普及基本的航天知识，与孩子一起解读月球的奥秘，种下探索宇宙的种子。', '1516', 'http://img3m4.ddimg.cn/13/30/28481224-1_w_3.jpg', '1');
INSERT INTO `books` VALUES ('18', '18', '红楼梦', '5', '曹雪芹', '18.80', '中国古典小说佳作，影响整个华人世界的经典！轻松易学、国家教育部推荐读物！', '2441', 'http://img3m6.ddimg.cn/31/22/23828836-1_w_8.jpg', '1');
INSERT INTO `books` VALUES ('19', '19', '草房子', '2', '曹文轩', '22.50', '人民文学出版社天天出版社出品，经典作品，教师推荐，已有超过150000读者给予好评！', '1235', 'http://img3m2.ddimg.cn/32/4/23662022-1_w_9.jpg', '1');
INSERT INTO `books` VALUES ('20', '20', '追风筝的人', '5', '卡勒德·胡赛尼', '35.30', '“许多年过去了，人们说陈年旧事可以被埋葬，然而我终于明白这是错的，因为往事会自行爬上来。回首前尘，我意识到在过去二十六年里，自己始终在窥视着那荒芜的小径。”', '14141', 'http://img3m5.ddimg.cn/26/14/25238195-1_w_3.jpg', '1');
INSERT INTO `books` VALUES ('21', '21', '软件工程原理', '1', '陈昊鹏', '35.90', '从软件工程的本质出发、结合实际案例，系统全面地介绍软件过程、软件建模技术与方法及软件工程管理同时介绍一些热点新技术和新方法。', '1024', 'http://img3m6.ddimg.cn/32/30/1204489076-1_w_1.jpg', '1');
INSERT INTO `books` VALUES ('22', '22', '数据库系统概念', '1', '西尔伯沙茨', '74.20', '本书内容丰富，不仅讨论了关系数据模型和关系语言、数据库设计过程、关系数据库理论、数据库应用设计和开发、数据存储结构、数据存取技术、查询优化方法、事务处理系统和并发控制、故障恢复技术、数据仓库和数据挖掘，而且对性能调整、性能评测标准、数据库应用测试和标准化等高级应用主题进行了广泛讨论。', '244', 'http://img3m2.ddimg.cn/83/5/22632572-1_w_1.jpg', '1');
INSERT INTO `books` VALUES ('23', '23', '算法导论', '1', '科尔曼', '77.63', '全书选材经典、内容丰富、结构合理、逻辑清晰，对本科生的数据结构课程和研究生的算法课程都是非常实用的教材，在IT专业人员的职业生涯中，本书也是一本案头必备的参考书或工程实践手册。', '144', 'http://img3m8.ddimg.cn/89/15/1517005898-1_w_1.jpg', '1');
INSERT INTO `books` VALUES ('25', '25', '天龙八部(全五册)', '10', '金庸', '102.30', '《天龙八部》一书以北宋、辽、西夏、大理并立的历史为宏大背景，将儒释道、琴棋书画等中国传统文化融会贯通其中，书中人物繁多，个性鲜明，情节离奇，尽显芸芸众生百态。', '74745', 'http://img3m2.ddimg.cn/84/17/23273202-1_w_1.jpg', '1');
INSERT INTO `books` VALUES ('26', '26', '笑傲江湖(全四册)', '10', '金庸', '80.10', '一部《辟邪剑谱》引发灭门血案，阴险狡诈，机关算尽，只为争霸武林，真相往往出人意表。酒后高歌磨剑，梦中快意恩仇，一曲《笑傲江湖》，传一段天荒地老。 ', '2521', 'http://img3m0.ddimg.cn/82/15/23273200-1_w_1.jpg', '1');
INSERT INTO `books` VALUES ('27', '27', '楚留香传奇(全三册)', '10', '古龙', '224.50', '《楚留香传奇》无疑乃古龙诸作中*为烩炙人口之作，此作固成就古龙之盛名，更成为武侠文学之重要里程碑。楚留香有西方007罗杰摩尔之冷静、优雅、明快及幽默，更因他没有复仇及情爱之纠葛（例如他从来不杀人）而超越007，颇有“本来无一物，何处惹尘埃”的意境。', '551', 'http://img3m4.ddimg.cn/4/22/1592963464-1_w_1.jpg', '1');
INSERT INTO `books` VALUES ('28', '28', '哈利波特与魔法石', '10', 'J·K·罗琳', '30.20', '“沉湎于虚幻的梦想，而忘记现实的生活，这是毫无益处的，千万记住。”                                ——阿不思·邓布利多', '999', 'http://img3m1.ddimg.cn/88/0/25479421-1_w_1.jpg', '1');
INSERT INTO `books` VALUES ('29', '29', '哈利·波特与死亡圣器', '3', 'J·K·罗琳', '56.20', '两个人不能都活着，只有一个生存下来，我们中的一个将要永远离开……', '1551', 'http://img3m4.ddimg.cn/71/20/25479404-1_w_1.jpg', '1');
INSERT INTO `books` VALUES ('30', '30', '吞噬星空', '4', '我吃西红柿', '11.10', '科幻类网文精品之作品。很多年依然记得追更看这本小说的爽快和愉悦之情！也开创了起点的订阅记录！ 这部作品开始创作的时候正是打怪升级文的高热时期。', '1000', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1588483303031&di=f35cbeac2a3941426c527a8d3f0a160b&imgtype=0&src=http%3A%2F%2Ffile.quweiwu.com%2Ffckup%2F20140626%2F14037442412971.jpg', '1');
INSERT INTO `books` VALUES ('31', '31', '子夜', '6', '矛盾', '24.00', '《子夜》，原名《夕阳》，中国现代长篇小说，约30万字。半个多世纪以来，《子夜》不仅在中国拥有广泛的读者，且被译成英、德、俄、日等十几种文字，产生了广泛的国际影响。\r\n小说以1930年5、6月间半封建、半殖民地的旧上海为背景，以民族资本家吴荪甫为中心，描写了当时中国社会的各种矛盾和斗争。', '1000', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1588483491776&di=e2191e03306426fedc7d4907eab94739&imgtype=0&src=http%3A%2F%2Fhiphotos.baidu.com%2Fdoc%2Fpic%2Fitem%2F728da9773912b31b2fdf9a8a8e18367adbb4e1e6.jpg', '1');
INSERT INTO `books` VALUES ('32', '32', '无人生还', '7', '阿加莎 克瑞斯蒂', '23.00', '阿加莎的作品在推理圈来说应该是非常有名的，而且由她的作品改编的电视剧也有很多，其中最出名的应该是《无人生还》了，种种规划好的巧合，在最后的揭秘也显得尤为顺畅。', '1009', 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1502847236,2431720187&fm=26&gp=0.jpg', '1');
INSERT INTO `books` VALUES ('33', '33', '撒哈拉的故事', '8', '三毛', '22.00', '这是关于三毛和荷西的故事，这本书都是写的他们在沙漠中生活的故事，你会知道沙漠里的人怎么生活，有什么习惯以及所有温情和残忍。', '1079', 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1839435191,3097551468&fm=26&gp=0.jpg', '1');
INSERT INTO `books` VALUES ('34', '34', '三国志', '9', '陈寿', '24.00', '《三国志》，二十四史之一，是由西晋史学家陈寿所著，记载中国三国时期的曹魏、蜀汉、东吴纪传体国别史，是二十四史中评价最高的“前四史”之一. \r\n当时魏、吴两国已有史书，如官修的王沈《魏书》、私撰的鱼豢《魏略》、官修的韦昭《吴书》，此三书当是陈寿依据的基本材料。', '99', null, '1');
INSERT INTO `books` VALUES ('35', 'isbn ', 'write book name here', '1', 'write author here', '0.00', 'description ', '1', null, '1');

-- ----------------------------
-- Table structure for carts
-- ----------------------------
DROP TABLE IF EXISTS `carts`;
CREATE TABLE `carts` (
  `cartid` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`cartid`)
) ENGINE=MyISAM DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of carts
-- ----------------------------

-- ----------------------------
-- Table structure for orderitems
-- ----------------------------
DROP TABLE IF EXISTS `orderitems`;
CREATE TABLE `orderitems` (
  `orderItemId` int(11) NOT NULL AUTO_INCREMENT,
  `orderId` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `isorder` int(11) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `bookid` int(11) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  PRIMARY KEY (`orderItemId`),
  KEY `FKqq0yryifbyq3udsdji00qysmh` (`bookid`),
  KEY `FK1u6wgdi2nmp64all265wb1hp7` (`orderId`),
  KEY `FKknglpxvc6jw1dd7jhmfx4alk0` (`userid`),
  CONSTRAINT `FK1u6wgdi2nmp64all265wb1hp7` FOREIGN KEY (`orderId`) REFERENCES `orders` (`orderId`),
  CONSTRAINT `FKknglpxvc6jw1dd7jhmfx4alk0` FOREIGN KEY (`userid`) REFERENCES `users` (`userId`),
  CONSTRAINT `FKqq0yryifbyq3udsdji00qysmh` FOREIGN KEY (`bookid`) REFERENCES `books` (`bookid`),
  CONSTRAINT `orderitems_ibfk_1` FOREIGN KEY (`orderId`) REFERENCES `orders` (`orderId`)
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderitems
-- ----------------------------
INSERT INTO `orderitems` VALUES ('1', '1', '95.2', '1', '1', '1', '1');
INSERT INTO `orderitems` VALUES ('2', '2', '95.2', '1', '1', '1', '1');
INSERT INTO `orderitems` VALUES ('3', '2', '136.9', '1', '2', '2', '1');
INSERT INTO `orderitems` VALUES ('4', '2', '8.89', '1', '1', '4', '1');
INSERT INTO `orderitems` VALUES ('5', '3', '95.2', '1', '1', '1', '1');
INSERT INTO `orderitems` VALUES ('6', '3', '61.6', '1', '1', '10', '1');
INSERT INTO `orderitems` VALUES ('7', '3', '133.2', '1', '1', '16', '1');
INSERT INTO `orderitems` VALUES ('8', '4', '95.2', '1', '1', '1', '1');
INSERT INTO `orderitems` VALUES ('9', '6', '95.2', '1', '2', '1', '2');
INSERT INTO `orderitems` VALUES ('10', '6', '51.3', '1', '1', '3', '2');
INSERT INTO `orderitems` VALUES ('11', '5', '95.2', '1', '1', '1', '1');
INSERT INTO `orderitems` VALUES ('12', '5', '50.2', '1', '2', '7', '1');
INSERT INTO `orderitems` VALUES ('13', '7', '449.2', '1', '1', '6', '2');
INSERT INTO `orderitems` VALUES ('14', '28', '50.2', '1', '2', '7', '2');
INSERT INTO `orderitems` VALUES ('15', '8', '95.2', '1', '1', '1', '4');
INSERT INTO `orderitems` VALUES ('16', null, '51.3', '0', '1', '3', '4');
INSERT INTO `orderitems` VALUES ('17', '10', '56.7', '1', '2', '15', '1');
INSERT INTO `orderitems` VALUES ('18', '9', '30.2', '1', '1', '28', '1');
INSERT INTO `orderitems` VALUES ('19', '9', '95.2', '1', '1', '1', '1');
INSERT INTO `orderitems` VALUES ('20', '10', '95.2', '1', '2', '1', '1');
INSERT INTO `orderitems` VALUES ('22', '11', '8.89', '1', '1', '4', '1');
INSERT INTO `orderitems` VALUES ('23', '12', '136.9', '1', '3', '2', '1');
INSERT INTO `orderitems` VALUES ('24', '13', '95.2', '1', '1', '1', '1');
INSERT INTO `orderitems` VALUES ('26', '14', '8.89', '1', '3', '4', '1');
INSERT INTO `orderitems` VALUES ('27', '15', '91.2', '1', '1', '5', '1');
INSERT INTO `orderitems` VALUES ('28', '19', '136.9', '1', '1', '2', '5');
INSERT INTO `orderitems` VALUES ('29', '20', '8.89', '1', '2', '4', '5');
INSERT INTO `orderitems` VALUES ('30', '23', '449.2', '1', '1', '6', '5');
INSERT INTO `orderitems` VALUES ('31', '24', '104', '1', '1', '8', '5');
INSERT INTO `orderitems` VALUES ('32', '25', '51.3', '1', '1', '3', '5');
INSERT INTO `orderitems` VALUES ('33', '16', '95.2', '1', '1', '1', '1');
INSERT INTO `orderitems` VALUES ('34', '17', '95.2', '1', '1', '1', '1');
INSERT INTO `orderitems` VALUES ('35', '17', '8.89', '1', '1', '4', '1');
INSERT INTO `orderitems` VALUES ('36', '18', '95.2', '1', '1', '1', '1');
INSERT INTO `orderitems` VALUES ('37', '21', '95.2', '1', '1', '1', '1');
INSERT INTO `orderitems` VALUES ('38', '22', '136.9', '1', '1', '2', '1');
INSERT INTO `orderitems` VALUES ('39', '22', '8.89', '1', '1', '4', '1');
INSERT INTO `orderitems` VALUES ('40', '27', '95.2', '1', '2', '1', '1');
INSERT INTO `orderitems` VALUES ('41', '27', '51.3', '1', '1', '3', '1');
INSERT INTO `orderitems` VALUES ('42', '26', '8.89', '1', '1', '4', '5');
INSERT INTO `orderitems` VALUES ('43', '26', '95.2', '1', '2', '1', '5');
INSERT INTO `orderitems` VALUES ('44', '26', '136.9', '1', '1', '2', '5');
INSERT INTO `orderitems` VALUES ('45', null, '35.9', '0', '1', '13', '5');
INSERT INTO `orderitems` VALUES ('46', '27', '449.2', '1', '1', '6', '1');
INSERT INTO `orderitems` VALUES ('47', '35', '449.2', '1', '1', '6', '1');
INSERT INTO `orderitems` VALUES ('48', '28', '102.3', '1', '2', '25', '2');
INSERT INTO `orderitems` VALUES ('49', '28', '80.1', '1', '1', '26', '2');
INSERT INTO `orderitems` VALUES ('50', '28', '30.2', '1', '1', '28', '2');
INSERT INTO `orderitems` VALUES ('51', '28', '24', '1', '1', '31', '2');
INSERT INTO `orderitems` VALUES ('52', null, '86.2', '0', '2', '11', '6');
INSERT INTO `orderitems` VALUES ('53', null, '56.7', '0', '2', '15', '6');
INSERT INTO `orderitems` VALUES ('54', null, '104', '0', '1', '8', '6');
INSERT INTO `orderitems` VALUES ('55', '29', '95.2', '1', '1', '1', '7');
INSERT INTO `orderitems` VALUES ('56', '30', '136.9', '1', '1', '2', '7');
INSERT INTO `orderitems` VALUES ('57', '30', '51.3', '1', '1', '3', '7');
INSERT INTO `orderitems` VALUES ('58', '31', '95.2', '1', '2', '1', '7');
INSERT INTO `orderitems` VALUES ('59', '33', '136.9', '1', '3', '2', '7');
INSERT INTO `orderitems` VALUES ('60', '32', '95.2', '1', '1', '1', '7');
INSERT INTO `orderitems` VALUES ('61', '34', '95.2', '1', '2', '1', '7');
INSERT INTO `orderitems` VALUES ('64', '34', '136.9', '1', '1', '2', '7');
INSERT INTO `orderitems` VALUES ('65', '38', '95.2', '1', '1', '1', '7');
INSERT INTO `orderitems` VALUES ('66', '38', '449.2', '1', '1', '6', '7');
INSERT INTO `orderitems` VALUES ('67', null, '95.2', '0', '1', '1', '1');
INSERT INTO `orderitems` VALUES ('68', '36', '95.2', '1', '3', '1', '9');
INSERT INTO `orderitems` VALUES ('69', '36', '136.9', '1', '1', '2', '9');
INSERT INTO `orderitems` VALUES ('70', '37', '95.2', '1', '1', '1', '9');
INSERT INTO `orderitems` VALUES ('72', '39', '8.89', '1', '1', '4', '9');
INSERT INTO `orderitems` VALUES ('74', '40', '22', '1', '1', '33', '9');
INSERT INTO `orderitems` VALUES ('76', '41', '95.2', '1', '3', '1', '9');
INSERT INTO `orderitems` VALUES ('77', '42', '449.2', '1', '1', '6', '9');
INSERT INTO `orderitems` VALUES ('78', '43', '91.2', '1', '1', '5', '9');
INSERT INTO `orderitems` VALUES ('79', null, '95.2', '0', '3', '1', '9');
INSERT INTO `orderitems` VALUES ('80', '44', '136.9', '1', '3', '2', '9');
INSERT INTO `orderitems` VALUES ('81', '44', '51.3', '1', '2', '3', '9');
INSERT INTO `orderitems` VALUES ('82', '45', '136.9', '1', '1', '2', '9');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `orderId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`orderId`),
  KEY `FKpnm1eeupqm4tykds7k3okqegv` (`userId`),
  CONSTRAINT `FKpnm1eeupqm4tykds7k3okqegv` FOREIGN KEY (`userId`) REFERENCES `users` (`userId`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `users` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1', '1', '2020-05-02 17:53:56.000000');
INSERT INTO `orders` VALUES ('2', '1', '2020-05-02 18:06:17.000000');
INSERT INTO `orders` VALUES ('3', '1', '2020-05-03 13:20:23.000000');
INSERT INTO `orders` VALUES ('4', '1', '2020-05-03 13:28:13.000000');
INSERT INTO `orders` VALUES ('5', '1', '2020-05-04 20:10:59.000000');
INSERT INTO `orders` VALUES ('6', '2', '2020-05-04 22:20:42.000000');
INSERT INTO `orders` VALUES ('7', '2', '2020-05-04 22:21:00.000000');
INSERT INTO `orders` VALUES ('8', '4', '2020-05-04 22:42:56.000000');
INSERT INTO `orders` VALUES ('9', '1', '2020-05-05 09:28:22.000000');
INSERT INTO `orders` VALUES ('10', '1', '2020-05-05 10:52:17.000000');
INSERT INTO `orders` VALUES ('11', '1', '2020-05-06 13:17:35.000000');
INSERT INTO `orders` VALUES ('12', '1', '2020-05-06 13:31:15.000000');
INSERT INTO `orders` VALUES ('13', '1', '2020-05-06 13:31:31.000000');
INSERT INTO `orders` VALUES ('14', '1', '2020-05-14 20:14:13.000000');
INSERT INTO `orders` VALUES ('15', '1', '2020-05-14 20:15:13.000000');
INSERT INTO `orders` VALUES ('16', '1', '2020-05-14 20:17:33.000000');
INSERT INTO `orders` VALUES ('17', '1', '2020-05-14 20:17:51.000000');
INSERT INTO `orders` VALUES ('18', '1', '2020-05-14 20:21:00.000000');
INSERT INTO `orders` VALUES ('19', '5', '2020-05-14 20:41:20.000000');
INSERT INTO `orders` VALUES ('20', '5', '2020-05-14 20:42:18.000000');
INSERT INTO `orders` VALUES ('21', '1', '2020-05-14 21:02:00.000000');
INSERT INTO `orders` VALUES ('22', '1', '2020-05-14 21:02:14.000000');
INSERT INTO `orders` VALUES ('23', '5', '2020-05-14 21:20:52.000000');
INSERT INTO `orders` VALUES ('24', '5', '2020-05-14 21:21:46.000000');
INSERT INTO `orders` VALUES ('25', '5', '2020-05-28 14:52:23.000000');
INSERT INTO `orders` VALUES ('26', '5', '2020-05-31 10:40:12.000000');
INSERT INTO `orders` VALUES ('27', '1', '2020-06-02 00:49:47.000000');
INSERT INTO `orders` VALUES ('28', '2', '2020-06-15 15:02:32.000000');
INSERT INTO `orders` VALUES ('29', '7', '2020-06-18 16:47:52.000000');
INSERT INTO `orders` VALUES ('30', '7', '2020-06-18 16:49:16.000000');
INSERT INTO `orders` VALUES ('31', '7', '2020-06-19 13:27:35.000000');
INSERT INTO `orders` VALUES ('32', '7', '2020-06-19 18:08:53.000000');
INSERT INTO `orders` VALUES ('33', '7', '2020-06-19 19:29:44.000000');
INSERT INTO `orders` VALUES ('34', '7', '2020-06-19 22:26:37.000000');
INSERT INTO `orders` VALUES ('35', '1', '2020-06-19 22:59:57.000000');
INSERT INTO `orders` VALUES ('36', '9', '2020-06-20 10:44:49.000000');
INSERT INTO `orders` VALUES ('37', '9', '2020-06-20 10:45:30.000000');
INSERT INTO `orders` VALUES ('38', '7', '2020-07-03 16:51:47.000000');
INSERT INTO `orders` VALUES ('39', '9', '2020-07-03 16:55:00.000000');
INSERT INTO `orders` VALUES ('40', '9', '2020-07-03 17:02:17.000000');
INSERT INTO `orders` VALUES ('41', '9', '2020-07-03 19:51:41.000000');
INSERT INTO `orders` VALUES ('42', '9', '2020-07-03 19:59:30.000000');
INSERT INTO `orders` VALUES ('43', '9', '2020-07-03 20:07:08.000000');
INSERT INTO `orders` VALUES ('44', '9', '2020-07-04 11:06:34.000000');
INSERT INTO `orders` VALUES ('45', '9', '2020-07-04 11:07:59.000000');

-- ----------------------------
-- Table structure for types
-- ----------------------------
DROP TABLE IF EXISTS `types`;
CREATE TABLE `types` (
  `typeid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`typeid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of types
-- ----------------------------
INSERT INTO `types` VALUES ('1', '编程', '在看书、阅读前，一定先选择一门适合自己的编程语言。对0基础的同学，选择程序设计语言时先了解自己的学习能力。太难的语言，没有一定的基础，以及没有老师讲解、指引，太容易产生挫败感从而放弃。其次，如果自己有一点点明确的目的或需求，那么选一门对自己实际工作有帮助的语言！');
INSERT INTO `types` VALUES ('2', '儿童文学', '儿童文学，是专为少年儿童创作的文学作品。儿童文学特别要求通俗易懂，生动活泼。不同年龄阶段的读者对象，儿童文学又分为婴儿文学、幼年文学、童年文学、少年文学，体裁有儿歌、儿童诗、童话等。偏于文学，适合3至17岁阅读，老少均可品味。');
INSERT INTO `types` VALUES ('3', '魔幻小说', '魔幻小说，是魔法幻想类小说的简称，定义于非严谨的欧美奇幻小说框架下，以欧式奇幻世界参照创作，以魔法世界为特色的幻想风格小说。');
INSERT INTO `types` VALUES ('4', '科幻小说', '科幻小说全称科学幻想小说，直译应为科学虚构小说（英语全称：Science Fiction Novel），是一种起源于近代西方的文学体裁。\r\n其定义为在尊重科学结论的基础上进行合理设想（而非妄想，否则就是科学奇幻小说）而创作出的文艺，一般认为优秀的科幻小说须具备“逻辑自洽”、“科学元素”、“人文思考”三要素。');
INSERT INTO `types` VALUES ('5', '世界名著', '世界名著指的是在世界范围内得到广泛认可和关注的著作，其价值由于已经超越了时代本身而得以流传。需要注意的是，广义的世界名著不仅仅包含文学名著，还包括社科名著，人文名著等。');
INSERT INTO `types` VALUES ('6', '社会小说', '社会小说是19世纪法国小说创作的一种倾向，30年代后从浪漫主义文学思潮中逐渐演化而来。这种倾向既不同于浪漫主义的追求神秘的场景、理想化的人物和曲折迷离的情节、直露的激情，更不同于为文艺而文艺派的把小说视为与现实无关的纯艺术品，而是以客观现实生活为深厚根基，着力反映社会存在的问题，并通过艺术形象提出作者的见解。');
INSERT INTO `types` VALUES ('7', '悬疑小说', '悬疑小说是以一个悬念贯穿始终并且解开的小说，其内容和题材相对自由广泛，不像恐怖小说通常都会有让人感到害怕的场景和气氛，悬疑小说则未必要有。');
INSERT INTO `types` VALUES ('8', '青春文学', '青春文学，又称青春美文，刚开始它的概念离文学的距离还是远的，它的作者基本上是年轻人，他们写的作品大部分的意思没有很深的内涵，都是回忆青春或懵懂之年的爱情故事。');
INSERT INTO `types` VALUES ('9', '传记文学', '传记文学是运用除虚构以外的多种文学艺术手法，再现人物生平经历和事迹，展现人物的精神风貌，刻画其鲜明形象和生动个性的一种文学体裁。');
INSERT INTO `types` VALUES ('10', '武侠小说', '武侠小说是中国旧通俗小说的一种重要类型，多以侠客和义士为主人公，描写他们身怀绝技、见义勇为和叛逆造反行为。中国第一部具有真正意义的长篇武侠小说《三侠五义》，后世武侠小说有广义和狭义之分，广义上是指传统武侠、浪子异侠、历史武侠、谐趣武侠。');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `isbanned` int(11) NOT NULL,
  `userType` int(11) NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'akangakang', 'Liu Shuchang', '18257770522', '上海交通', '975376945@qq.com', 'lsc586970', '0', '1');
INSERT INTO `users` VALUES ('2', 'Mocking', 'Li han', '18767759969', '浙江', 'lihan@zju.edu.cn', '1124', '0', '0');
INSERT INTO `users` VALUES ('3', 'Kaokao', 'Liu Wenkao', '135877186018', '乐清市三中', 'kaokao@qq.com', 'lwk12345', '0', '0');
INSERT INTO `users` VALUES ('4', 'lanlian', 'Kong Weifen', '13587781096', '虹桥中学', '2@qq.com', '123', '0', '0');
INSERT INTO `users` VALUES ('5', '1', '1', '1', '1', '1@qq.com', '1', '1', '0');
INSERT INTO `users` VALUES ('6', '2', '2', '2', '2', '2@qq.com', '2', '1', '0');
INSERT INTO `users` VALUES ('7', '3', '3', '3', '3', '3@qq.com', '3', '0', '0');
INSERT INTO `users` VALUES ('8', '4', '4', '4', '4', '4@qq.com', '4', '0', '0');
INSERT INTO `users` VALUES ('9', '1', '5', '1', '1', '1@qq.com', '5', '0', '0');
